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
			System.out.println(OrderExtraction.password);
			conn = DriverManager.getConnection(OrderExtraction.dgUrl, OrderExtraction.user, OrderExtraction.password);
			OrderExtraction.conn.setAutoCommit(false);
			System.out.println("=================Connected");
			
			statementQuery = conn.createStatement();
			statementPreUpdate = conn.createStatement();
			statementAfterUpdate = conn.createStatement();
			sqlOrderNumber = "SELECT orderNumber FROM DCDW.ti_FreightChargeDetail WHERE extractedFlag = 'N' LIMIT 500";
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
				if(result.substring(0, 13).equals("Successfully!") && OrderExtraction.insertedFlag.equals("Y")) {
					statementAfterUpdate.executeUpdate("UPDATE DCDW.ti_FreightChargeDetail SET extractedFlag = 'Y' WHERE extractedFlag = 'N' AND orderNumber = '" + orderNumber + "'");
					OrderExtraction.conn.commit();
					OrderExtraction.insertedFlag = "N";
					System.out.println("=================Updated");
				}
				
				//Write log
	            LogFile.write(result);
	            System.out.println(result);
							
			}
			
			if(result == null) {
				result = "No orders need to extract!";//Write log
	            LogFile.write("======================================");
	            LogFile.write(OrderOutbound.dateTime);
				LogFile.write(result);
				System.out.println(result);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result = result + e.toString() +"\n";
            LogFile.write("======================================");
            LogFile.write(OrderOutbound.dateTime);
			LogFile.write(result);
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
