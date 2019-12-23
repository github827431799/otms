package order;

import java.sql.SQLException;
import java.sql.Statement;

import com.DXC.Parex.map.Geocoder;
import com.DXC.Parex.map.util.MapUtil;

public class ExtractToStaging {
	
	public String load(Order order, PriceDetail priceDetail, ShipFrom shipFrom,
			ShipTo shipTo, OrderLine orderLine, DockAppointment dockAppointment, 
			Position position, OrderEvent orderEvent, PickupAssignedDriver pickupAssignedDriver, 
			DeliveryAssignedDriver deliveryAssignedDriver) throws SQLException {

		//variables fro connection and SQL scripts 
		Statement statementInsert = null;		
		String sqlOrder = null;
		String sqlPriceDetail = null;
		String sqlShipFrom = null;
		String sqlShipTo = null;
		String sqlOrderLine = null;
		String sqlDockAppointment = null;
		String sqlPosition = null;
		String sqlOrderEvent = null;
		String sqlPickupAssignedDriver = null;
		String sqlDeliveryAssignedDriver = null;
		String sqlDistance = null;
		
		//Result
		String result = null;
		
		//Variables for calling Baidu webservice
		MapUtil mapUtil = null;
		Geocoder from = null;
		Geocoder to = null;
		int distance = 0;
		String distanceResult = null;
		
		
		//Get distance by call Baidu webservice		
		try {
			 mapUtil = new MapUtil();
			 from = mapUtil.getGeocoder(shipFrom.getAddress(0).replace(" ", ""));
			 to = mapUtil.getGeocoder(shipTo.getAddress(0).replace(" ", ""));
			 //System.out.println(from.getLat());
			 //System.out.println(to.getLng());
			 
			 distance = mapUtil.getDistance(from, to);
			 //System.out.println(distance);
			 distanceResult = from.getLat() + "; " + to.getLng();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			distanceResult = e.toString();
		}
		System.out.println("=================GotDistance");
		
		//Insert data to DB
		try {	
			//Create statement
			statementInsert = OrderExtraction.conn.createStatement();					
			
			//Execute SQL for Order
			sqlOrder = "INSERT INTO EX_Order(partnerCode,partnerName,partnerHeadOfficeCode,orderNumber,erpNumber," + 
					"price,consolidationId,rateAdjustments,billAccepted,vat,pickupSla,deliverySla,orderStatus," + 
					"remark,location,totalWeight,totalVolume,totalQuantity,totalInsurance,customText1,customText2," + 
					"customText3,customText4,customText5,customText6,customText7,customText8,customText9," + 
					"customText10,customText11,customText12,customText13,customText14,customText15,customText16," + 
					"customText17,customText18,customText19,customText20,customText21,customText22,customText23," + 
					"customText24,customText25,customText26,customText27,customText28,customText29,customText30," +
					"customNum1,customNum2,customNum3,customNum4,customNum5,customNum6,customNum7,customNum8," +
					"customNum9,customNum10,customEnum1,customEnum2,customEnum3,customEnum4,customEnum5," +
					"customEnum6,customEnum7,customEnum8,customEnum9,customEnum10,customEnum1zh,customEnum2zh,customEnum3zh," +
					"customEnum4zh,customEnum5zh,customEnum6zh,customEnum7zh,customEnum8zh,customEnum9zh,customEnum10zh," +
					"customEnum1en,customEnum2en,customEnum3en,customEnum4en,customEnum5en,customEnum6en,customEnum7en," +
					"customEnum8en,customEnum9en,customEnum10en,cargoType," +
					"metaSource,metaCreateOn,metaCreatedBy) " +
					"VALUES('" + order.getPartnerCode() + "','" + order.getPartnerName() + "','" + order.getPartnerHeadOfficeCode() + "','" + 
					             order.getOrderNumber() + "','" + order.getErpNumber() + "','" + order.getPrice() + "','" +
					             order.getConsolidationId() + "','" + order.getRateAdjustments() + "','" + order.getBillAccepted() + "','" +
					             order.getVat() + "','" + order.getPickupSla() + "','" + order.getDeliverySla() + "','" +
					             order.getOrderStatus() + "','" + order.getRemark() + "','" + order.getLocation() + "','" + 
					             order.getTotalWeight() + "','" + order.getTotalVolume() + "','" + order.getTotalQuantity() + "','" + 
					             order.getTotalInsurance() + "','" + order.getCustomText1() + "','" + order.getCustomText2() + "','" + 
					             order.getCustomText3() + "','" + order.getCustomText4() + "','" + order.getCustomText5() + "','" + 
					             order.getCustomText6() + "','" + order.getCustomText7() + "','" + order.getCustomText8() + "','" + 
					             order.getCustomText9() + "','" + order.getCustomText10() + "','" + order.getCustomText11() + "','" + 
					             order.getCustomText12() + "','" + order.getCustomText13() + "','" +
					             order.getCustomText14() + "','" + order.getCustomText15() + "','" + order.getCustomText16() + "','" + 
					             order.getCustomText17() + "','" + order.getCustomText18() + "','" + order.getCustomText19() + "','" + 
					             order.getCustomText20() + "','" + order.getCustomText21() + "','" + order.getCustomText22() + "','" + 
					             order.getCustomText23() + "','" + order.getCustomText24() + "','" + order.getCustomText25() + "','" + 
					             order.getCustomText26() + "','" + order.getCustomText27() + "','" + order.getCustomText28() + "','" + 
					             order.getCustomText29() + "','" + order.getCustomText30() + "','" + order.getCustomNum1() + "','" +
					             order.getCustomNum2() + "','" + order.getCustomNum3() + "','" + order.getCustomNum4() + "','" + 
					             order.getCustomNum5() + "','" + order.getCustomNum6() + "','" + order.getCustomNum7() + "','" + 
					             order.getCustomNum8() + "','" + order.getCustomNum9() + "','" + order.getCustomNum10() + "','" + 
					             order.getCustomEnum1() + "','" + order.getCustomEnum2() + "','" + order.getCustomEnum3() + "','" + 
					             order.getCustomEnum4() + "','" + order.getCustomEnum5() + "','" + order.getCustomEnum6() + "','" + 
					             order.getCustomEnum7() + "','" + order.getCustomEnum8() + "','" + order.getCustomEnum9() + "','" + 
					             order.getCustomEnum10() + "','" + order.getCustomEnum1Zh() + "','" + order.getCustomEnum2Zh() + "','" + 
					             order.getCustomEnum3Zh() + "','" + order.getCustomEnum4Zh() + "','" + order.getCustomEnum5Zh() + "','" + 
					             order.getCustomEnum6Zh() + "','" + order.getCustomEnum7Zh() + "','" + order.getCustomEnum8Zh() + "','" + 
					             order.getCustomEnum9Zh() + "','" + order.getCustomEnum10Zh() + "','" + order.getCustomEnum1En() + "','" + 
					             order.getCustomEnum2En() + "','" + order.getCustomEnum3En() + "','" + order.getCustomEnum4En() + "','" + 
					             order.getCustomEnum5En() + "','" + order.getCustomEnum6En() + "','" + order.getCustomEnum7En() + "','" + 
					             order.getCustomEnum8En() + "','" + order.getCustomEnum9En() + "','" + order.getCustomEnum10En() + "','" + 
					             order.getCargoType() + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";
			statementInsert.executeUpdate(sqlOrder);
			OrderOutbound.orderCount = OrderOutbound.orderCount + statementInsert.getUpdateCount();
			
			//Execute SQL for PriceDetail
			for(int i = 0; i < priceDetail.getSize(); i++) {
				sqlPriceDetail = "INSERT INTO EX_PriceDetail(orderNumber,name,rate,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + priceDetail.getName(i) + "','" + priceDetail.getRate(i) + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";			
				statementInsert.executeUpdate(sqlPriceDetail);
				OrderOutbound.priceDetailCount = OrderOutbound.priceDetailCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for ShipFrom
			for(int i = 0; i < shipFrom.getSize(); i++) {
				sqlShipFrom = "INSERT INTO EX_ShipFrom(orderNumber,name,externalId,province,town,county,address,contactName,contactMobile," +
			            "contactEmail,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + shipFrom.getName(i) + "','" + shipFrom.getExternalId(i) + "','" + 
						shipFrom.getProvince(i) + "','" + shipFrom.getTown(i) + "','" + shipFrom.getCountry(i) + "','" + 
						shipFrom.getAddress(i) + "','" + shipFrom.getContactName(i) + "','" + shipFrom.getContactMobile(i) + "','" + 
						shipFrom.getContactEmail(i) + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";				
				statementInsert.executeUpdate(sqlShipFrom);
				OrderOutbound.shipFromCount = OrderOutbound.shipFromCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for ShipTo
			for(int i = 0; i < shipTo.getSize(); i++) {
				sqlShipTo = "INSERT INTO EX_ShipTo(orderNumber,name,externalId,province,town,county,address,contactName,contactMobile," +
			            "contactEmail,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + shipTo.getName(i) + "','" + shipTo.getExternalId(i) + "','" + 
						shipTo.getProvince(i) + "','" + shipTo.getTown(i) + "','" + shipTo.getCountry(i) + "','" + 
						shipTo.getAddress(i) + "','" + shipTo.getContactName(i) + "','" + shipTo.getContactMobile(i) + "','" + 
						shipTo.getContactEmail(i) + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";				
				statementInsert.executeUpdate(sqlShipTo);
				OrderOutbound.shipToCount = OrderOutbound.shipToCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for OrderLine
			for(int i = 0; i < orderLine.getSize(); i++) {
				sqlOrderLine = "INSERT INTO EX_OrderLine(orderNumber,productCode,productName,quantity,volume,weight," +
			            "customText1,customText2," +
			            "customText3,customText4,customText5,customText6,customText7,customText8,customText9," +
			            "customText10,customText11,customText12,customText13,customText14,customText15,customText16," +
			            "customText17,customText18,customText19,customText20,customText21,customText22,customText23," + 
			            "customText24,customText25,customText26,customText27,customText28,customText29,customText30," +
			            "customNum1,customNum2,customNum3,customNum4,customNum5,customNum6,customNum7,customNum8," +
			            "customNum9,customNum10,customEnum1,customEnum2,customEnum3,customEnum4,customEnum5," +
			            "customEnum6,customEnum7,customEnum8,customEnum9,customEnum10,customEnum1zh,customEnum2zh,customEnum3zh," +
			            "customEnum4zh,customEnum5zh,customEnum6zh,customEnum7zh,customEnum8zh,customEnum9zh,customEnum10zh," +
			            "customEnum1en,customEnum2en,customEnum3en,customEnum4en,customEnum5en,customEnum6en,customEnum7en," +
			            "customEnum8en,customEnum9en,customEnum10en," +
			            "metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + orderLine.getProductCode(i) + "','" + orderLine.getProductName(i) + "','" + 
						orderLine.getQuantity(i) + "','" + orderLine.getVolume(i) + "','" + orderLine.getWeight(i) + "','" + 
			             order.getCustomText1() + "','" + order.getCustomText2() + "','" +  
			             order.getCustomText3() + "','" + order.getCustomText4() + "','" + order.getCustomText5() + "','" + 
			             order.getCustomText6() + "','" + order.getCustomText7() + "','" + order.getCustomText8() + "','" + 
			             order.getCustomText9() + "','" + order.getCustomText10() + "','" + order.getCustomText11() + "','" + 
			             order.getCustomText12() + "','" + order.getCustomText13() + "','" +
			             order.getCustomText14() + "','" + order.getCustomText15() + "','" + order.getCustomText16() + "','" + 
			             order.getCustomText17() + "','" + order.getCustomText18() + "','" + order.getCustomText19() + "','" + 
			             order.getCustomText20() + "','" + order.getCustomText21() + "','" + order.getCustomText22() + "','" + 
			             order.getCustomText23() + "','" + order.getCustomText24() + "','" + order.getCustomText25() + "','" + 
			             order.getCustomText26() + "','" + order.getCustomText27() + "','" + order.getCustomText28() + "','" + 
			             order.getCustomText29() + "','" + order.getCustomText30() + "','" + order.getCustomNum1() + "','" +
			             order.getCustomNum2() + "','" + order.getCustomNum3() + "','" + order.getCustomNum4() + "','" + 
			             order.getCustomNum5() + "','" + order.getCustomNum6() + "','" + order.getCustomNum7() + "','" + 
			             order.getCustomNum8() + "','" + order.getCustomNum9() + "','" + order.getCustomNum10() + "','" + 
			             order.getCustomEnum1() + "','" + order.getCustomEnum2() + "','" + order.getCustomEnum3() + "','" + 
			             order.getCustomEnum4() + "','" + order.getCustomEnum5() + "','" + order.getCustomEnum6() + "','" + 
			             order.getCustomEnum7() + "','" + order.getCustomEnum8() + "','" + order.getCustomEnum9() + "','" + 
			             order.getCustomEnum10() + "','" + order.getCustomEnum1Zh() + "','" + order.getCustomEnum2Zh() + "','" + 
			             order.getCustomEnum3Zh() + "','" + order.getCustomEnum4Zh() + "','" + order.getCustomEnum5Zh() + "','" + 
			             order.getCustomEnum6Zh() + "','" + order.getCustomEnum7Zh() + "','" + order.getCustomEnum8Zh() + "','" + 
			             order.getCustomEnum9Zh() + "','" + order.getCustomEnum10Zh() + "','" + order.getCustomEnum1En() + "','" + 
			             order.getCustomEnum2En() + "','" + order.getCustomEnum3En() + "','" + order.getCustomEnum4En() + "','" + 
			             order.getCustomEnum5En() + "','" + order.getCustomEnum6En() + "','" + order.getCustomEnum7En() + "','" + 
			             order.getCustomEnum8En() + "','" + order.getCustomEnum9En() + "','" + order.getCustomEnum10En() + "','" + 
						 "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";		
				statementInsert.executeUpdate(sqlOrderLine);
				OrderOutbound.orderLineCount = OrderOutbound.orderLineCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for DockAppointment
			for(int i = 0; i < dockAppointment.getSize(); i++) {
				sqlDockAppointment = "INSERT INTO EX_DockAppointment(orderNumber,expectedArrivalTime,driverName,truckPlate,driverMobile,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + dockAppointment.getExpectedArrivalTime(i) + "','" + dockAppointment.getDriverName(i) + "','" + 
						dockAppointment.getTruckPlate(i) + "','" + dockAppointment.getDriverMobile(i) + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";				
				statementInsert.executeUpdate(sqlDockAppointment);
				OrderOutbound.dockAppointmentCount = OrderOutbound.dockAppointmentCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for Position
			for(int i = 0; i < position.getSize(); i++) {
				sqlPosition = "INSERT INTO EX_Position(orderNumber,truckPlate,address,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + position.getTruckPlate(i) + "','" + position.getAddress(i) + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";				
				statementInsert.executeUpdate(sqlPosition);
				OrderOutbound.positionCount = OrderOutbound.positionCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for OrderEvent
			for(int i = 0; i < orderEvent.getSize(); i++) {
				sqlOrderEvent = "INSERT INTO EX_OrderEvent(orderNumber,name,time,operationTime,latitude,longitude,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + orderEvent.getName(i) + "','" + orderEvent.getTime(i) + "','" + 
						orderEvent.getOperationTime(i) + "','" + orderEvent.getLatitude(i) + "','" + orderEvent.getLongitude(i) + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";				
				statementInsert.executeUpdate(sqlOrderEvent);
				OrderOutbound.orderEventCount = OrderOutbound.orderEventCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for PickupAssignedDriver
			for(int i = 0; i < pickupAssignedDriver.getSize(); i++) {
				sqlPickupAssignedDriver = "INSERT INTO EX_PickupAssignedDriver(orderNumber,driverName,mobile,truckPlate,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + pickupAssignedDriver.getDriverName(i) + "','" + pickupAssignedDriver.getMoble(i) + "','" + 
						pickupAssignedDriver.getTruckPlate(i) + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";				
				statementInsert.executeUpdate(sqlPickupAssignedDriver);
				OrderOutbound.pickupAssignedDriverCount = OrderOutbound.pickupAssignedDriverCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for DeliveryAssignedDriver
			for(int i = 0; i < deliveryAssignedDriver.getSize(); i++) {
				sqlDeliveryAssignedDriver = "INSERT INTO EX_DeliveryAssignedDriver(orderNumber,driverName,mobile,truckPlate,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
						order.getOrderNumber() + "','" + deliveryAssignedDriver.getDriverName(i) + "','" + deliveryAssignedDriver.getMoble(i) + "','" + 
						deliveryAssignedDriver.getTruckPlate(i) + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";				
				statementInsert.executeUpdate(sqlDeliveryAssignedDriver);
				OrderOutbound.deliveryAssignedDriverCount = OrderOutbound.deliveryAssignedDriverCount + statementInsert.getUpdateCount();
			}
			
			//Execute SQL for Distance
			sqlDistance = "INSERT INTO EX_Distance(orderNumber,distanceMeter," +
		            "metaComment,metaSource,metaCreateOn,metaCreatedBy) VALUES('" + 
					order.getOrderNumber() + "','" + distance + "','" + 
					distanceResult + "','" + "OTMS" + "','" + OrderOutbound.dateTime + "','" + "" +"')";				
			statementInsert.executeUpdate(sqlDistance);
			OrderOutbound.distanceCount = OrderOutbound.distanceCount + statementInsert.getUpdateCount();
			
			//Commit one transaction
			OrderExtraction.conn.commit();
			System.out.println("=================Inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result = result + e.toString() +"\n";
		}finally {			
			if (statementInsert != null) {
				statementInsert.close();
			}
			
		}//try
		
		return result;
	}//load method

}
