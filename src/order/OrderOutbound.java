package order;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderOutbound {
	
	//Statistics for orders inserted into DB
	public static Integer orderCount = 0;
	public static Integer priceDetailCount = 0;
	public static Integer shipFromCount = 0;
	public static Integer shipToCount = 0;
	public static Integer orderLineCount = 0;
	public static Integer dockAppointmentCount = 0;
	public static Integer positionCount = 0;
	public static Integer orderEventCount = 0;
	public static Integer pickupAssignedDriverCount = 0;
	public static Integer deliveryAssignedDriverCount = 0;
	public static Integer distanceCount = 0;
	
	//Timestamp for generating order
	public static String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());    
	
	
	public String extractOrder(String orderNumber, String otmsUrl) throws IOException {
		
		// TODO Auto-generated method stub
		//**********************
		//Call OTMS web service by POST(HttpURLConnection). 
		//Send XML(include user/password) to server using getOutputStream.
		//Get response with XML using getInputStream.
		//URL: https://login.otms.cn/ws/orderOutbound
		//Method: POST
		//content-type: application/xml;charset=UTF-8
		URL url = null;
		HttpURLConnection connection = null;
		String outputXml = null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		String result = null;
		ParseXml parseXml = null;
				
		try{			
			//Create URL, not WSDL	
	        url = new URL(otmsUrl);
	        connection = (HttpURLConnection) url.openConnection();
	        //Set parameters
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("content-type", "application/xml;charset=UTF-8");
	        //Output default = false
	        connection.setDoOutput(true);
	        
	        //Get output XML for request
	        outputXml = createOuputXml(orderNumber);
	        outputStream = connection.getOutputStream();
	        outputStream.write(outputXml.getBytes());
	        
	        //Get response and input XML
	        int responseCode = connection.getResponseCode();
	        if(responseCode == 200){//success
	        
	        	//Get order from XML
	        	inputStream = connection.getInputStream();
				System.out.println("=================Responsed"); 
	        	parseXml = new ParseXml();
	        	result = parseXml.getOrder(inputStream);
	            
	        }else {
	        	result = result + "responseCode: " + responseCode +"\n";
	        }
	        
	        
		}catch(Exception e){
			e.printStackTrace();
			result = result + e.toString() +"\n";
		}finally {
			if (outputStream != null) {
				//System.out.println(outputStream);
				outputStream.close();
			}			
			if (inputStream != null) {
				//System.out.println(inputStream);
				inputStream.close();
			}
			
		}//try
		
		if(result == null) {
			result = "Successfully!\r\n" + 
					 "Orders inserted into DB:\r\n" +
		             "EX_Order: " + orderCount + "\r\n" + 
		             "EX_PriceDetail: " + priceDetailCount + "\r\n" + 
		             "EX_ShipFrom: " + shipFromCount + "\r\n" + 
		             "EX_ShipTo: " + shipToCount + "\r\n" + 
		             "EX_OrderLine: " + orderLineCount + "\r\n" + 
		             "EX_DockAppointment: " + dockAppointmentCount + "\r\n" + 
		             "EX_Position: " + positionCount + "\r\n" + 
		             "EX_OrderEvent: " + orderEventCount + "\r\n" + 
		             "EX_PickupAssignedDriver: " + pickupAssignedDriverCount + "\r\n" + 
		             "EX_DeliveryAssignedDriver: " + deliveryAssignedDriverCount + "\r\n" + 
		             "EX_Distance: " + distanceCount + "\r\n";
			if (orderCount != 0) {
				OrderExtraction.insertedFlag = "Y";
			}
			orderCount = 0;
			priceDetailCount = 0;
			shipFromCount = 0;
			shipToCount = 0;
			orderLineCount = 0;
			dockAppointmentCount = 0;
			positionCount = 0;
			orderEventCount = 0;
			pickupAssignedDriverCount = 0;
			deliveryAssignedDriverCount = 0;
			distanceCount = 0;
		}
		
		return result;
		
    }
	
	//Create output XML for request
	public String createOuputXml(String orderNumber){

		String outputXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
				"<orderOutboundRequest version=\"0.1\" login=\"dvwbg5qi\" password=\"HxX7Gust35QASqjQ\">\r\n" + 
				"    <queries>\r\n" + 
				"        <query>\r\n" + 
				"            <attribute>orderNumber</attribute>\r\n" + 
				"            <eq>" + orderNumber + "</eq>\r\n" + 
				"        </query>\r\n" + 
				"    </queries>\r\n" + 
				"    <includeOrderInfo>true</includeOrderInfo>\r\n" +
				"    <includeOrderPosition>true</includeOrderPosition>\r\n" +
				"    <!--<existDiscrepancy>true</existDiscrepancy>-->\r\n" +
				"    <includeLocationHistory>true</includeLocationHistory>\r\n" +
				"    <includePortableDevice>true</includePortableDevice>\r\n" +
				"    <includeLocationEvent>true</includeLocationEvent>\r\n" +
				"    <includeRejection>true</includeRejection>\r\n" +
				"    <includeDiscrepancny>true</includeDiscrepancny>\r\n" +
				"    <includeTruckAndDriver>true</includeTruckAndDriver>\r\n" +
				"    <includeMilestoneEvent>true</includeMilestoneEvent>\r\n" +
				"    <includeExceptionEvent>true</includeExceptionEvent>\r\n" +
				"    <includeCompensation>true</includeCompensation>\r\n" +
				"    <includePickupDeliveryPoint>true</includePickupDeliveryPoint>\r\n" +
				"    <includeClient>true</includeClient>\r\n" +
				"    <includeVendor>true</includeVendor>\r\n" +
				"    <includeOrderLine>true</includeOrderLine>\r\n" +
				"    <start>1</start>\r\n" + 
				"    <count>100</count>\r\n" + 
				"</orderOutboundRequest>";
		return outputXml;
	}
				
	

}
