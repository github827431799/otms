package order;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.io.InputStream;

public class OrderExtraction {
	
	//For log file path
	public static String logFilePath = null;
	public static String user = null;
	public static String password = null;		
	public static String dgUrl = null;
	public static Connection conn = null;		
	public static String insertedFlag = "N";	

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		OrderOutbound orderOutbound = null;
		//String otmsUrl = "https://login.otms.cn/ws/orderOutbound";
		String otmsUrl = args[0];
		//SQL Server
		//String dgUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=DGOTMS";
		//MySQL
		String filePath = null;
		String host = null;
		String port = null;
		String db = null;		
		InputStream inputStream = null;
		Properties props = null;
		String orderNumber = null;
		Statement statementQuery = null;
		Statement statementPreUpdate = null;
		Statement statementAfterUpdate = null;
		String sqlOrderNumber = null;
		String result = null;
		List<String> list = new ArrayList<String>();
				
		//Get orderNumber from dgUrl
		try {
			//Log file path
			logFilePath = args[2] + "\\DGOTMS\\log_DGOTMS_OrderExtraction.log";
			
			//SQL Server
			//conn = DriverManager.getConnection(dgUrl, "sa", "ctf3531136!!!!!!");
			//MySQL
			filePath = args[1] + "\\CustomerProperties\\DBConnections.properties";
			inputStream = new BufferedInputStream (new FileInputStream(filePath));
			props = new Properties();
			props.load(inputStream);
			Enumeration<?> en = props.propertyNames();  
	        while (en.hasMoreElements()) {  
	            String key = (String) en.nextElement();  
	            String property = props.getProperty(key);  
	            if (key.equals("DGOTMS_host")) {
	            	host = property;
	            }else if(key.equals("DGOTMS_port")) {
	            	port = property;
	            	
	            }else if(key.equals("DGOTMS_db")) {
	            	db = property;
	            	
	            }else if(key.equals("DGOTMS_user")) {
	            	OrderExtraction.user = property;
	            	
	            }else if(key.equals("DGOTMS_password")) {
	            	OrderExtraction.password = property;
	            	
	            }
	            
	        }  		
	        OrderExtraction.password = OrderExtraction.password.replace("Encrypted ", "");
	        OrderExtraction.password = Encr.decryptPassword(OrderExtraction.password);
	        OrderExtraction.dgUrl = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useUnicode=true&characterEncoding=utf8&useSSL=false";
				
			//System.out.println(dgUrl);
			//System.out.println(user);
			//System.out.println(OrderExtraction.password);
			conn = DriverManager.getConnection(OrderExtraction.dgUrl, OrderExtraction.user, OrderExtraction.password);
			OrderExtraction.conn.setAutoCommit(false);
			System.out.println("=================Connected");
			
			statementQuery = conn.createStatement();
			statementPreUpdate = conn.createStatement();
			statementAfterUpdate = conn.createStatement();
			//For splitting into two JAR files
			sqlOrderNumber = "SELECT orderNumber FROM " + 
					"(SELECT orderNumber, @rowNUm := @rowNUm + 1 AS rowNum FROM " +
					"(SELECT orderNumber fROM DCDW.ti_FreightChargeDetail WHERE yearMonth >= DATE_FORMAT(DATE_ADD(NOW(), INTERVAL -7 DAY),'%Y%m') AND (deliverySla >= DATE_ADD(NOW(), INTERVAL -7 DAY) OR deliverySla IS NULL) ORDER BY orderNUmber) AS t1, (SELECT @rowNum := 0 AS rowNUm) AS t2) AS t3 " +
					"WHERE rowNum <= ROUND((SELECT COUNT(*) fROM DCDW.ti_FreightChargeDetail WHERE yearMonth >= DATE_FORMAT(DATE_ADD(NOW(), INTERVAL -7 DAY),'%Y%m') AND (deliverySla >= DATE_ADD(NOW(), INTERVAL -7 DAY) OR deliverySla IS NULL))/2);";
			/*//For generating one JAR file
			sqlOrderNumber = "SELECT orderNumber FROM " + 
					"(SELECT orderNumber, @rowNUm := @rowNUm + 1 AS rowNum FROM " +
					"(SELECT orderNumber fROM DCDW.ti_FreightChargeDetail WHERE yearMonth >= DATE_FORMAT(DATE_ADD('" + args[3] + "', INTERVAL -7 DAY),'%Y%m') AND (deliverySla >= DATE_ADD('\" + args[3] + \"', INTERVAL -7 DAY) OR deliverySla IS NULL) ORDER BY orderNUmber) AS t1, (SELECT @rowNum := 0 AS rowNUm) AS t2) AS t3;";								
			*/
			ResultSet rs = statementQuery.executeQuery(sqlOrderNumber);
						
			//Add ResultSet into List
			while(rs.next()) {
				list.add(rs.getString("orderNumber"));
			}
			System.out.println("=================Added");
			
			//Extracting orders into DB from web service of OTMS
			for (String tempOrderNumber : list) {
				orderNumber = tempOrderNumber;
				
				//Delete tables before extracting when orderNumber exists
				statementPreUpdate.executeUpdate("INSERT INTO EX_PriceDetail_His SELECT orderNumber,name,rate,metaComment,metaIsEffective," + 
				        "metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
				        "metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_PriceDetail WHERE orderNumber = '" + orderNumber + "';"); 
				statementPreUpdate.executeUpdate("INSERT INTO EX_ShipFrom_His SELECT orderNumber,name,externalId,province,town,county,address," + 
				        "contactName,contactMobile,contactEmail,metaComment,metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_ShipFrom WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("INSERT INTO EX_ShipTo_His SELECT orderNumber,name,externalId,province,town,county,address," +
						"contactName,contactMobile,contactEmail,metaComment,metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_ShipTo WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("INSERT INTO EX_OrderLine_His SELECT orderNumber,productCode,productName,quantity,volume," +
						"weight,customText1,customText2," + 
						"customText3,customText4,customText5,customText6,customText7,customText8,customText9," + 
						"customText10,customText11,customText12,customText13,customText14,customText15," + 
						"customText16,customText17,customText18,customText19,customText20,customText21," + 
						"customText22,customText23,customText24,customText25,customText26,customText27," + 
						"customText28,customText29,customText30,customNum1,customNum2,customNum3,customNum4," + 
						"customNum5,customNum6,customNum7,customNum8,customNum9,customNum10,customEnum1," + 
						"customEnum2,customEnum3,customEnum4,customEnum5,customEnum6,customEnum7,customEnum8," + 
						"customEnum9,customEnum10,customEnum1zh,customEnum2zh,customEnum3zh,customEnum4zh," + 
						"customEnum5zh,customEnum6zh,customEnum7zh,customEnum8zh,customEnum9zh,customEnum10zh," + 
						"customEnum1en,customEnum2en,customEnum3en,customEnum4en,customEnum5en,customEnum6en," + 
						"customEnum7en,customEnum8en,customEnum9en,customEnum10en,metaComment,metaIsEffective," + 
						"metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_OrderLine WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("INSERT INTO EX_DockAppointment_His SELECT orderNumber,expectedArrivalTime,driverName,truckPlate," +
						"driverMobile,metaComment,metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_DockAppointment WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("INSERT INTO EX_Position_His SELECT orderNumber,truckPlate,address,metaComment,metaIsEffective," + 
						"metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_Position WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("INSERT INTO EX_OrderEvent_His SELECT orderNumber,name,time,operationTime,latitude,longitude," + 
						"metaComment,metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_OrderEvent WHERE orderNumber = '" + orderNumber + "';"); 
				statementPreUpdate.executeUpdate("INSERT INTO EX_PickupAssignedDriver_His SELECT orderNumber,driverName,mobile,truckPlate," + 
						"metaComment,metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_PickupAssignedDriver WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("INSERT INTO EX_DeliveryAssignedDriver_His SELECT orderNumber,driverName,mobile,truckPlate," + 
						"metaComment,metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_DeliveryAssignedDriver WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("INSERT INTO EX_Order_His SELECT partnerCode,partnerName,partnerHeadOfficeCode,orderNumber," + 
						"erpNumber,price,consolidationId,rateAdjustments,billAccepted,vat,pickupSla,deliverySla," + 
						"orderStatus,remark,location,totalWeight,totalVolume,totalQuantity,totalInsurance," + 
						"customText1,customText2,customText3,customText4,customText5,customText6,customText7," + 
						"customText8,customText9,customText10,customText11,customText12,customText13," + 
						"customText14,customText15,customText16,customText17,customText18,customText19," + 
						"customText20,customText21,customText22,customText23,customText24,customText25," + 
						"customText26,customText27,customText28,customText29,customText30,customNum1," + 
						"customNum2,customNum3,customNum4,customNum5,customNum6,customNum7,customNum8," + 
						"customNum9,customNum10,customEnum1,customEnum2,customEnum3,customEnum4,customEnum5," + 
						"customEnum6,customEnum7,customEnum8,customEnum9,customEnum10,customEnum1zh,customEnum2zh," + 
						"customEnum3zh,customEnum4zh,customEnum5zh,customEnum6zh,customEnum7zh,customEnum8zh," + 
						"customEnum9zh,customEnum10zh,customEnum1en,customEnum2en,customEnum3en,customEnum4en," + 
						"customEnum5en,customEnum6en,customEnum7en,customEnum8en,customEnum9en,customEnum10en," + 
						"cargoType,metaComment,metaIsEffective,metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_Order WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("INSERT INTO EX_Distance_His SELECT orderNumber,distanceMeter,metaComment,metaIsEffective," + 
						"metaEffectiveFrom,metaEffectiveTo,metaSource,'" + 
						OrderOutbound.dateTime + "' AS metaCreateON," + 
						"metaCreatedBy,metaUpdateOn,metaUpdateBy FROM EX_Distance WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_PriceDetail WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_ShipFrom WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_ShipTo WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_OrderLine WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_DockAppointment WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_Position WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_OrderEvent WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_PickupAssignedDriver WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_DeliveryAssignedDriver WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_Order WHERE orderNumber = '" + orderNumber + "';");
				statementPreUpdate.executeUpdate("DELETE FROM EX_Distance WHERE orderNumber = '" + orderNumber + "';");
				OrderExtraction.conn.commit();
				System.out.println("=================Deleted");
				System.out.println("Requested orderNumber: " + orderNumber);
				//Extracting
				orderOutbound = new OrderOutbound();						
				result = orderOutbound.extractOrder(orderNumber, otmsUrl);
				
				//Update DGEX.EX_FreightChargeDetail after extracting successfully
				/*
				if(result.substring(0, 13).equals("Successfully!") && OrderExtraction.insertedFlag.equals("Y")) {
					statementAfterUpdate.executeUpdate("UPDATE DCDW.ti_FreightChargeDetail SET extractedFlag = 'Y' WHERE extractedFlag = 'N' AND orderNumber = '" + orderNumber + "'");
					OrderExtraction.conn.commit();
					OrderExtraction.insertedFlag = "N";
					System.out.println("=================Updated");
				}*/
				
				//Write log
	            //LogFile.write(result);
	            System.out.println(result);
							
			}
			
			if(result == null) {
				result = "No orders need to extract!";//Write log
	            //LogFile.write("======================================");
	            //LogFile.write(OrderOutbound.dateTime);
				//LogFile.write(result);
				System.out.println(result);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result = result + e.toString() +"\n";
            //LogFile.write("======================================");
            //LogFile.write(OrderOutbound.dateTime);
			//LogFile.write(result);
			System.out.println(result);
		}finally {		
			if (inputStream != null) {
				inputStream.close();
			}
			if (statementQuery != null) {
				statementQuery.close();
			}			
			if (statementPreUpdate != null) {
				statementPreUpdate.close();
			}			
			if (statementAfterUpdate != null) {
				statementAfterUpdate.close();
			}
			if (conn != null) {
				conn.close();
			}
			
		}//try	
		
		

	}

}
