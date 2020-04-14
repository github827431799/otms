package order;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

public class ParseXml {	
		
	//Parse XML using StAX(Streaming API for XML)
	public String getOrder(InputStream inputStream) throws IOException {		 
			 
		 XMLEvent event = null;
		 String qName = null;
	     XMLInputFactory factory = null;
	     XMLEventReader r = null;
	     Order order = new Order();
	     PriceDetail priceDetail = new PriceDetail();
	     ShipFrom shipFrom = new ShipFrom();
	     ShipTo shipTo = new ShipTo();
	     OrderLine orderLine = new OrderLine();
	     DockAppointment dockAppointment = new DockAppointment();
	     Position position = new Position();
	     OrderEvent orderEvent = new OrderEvent();
	     PickupAssignedDriver pickupAssignedDriver = new PickupAssignedDriver();
	     DeliveryAssignedDriver deliveryAssignedDriver = new DeliveryAssignedDriver();
	     ExtractToStaging extractToStaging = null;
	     
	     //Variable for priceDetail
	     String priceDetailName = null;
		 String	priceDetailRate = null;
		 
		 //Variable for shipFrom
	     String shipFromName = null;
	     String shipFromExternalId = null;
	     String shipFromProvince = null;
	     String shipFromTown = null;
	     String shipFromCounty = null;
	     String shipFromAddress = null;
	     String shipFromContactName = null;
	     String shipFromContactMobile = null;
	     String shipFromContactEmail = null;
	     
	     //Variable for shipTo
	     String shipToName = null;
	     String shipToExternalId = null;
	     String shipToProvince = null;
	     String shipToTown = null;
	     String shipToCounty = null;
	     String shipToAddress = null;
	     String shipToContactName = null;
	     String shipToContactMobile = null;
	     String shipToContactEmail = null;
	     
	     //Variable for orderLine
	     String orderLineProductCode = null;
	     String	orderLineProductName = null;	
	     String orderLineQuantity = null;
	     String orderLineVolume = null;		
	     String orderLineWeight = null;	
	     String orderLineCustomText1 = null;	
	     String orderLineCustomText2 = null;			
	     String orderLineCustomText3 = null;			
	     String orderLineCustomText4 = null;			
	     String orderLineCustomText5 = null;			
	     String orderLineCustomText6 = null;			
	     String orderLineCustomText7 = null;		
	     String orderLineCustomText8 = null;			
	     String orderLineCustomText9 = null;			
	     String orderLineCustomText10 = null;			
	     String orderLineCustomText11 = null;			
	     String orderLineCustomText12 = null;			
	     String orderLineCustomText13 = null;			
	     String orderLineCustomText14 = null;			
	     String orderLineCustomText15 = null;			
	     String orderLineCustomText16 = null;			
	     String orderLineCustomText17 = null;			
	     String orderLineCustomText18 = null;			
	     String orderLineCustomText19 = null;			
	     String orderLineCustomText20 = null;		
	     String orderLineCustomText21 = null;			
	     String orderLineCustomText22 = null;			
	     String orderLineCustomText23 = null;			
	     String orderLineCustomText24 = null;			
	     String orderLineCustomText25 = null;			
	     String orderLineCustomText26 = null;			
	     String orderLineCustomText27 = null;			
	     String orderLineCustomText28 = null;			
	     String orderLineCustomText29 = null;		
	     String orderLineCustomText30 = null;				
	     String orderLineCustomNum1 = null;				
	     String orderLineCustomNum2 = null;					
	     String orderLineCustomNum3 = null;					
	     String orderLineCustomNum4 = null;					
	     String orderLineCustomNum5 = null;					
	     String orderLineCustomNum6 = null;					
	     String orderLineCustomNum7 = null;					
	     String orderLineCustomNum8 = null;					
	     String orderLineCustomNum9 = null;					
	     String orderLineCustomNum10 = null;			
	     String orderLineCustomEnum1 = null;				
	     String orderLineCustomEnum2 = null;				
	     String orderLineCustomEnum3 = null;				
	     String orderLineCustomEnum4 = null;				
	     String orderLineCustomEnum5 = null;				
	     String orderLineCustomEnum6 = null;				
	     String orderLineCustomEnum7 = null;				
	     String orderLineCustomEnum8 = null;				
	     String orderLineCustomEnum9 = null;					
	     String orderLineCustomEnum10 = null;		
	     String orderLineCustomEnum1Zh = null;		
	     String orderLineCustomEnum2Zh = null;	
	     String orderLineCustomEnum3Zh = null;	
	     String orderLineCustomEnum4Zh = null;	
	     String orderLineCustomEnum5Zh = null;	
	     String orderLineCustomEnum6Zh = null;	
	     String orderLineCustomEnum7Zh = null;	
	     String orderLineCustomEnum8Zh = null;	
	     String orderLineCustomEnum9Zh = null;	
	     String orderLineCustomEnum10Zh = null;		
	     String orderLineCustomEnum1En = null;		
	     String orderLineCustomEnum2En = null;		
	     String orderLineCustomEnum3En = null;		
	     String orderLineCustomEnum4En = null;		
	     String orderLineCustomEnum5En = null;		
	     String orderLineCustomEnum6En = null;		
	     String orderLineCustomEnum7En = null;		
	     String orderLineCustomEnum8En = null;		
	     String orderLineCustomEnum9En = null;		
	     String orderLineCustomEnum10En = null;	
	     
	     //Variable for dockAppointment
	     String	dockAppointmentExpectedArrivalTime = null;
	     String	dockAppointmentDriverName = null;
	     String	dockAppointmentTruckPlate = null;
	     String	dockAppointmentDriverMobile = null;
	     
	     //Variable for position
	     String	positionTruckPlate = null;
	     String	positionAddress = null;
		 
		 //Variable for orderEvent
         String orderEventName = null;
         String orderEventTime = null;	
         String orderEventOperationTime = null;
         String orderEventLatitude = null;		
         String orderEventLongitude = null;	
         
         //Variable for pickupAssignedDriver
         String pickupDriverName = null;
         String pickupMobile = null;
         String pickupTruckPlate = null;
         
         //Variable for deliveryAssignedDriver
         String deliveryDriverName = null;
         String deliveryMobile = null;
         String deliveryTruckPlate = null;
         
         //Result
         String result = null;
				
		
		try {
			//Create XML event reader to read data using Streaming API for XML
			factory = XMLInputFactory.newInstance();
	        r = factory.createXMLEventReader(inputStream);  
	        
	        //Write log	        
            //LogFile.write("======================================");
            //LogFile.write(OrderOutbound.dateTime);
	        
	        //Use while to get event
	        while (r.hasNext()) {
	        	event = r.nextEvent();	
	        	
	        	if(event.isStartElement()) {
	        		qName = event.asStartElement().getName().getLocalPart();	 
	        		
	        		//Process every order
	        		switch(qName) {	            		
	        		case "partnerCode":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setPartnerCode(event.asCharacters().getData());
		        			//LogFile.write("partnerCode: " + order.getPartnerCode());
	        			}else {
	        				order.setPartnerCode(null);
	        				//LogFile.write("partnerCode: ");
	        			}	        			
	        			break;
	        		case "partnerName":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setPartnerName(event.asCharacters().getData());
		        			//LogFile.write("partnerName: " + order.getPartnerName());
	        			}else {
	        				order.setPartnerCode(null);
	        				//LogFile.write("partnerCode: ");
	        			}		        			
	        			break;
	        		case "partnerHeadOfficeCode":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setPartnerHeadOfficeCode(event.asCharacters().getData());
	        				//LogFile.write("partnerHeadOfficeCode: " + order.getPartnerHeadOfficeCode());
	        			}else {
	        				order.setPartnerHeadOfficeCode(null);
	        				//LogFile.write("partnerHeadOfficeCode: ");
	        			}           			
	        			break;
	        		case "orderNumber":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setOrderNumber(event.asCharacters().getData());
	        				//LogFile.write("orderNumber: " + order.getOrderNumber());
	        				System.out.println("Responsed orderNumber: " + order.getOrderNumber());
	        			}else {
	        				order.setOrderNumber(null);
	        				//LogFile.write("orderNumber: ");
	        			}  
	        			break;
	        		case "erpNumber":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setErpNumber(event.asCharacters().getData());
	        				//LogFile.write("erpNumber: " + order.getOrderNumber());
	        			}else {
	        				order.setErpNumber(null);
	        				//LogFile.write("erpNumber: ");
	        			}  
	        			break;
	        		case "price":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setPrice(event.asCharacters().getData());
	        				//LogFile.write("price: " + order.getPrice());
	        			}else {
	        				order.setPrice(null);
	        				//LogFile.write("price: ");
	        			}  
	        			break;  
	        			
	        		//priceDetails
	        		case "priceDetails":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "name":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				priceDetailName = event.asCharacters().getData();	 
	    		        				//LogFile.write("name: " + priceDetailName);
	    		        			}else {
	    		        				//LogFile.write("name: ");
	    		        			}  
	    	            			break;           		
	    	            		case "rate":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				priceDetailRate = event.asCharacters().getData();
	    		        				//LogFile.write("rate: " + priceDetailRate);
	    		        			}else {
	    		        				//LogFile.write("rate: ");
	    		        			}  
	    	            			break;
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("priceDetail")) {	
	    	            			//Set value for every priceDetail
    		        				priceDetail.setName(priceDetailName);
    		        				priceDetail.setRate(priceDetailRate);
    		        				priceDetailName = null;
    		        				priceDetailRate = null;
	    	            		}else if(event.asEndElement().getName().getLocalPart().equals("priceDetails")) {
	    	            			//End loop when processing all priceDetail successfully
	    	            			break;
	    	            		}	
	    	            	}
	        			}   
	        			break;

	        		case "consolidationId":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setConsolidationId(event.asCharacters().getData());
	        				//LogFile.write("consolidationId: " + order.getConsolidationId());
	        			}else {
	        				order.setConsolidationId(null);
	        				//LogFile.write("consolidationId: ");
	        			}          		
	        			break;   	
	        		case "rateAdjustments":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setRateAdjustments(event.asCharacters().getData());
	        				//LogFile.write("rateAdjustments: " + order.getRateAdjustments());
	        			}else {
	        				order.setRateAdjustments(null);
	        				//LogFile.write("rateAdjustments: ");
	        			}              			
	        			break;
	        		case "billAccepted":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setBillAccepted(event.asCharacters().getData());
	        				//LogFile.write("billAccepted: " + order.getBillAccepted());
	        			}else {
	        				order.setBillAccepted(null);
	        				//LogFile.write("billAccepted: ");
	        			} 
	        			break;	            		 	
	        		case "remark":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setRemark(event.asCharacters().getData());
	        				//LogFile.write("remark: " + order.getRemark());
	        			}else {
	        				order.setRemark(null);
	        				//LogFile.write("remark: ");
	        			} 
	        			break;    	            		 	
	        		case "location":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setLocation(event.asCharacters().getData());
	        				//LogFile.write("location: " + order.getLocation());
	        			}else {
	        				order.setLocation(null);
	        				//LogFile.write("location: ");
	        			} 
	        			break;	   
	        			
	        		//shipFrom
	        		case "shipFrom":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "name":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromName = event.asCharacters().getData();	 
	    		        				//LogFile.write("name: " + shipFromName);
	    		        			}else {
	    		        				//LogFile.write("name: ");
	    		        			}  
	    	            			break;           		
	    	            		case "externalId":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromExternalId = event.asCharacters().getData();
	    		        				//LogFile.write("externalId: " + shipFromExternalId);
	    		        			}else {
	    		        				//LogFile.write("externalId: ");
	    		        			}  
	    	            			break;     		
	    	            		case "province":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromProvince = event.asCharacters().getData();
	    		        				//LogFile.write("province: " + shipFromProvince);
	    		        			}else {
	    		        				//LogFile.write("province: ");
	    		        			}  
	    	            			break;     		
	    	            		case "town":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromTown = event.asCharacters().getData();
	    		        				//LogFile.write("town: " + shipFromTown);
	    		        			}else {
	    		        				//LogFile.write("town: ");
	    		        			}  
	    	            			break;     		
	    	            		case "county":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromCounty = event.asCharacters().getData();
	    		        				//LogFile.write("county: " + shipFromCounty);
	    		        			}else {
	    		        				//LogFile.write("county: ");
	    		        			}  
	    	            			break;     		
	    	            		case "address":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromAddress = event.asCharacters().getData();
	    		        				//LogFile.write("address: " + shipFromAddress);
	    		        			}else {
	    		        				//LogFile.write("address: ");
	    		        			}  
	    	            			break;      		
	    	            		case "contactName":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromContactName = event.asCharacters().getData();
	    		        				//LogFile.write("contactName: " + shipFromContactName);
	    		        			}else {
	    		        				//LogFile.write("contactName: ");
	    		        			}  
	    	            			break;     		
	    	            		case "contactMobile":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromContactMobile = event.asCharacters().getData();
	    		        				//LogFile.write("contactMobile: " + shipFromContactMobile);
	    		        			}else {
	    		        				//LogFile.write("contactMobile: ");
	    		        			}  
	    	            			break;     		
	    	            		case "contactPhone":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromContactMobile = event.asCharacters().getData();
	    		        				//LogFile.write("contactMobile: " + shipFromContactMobile);
	    		        			}else {
	    		        				//LogFile.write("contactMobile: ");
	    		        			}  
	    	            			break;   		
	    	            		case "contactEmail":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipFromContactEmail = event.asCharacters().getData();
	    		        				//LogFile.write("contactEmail: " + shipFromContactEmail);
	    		        			}else {
	    		        				//LogFile.write("contactEmail: ");
	    		        			}  
	    	            			break;
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("shipFrom")) {	
	    	            			//Set value for every shipFrom
	    	            			shipFrom.setName(shipFromName);
	    	            			shipFrom.setExternalId(shipFromExternalId);
	    	            			shipFrom.setProvince(shipFromProvince);
	    	            			shipFrom.setTown(shipFromTown);
	    	            			shipFrom.setCounty(shipFromCounty);
	    	            			shipFrom.setAddress(shipFromAddress);
	    	            			shipFrom.setContactName(shipFromContactName);
	    	            			shipFrom.setContactMobile(shipFromContactMobile);
	    	            			shipFrom.setContactEmail(shipFromContactEmail);
                                    shipFromName = null;
    		        			    shipFromExternalId = null;
    		        			    shipFromProvince = null;
    		        			    shipFromTown = null;
    		        			    shipFromCounty = null;
    		        			    shipFromAddress = null;
    		        			    shipFromContactName = null;
    		        			    shipFromContactMobile = null;
    		        			    shipFromContactEmail = null;
    		        				//End loop when processing all shipFrom successfully
	    	            			break;
	    	            		}
	    	            	}//if
	        			}//while for shipFrom  
	        			break;	
	        		
	        		//shipTo
	        		case "shipTo":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "name":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToName = event.asCharacters().getData();	 
	    		        				//LogFile.write("name: " + shipToName);
	    		        			}else {
	    		        				//LogFile.write("name: ");
	    		        			}  
	    	            			break;           		
	    	            		case "externalId":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToExternalId = event.asCharacters().getData();
	    		        				//LogFile.write("externalId: " + shipToExternalId);
	    		        			}else {
	    		        				//LogFile.write("externalId: ");
	    		        			}  
	    	            			break;     		
	    	            		case "province":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToProvince = event.asCharacters().getData();
	    		        				//LogFile.write("province: " + shipToProvince);
	    		        			}else {
	    		        				//LogFile.write("province: ");
	    		        			}  
	    	            			break;     		
	    	            		case "town":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToTown = event.asCharacters().getData();
	    		        				//LogFile.write("town: " + shipToTown);
	    		        			}else {
	    		        				//LogFile.write("town: ");
	    		        			}  
	    	            			break;     		
	    	            		case "county":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToCounty = event.asCharacters().getData();
	    		        				//LogFile.write("county: " + shipToCounty);
	    		        			}else {
	    		        				//LogFile.write("county: ");
	    		        			}  
	    	            			break;     		
	    	            		case "address":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToAddress = event.asCharacters().getData();
	    		        				//LogFile.write("address: " + shipToAddress);
	    		        			}else {
	    		        				//LogFile.write("address: ");
	    		        			}  
	    	            			break;      		
	    	            		case "contactName":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToContactName = event.asCharacters().getData();
	    		        				//LogFile.write("contactName: " + shipToContactName);
	    		        			}else {
	    		        				//LogFile.write("contactName: ");
	    		        			}  
	    	            			break;     		
	    	            		case "contactMobile":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToContactMobile = event.asCharacters().getData();
	    		        				//LogFile.write("contactMobile: " + shipToContactMobile);
	    		        			}else {
	    		        				//LogFile.write("contactMobile: ");
	    		        			}  
	    	            			break;     		
	    	            		case "contactPhone":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToContactMobile = event.asCharacters().getData();
	    		        				//LogFile.write("contactMobile: " + shipToContactMobile);
	    		        			}else {
	    		        				//LogFile.write("contactMobile: ");
	    		        			}  
	    	            			break;   		
	    	            		case "contactEmail":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				shipToContactEmail = event.asCharacters().getData();
	    		        				//LogFile.write("contactEmail: " + shipToContactEmail);
	    		        			}else {
	    		        				//LogFile.write("contactEmail: ");
	    		        			}  
	    	            			break;
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("shipTo")) {	
	    	            			//Set value for every shipTo
	    	            			shipTo.setName(shipToName);
	    	            			shipTo.setExternalId(shipToExternalId);
	    	            			shipTo.setProvince(shipToProvince);
	    	            			shipTo.setTown(shipToTown);
	    	            			shipTo.setCounty(shipToCounty);
	    	            			shipTo.setAddress(shipToAddress);
	    	            			shipTo.setContactName(shipToContactName);
	    	            			shipTo.setContactMobile(shipToContactMobile);
	    	            			shipTo.setContactEmail(shipToContactEmail);
	    	            			shipToName = null;
	    	            			shipToExternalId = null;
	    	            			shipToProvince = null;
	    	            			shipToTown = null;
	    	            			shipToCounty = null;
	    	            			shipToAddress = null;
	    	            			shipToContactName = null;
	    	            			shipToContactMobile = null;
	    	            			shipToContactEmail = null;
    		        				//End loop when processing all shipTo successfully
	    	            			break;
	    	            		}
	    	            	}//if
	        			}//while for shipTo
	        			break;		
	        			
	        		case "totalWeight":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setTotalWeight(event.asCharacters().getData());
	        				//LogFile.write("totalWeight: " + order.getTotalWeight());
	        			}else {
	        				order.setTotalWeight(null);
	        				//LogFile.write("totalWeight: ");
	        			} 
	        			break;  
	        		case "totalVolume":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setTotalVolume(event.asCharacters().getData());
	        				//LogFile.write("totalVolume: " + order.getTotalVolume());
	        			}else {
	        				order.setTotalVolume(null);
	        				//LogFile.write("totalVolume: ");
	        			} 
	        			break; 	 
	        		case "totalQuantity":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setTotalQuantity(event.asCharacters().getData());
	        				//LogFile.write("totalQuantity: " + order.getTotalQuantity());
	        			}else {
	        				order.setTotalQuantity(null);
	        				//LogFile.write("totalQuantity: ");
	        			} 
	        			break; 	 
	        		case "totalInsurance":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setTotalInsurance(event.asCharacters().getData());
	        				//LogFile.write("totalInsurance: " + order.getTotalInsurance());
	        			}else {
	        				order.setTotalInsurance(null);
	        				//LogFile.write("totalInsurance: ");
	        			} 
	        			break; 

	        		//orderLine
	        		case "orderLines":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "productCode":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineProductCode = event.asCharacters().getData();
	    		        				//LogFile.write("productCode: " + orderLineProductCode);
	    		        			}else {
	    		        				//LogFile.write("productCode: ");
	    		        			} 
	    	            			break;           		
	    	            		case "productName":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineProductName = event.asCharacters().getData();
	    		        				//LogFile.write("productName: " + orderLineProductName);
	    		        			}else {
	    		        				//LogFile.write("productName: ");
	    		        			} 
	    	            			break;         		
	    	            		case "quantity":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineQuantity = event.asCharacters().getData();
	    		        				//LogFile.write("quantity: " + orderLineQuantity);
	    		        			}else {
	    		        				//LogFile.write("quantity: ");
	    		        			} 
	    	            			break;      		
	    	            		case "volume":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineVolume = event.asCharacters().getData();
	    		        				//LogFile.write("volume: " + orderLineVolume);
	    		        			}else {
	    		        				//LogFile.write("volume: ");
	    		        			} 
	    	            			break;      		
	    	            		case "weight":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineWeight = event.asCharacters().getData();
	    		        				//LogFile.write("weight: " + orderLineWeight);
	    		        			}else {
	    		        				//LogFile.write("weight: ");
	    		        			} 
	    	            			break;        		
	    	            		case "customText1":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText1 = event.asCharacters().getData();
	    		        				//LogFile.write("customText1: " + orderLineCustomText1);
	    		        			}else {
	    		        				//LogFile.write("customText1: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customText2":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText2 = event.asCharacters().getData();
	    		        				//LogFile.write("customText2: " + orderLineCustomText2);
	    		        			}else {
	    		        				//LogFile.write("customText2: ");
	    		        			} 
	    	            			break;   		
	    	            		case "customText3":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText3 = event.asCharacters().getData();
	    		        				//LogFile.write("customText3: " + orderLineCustomText3);
	    		        			}else {
	    		        				//LogFile.write("customText3: ");
	    		        			} 
	    	            			break;   		
	    	            		case "customText4":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText4 = event.asCharacters().getData();
	    		        				//LogFile.write("customText4: " + orderLineCustomText4);
	    		        			}else {
	    		        				//LogFile.write("customText4: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText5":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText5 = event.asCharacters().getData();
	    		        				//LogFile.write("customText5: " + orderLineCustomText5);
	    		        			}else {
	    		        				//LogFile.write("customText5: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText6":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText6 = event.asCharacters().getData();
	    		        				//LogFile.write("customText6: " + orderLineCustomText6);
	    		        			}else {
	    		        				//LogFile.write("customText6: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText7":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText7 = event.asCharacters().getData();
	    		        				//LogFile.write("customText7: " + orderLineCustomText7);
	    		        			}else {
	    		        				//LogFile.write("customText7: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customText8":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText8 = event.asCharacters().getData();
	    		        				//LogFile.write("customText8: " + orderLineCustomText8);
	    		        			}else {
	    		        				//LogFile.write("customText8: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText9":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText9 = event.asCharacters().getData();
	    		        				//LogFile.write("customText9: " + orderLineCustomText9);
	    		        			}else {
	    		        				//LogFile.write("customText9: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText10":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText10 = event.asCharacters().getData();
	    		        				//LogFile.write("customText10: " + orderLineCustomText10);
	    		        			}else {
	    		        				//LogFile.write("customText10: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customText11":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText11 = event.asCharacters().getData();
	    		        				//LogFile.write("customText11: " + orderLineCustomText11);
	    		        			}else {
	    		        				//LogFile.write("customText11: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText12":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText12= event.asCharacters().getData();
	    		        				//LogFile.write("customText12: " + orderLineCustomText12);
	    		        			}else {
	    		        				//LogFile.write("customText12: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText13":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText13 = event.asCharacters().getData();
	    		        				//LogFile.write("customText13: " + orderLineCustomText13);
	    		        			}else {
	    		        				//LogFile.write("customText13: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText14":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText14 = event.asCharacters().getData();
	    		        				//LogFile.write("customText14: " + orderLineCustomText14);
	    		        			}else {
	    		        				//LogFile.write("customText14: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText15":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText15 = event.asCharacters().getData();
	    		        				//LogFile.write("customText15: " + orderLineCustomText15);
	    		        			}else {
	    		        				//LogFile.write("customText15: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText16":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText16 = event.asCharacters().getData();
	    		        				//LogFile.write("customText16: " + orderLineCustomText16);
	    		        			}else {
	    		        				//LogFile.write("customText16: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText17":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText17 = event.asCharacters().getData();
	    		        				//LogFile.write("customText17: " + orderLineCustomText17);
	    		        			}else {
	    		        				//LogFile.write("customText17: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText18":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText18 = event.asCharacters().getData();
	    		        				//LogFile.write("customText18: " + orderLineCustomText18);
	    		        			}else {
	    		        				//LogFile.write("customText18: ");
	    		        			} 
	    	            			break;    		
	    	            		case "customText19":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText19 = event.asCharacters().getData();
	    		        				//LogFile.write("customText19: " + orderLineCustomText19);
	    		        			}else {
	    		        				//LogFile.write("customText19: ");
	    		        			} 
	    	            			break;     		
	    	            		case "customText20":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText20 = event.asCharacters().getData();
	    		        				//LogFile.write("customText20: " + orderLineCustomText20);
	    		        			}else {
	    		        				//LogFile.write("customText20: ");
	    		        			} 
	    	            			break; 		     		
	    	            		case "customText21":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText21 = event.asCharacters().getData();
	    		        				//LogFile.write("customText21: " + orderLineCustomText21);
	    		        			}else {
	    		        				//LogFile.write("customText21: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText22":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText22 = event.asCharacters().getData();
	    		        				//LogFile.write("customText22: " + orderLineCustomText22);
	    		        			}else {
	    		        				//LogFile.write("customText22: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText23":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText23 = event.asCharacters().getData();
	    		        				//LogFile.write("customText23: " + orderLineCustomText23);
	    		        			}else {
	    		        				//LogFile.write("customText23: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText24":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText24 = event.asCharacters().getData();
	    		        				//LogFile.write("customText24: " + orderLineCustomText24);
	    		        			}else {
	    		        				//LogFile.write("customText24: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText25":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText25 = event.asCharacters().getData();
	    		        				//LogFile.write("customText25: " + orderLineCustomText25);
	    		        			}else {
	    		        				//LogFile.write("customText25: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText26":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText26 = event.asCharacters().getData();
	    		        				//LogFile.write("customText26: " + orderLineCustomText26);
	    		        			}else {
	    		        				//LogFile.write("customText26: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText27":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText27 = event.asCharacters().getData();
	    		        				//LogFile.write("customText27: " + orderLineCustomText27);
	    		        			}else {
	    		        				//LogFile.write("customText27: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText28":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText28 = event.asCharacters().getData();
	    		        				//LogFile.write("customText28: " + orderLineCustomText28);
	    		        			}else {
	    		        				//LogFile.write("customText28: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText29":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText29 = event.asCharacters().getData();
	    		        				//LogFile.write("customText29: " + orderLineCustomText29);
	    		        			}else {
	    		        				//LogFile.write("customText29: ");
	    		        			} 
	    	            			break; 	 		     		
	    	            		case "customText30":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomText30 = event.asCharacters().getData();
	    		        				//LogFile.write("customText30: " + orderLineCustomText30);
	    		        			}else {
	    		        				//LogFile.write("customText30: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum1":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum1 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum1: " + orderLineCustomNum1);
	    		        			}else {
	    		        				//LogFile.write("customNum1: ");
	    		        			} 
	    	            			break;  		
	    	            		case "customNum2":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum2 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum2: " + orderLineCustomNum2);
	    		        			}else {
	    		        				//LogFile.write("customNum2: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum3":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum3 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum3: " + orderLineCustomNum3);
	    		        			}else {
	    		        				//LogFile.write("customNum3: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum4":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum4 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum4: " + orderLineCustomNum4);
	    		        			}else {
	    		        				//LogFile.write("customNum4: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum5":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum5 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum5: " + orderLineCustomNum5);
	    		        			}else {
	    		        				//LogFile.write("customNum5: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum6":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum6 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum6: " + orderLineCustomNum6);
	    		        			}else {
	    		        				//LogFile.write("customNum6: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum7":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum7 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum7: " + orderLineCustomNum7);
	    		        			}else {
	    		        				//LogFile.write("customNum7: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum8":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum8 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum8: " + orderLineCustomNum8);
	    		        			}else {
	    		        				//LogFile.write("customNum8: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum9":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum9 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum9: " + orderLineCustomNum9);
	    		        			}else {
	    		        				//LogFile.write("customNum9: ");
	    		        			} 
	    	            			break; 		
	    	            		case "customNum10":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomNum10 = event.asCharacters().getData();
	    		        				//LogFile.write("customNum10: " + orderLineCustomNum10);
	    		        			}else {
	    		        				//LogFile.write("customNum10: ");
	    		        			} 
	    	            			break;    
	    	            		case "customEnum1":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum1 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum1: " + orderLineCustomEnum1);
	    		        			}else {
	    		        				//LogFile.write("customEnum1: ");
	    		        			} 
	    	            			break;     
	    	            		case "customEnum2":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum2 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum2: " + orderLineCustomEnum2);
	    		        			}else {
	    		        				//LogFile.write("customEnum2: ");
	    		        			} 
	    	            			break;    
	    	            		case "customEnum3":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum3 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum3: " + orderLineCustomEnum3);
	    		        			}else {
	    		        				//LogFile.write("customEnum3: ");
	    		        			} 
	    	            			break;    
	    	            		case "customEnum4":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum4 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum4: " + orderLineCustomEnum4);
	    		        			}else {
	    		        				//LogFile.write("customEnum4: ");
	    		        			} 
	    	            			break;    
	    	            		case "customEnum5":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum5 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum5: " + orderLineCustomEnum5);
	    		        			}else {
	    		        				//LogFile.write("customEnum5: ");
	    		        			} 
	    	            			break;    
	    	            		case "customEnum6":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum6 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum6: " + orderLineCustomEnum6);
	    		        			}else {
	    		        				//LogFile.write("customEnum6: ");
	    		        			} 
	    	            			break;    
	    	            		case "customEnum7":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum7 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum7: " + orderLineCustomEnum7);
	    		        			}else {
	    		        				//LogFile.write("customEnum7: ");
	    		        			} 
	    	            			break;    
	    	            		case "customEnum8":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum8 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum8: " + orderLineCustomEnum8);
	    		        			}else {
	    		        				//LogFile.write("customEnum8: ");
	    		        			} 
	    	            			break;    
	    	            		case "customEnum9":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum9 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum9: " + orderLineCustomEnum9);
	    		        			}else {
	    		        				//LogFile.write("customEnum9: ");
	    		        			} 
	    	            			break; 
	    	            		case "customEnum10":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum10 = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum10: " + orderLineCustomEnum10);
	    		        			}else {
	    		        				//LogFile.write("customEnum10: ");
	    		        			} 
	    	            			break;     		
	    	            		case "customEnum1Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum1Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum1Zh: " + orderLineCustomEnum1Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum1Zh: ");
	    		        			} 
	    	            			break;          		
	    	            		case "customEnum2Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum2Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum2Zh: " + orderLineCustomEnum2Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum2Zh: ");
	    		        			} 
	    	            			break;       		
	    	            		case "customEnum3Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum3Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum3Zh: " + orderLineCustomEnum3Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum3Zh: ");
	    		        			} 
	    	            			break;       		
	    	            		case "customEnum4Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum4Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum4Zh: " + orderLineCustomEnum4Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum4Zh: ");
	    		        			} 
	    	            			break;       		
	    	            		case "customEnum5Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum5Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum5Zh: " + orderLineCustomEnum5Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum5Zh: ");
	    		        			} 
	    	            			break;       		
	    	            		case "customEnum6Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum6Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum6Zh: " + orderLineCustomEnum6Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum6Zh: ");
	    		        			} 
	    	            			break;       		
	    	            		case "customEnum7Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum7Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum7Zh: " + orderLineCustomEnum7Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum7Zh: ");
	    		        			} 
	    	            			break;       		
	    	            		case "customEnum8Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum8Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum8Zh: " + orderLineCustomEnum8Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum8Zh: ");
	    		        			} 
	    	            			break;       		
	    	            		case "customEnum9Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum9Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum9Zh: " + orderLineCustomEnum9Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum9Zh: ");
	    		        			} 
	    	            			break;   		
	    	            		case "customEnum10Zh":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum10Zh = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum10Zh: " + orderLineCustomEnum10Zh);
	    		        			}else {
	    		        				//LogFile.write("customEnum10Zh: ");
	    		        			} 
	    	            			break;        		
	    	            		case "customEnum1En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum1En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum1En: " + orderLineCustomEnum1En);
	    		        			}else {
	    		        				//LogFile.write("customEnum1En: ");
	    		        			} 
	    	            			break; 		      		
	    	            		case "customEnum2En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum2En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum2En: " + orderLineCustomEnum2En);
	    		        			}else {
	    		        				//LogFile.write("customEnum2En: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customEnum3En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum3En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum3En: " + orderLineCustomEnum3En);
	    		        			}else {
	    		        				//LogFile.write("customEnum3En: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customEnum4En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum4En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum4En: " + orderLineCustomEnum4En);
	    		        			}else {
	    		        				//LogFile.write("customEnum4En: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customEnum5En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum5En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum5En: " + orderLineCustomEnum5En);
	    		        			}else {
	    		        				//LogFile.write("customEnum5En: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customEnum6En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum6En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum6En: " + orderLineCustomEnum6En);
	    		        			}else {
	    		        				//LogFile.write("customEnum6En: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customEnum7En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum7En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum7En: " + orderLineCustomEnum7En);
	    		        			}else {
	    		        				//LogFile.write("customEnum7En: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customEnum8En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum8En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum8En: " + orderLineCustomEnum8En);
	    		        			}else {
	    		        				//LogFile.write("customEnum8En: ");
	    		        			} 
	    	            			break;      		
	    	            		case "customEnum9En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum9En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum9En: " + orderLineCustomEnum9En);
	    		        			}else {
	    		        				//LogFile.write("customEnum9En: ");
	    		        			} 
	    	            			break;
	    	            		case "customEnum10En":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderLineCustomEnum10En = event.asCharacters().getData();
	    		        				//LogFile.write("customEnum10En: " + orderLineCustomEnum10En);
	    		        			}else {
	    		        				//LogFile.write("customEnum10En: ");
	    		        			} 
	    	            			break;
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("orderLine")) {	
	    	            			//Set value for every orderLine
	    	            			orderLine.setProductCode(orderLineProductCode);
	    	            			orderLine.setProductName(orderLineProductName);
	    	            			orderLine.setQuantity(orderLineQuantity);
	    	            			orderLine.setVolume(orderLineVolume);
	    	            			orderLine.setWeight(orderLineWeight);
	    	            			orderLine.setCustomText1(orderLineCustomText1);
	    	            			orderLine.setCustomText2(orderLineCustomText2);
	    	            			orderLine.setCustomText3(orderLineCustomText3);
	    	            			orderLine.setCustomText4(orderLineCustomText4);
	    	            			orderLine.setCustomText5(orderLineCustomText5);
	    	            			orderLine.setCustomText6(orderLineCustomText6);
	    	            			orderLine.setCustomText7(orderLineCustomText7);
	    	            			orderLine.setCustomText8(orderLineCustomText8);
	    	            			orderLine.setCustomText9(orderLineCustomText9);
	    	            			orderLine.setCustomText10(orderLineCustomText10);
	    	            			orderLine.setCustomText11(orderLineCustomText11);
	    	            			orderLine.setCustomText12(orderLineCustomText12);
	    	            			orderLine.setCustomText13(orderLineCustomText13);
	    	            			orderLine.setCustomText14(orderLineCustomText14);
	    	            			orderLine.setCustomText15(orderLineCustomText15);
	    	            			orderLine.setCustomText16(orderLineCustomText16);
	    	            			orderLine.setCustomText17(orderLineCustomText17);
	    	            			orderLine.setCustomText18(orderLineCustomText18);
	    	            			orderLine.setCustomText19(orderLineCustomText19);
	    	            			orderLine.setCustomText20(orderLineCustomText20);
	    	            			orderLine.setCustomText21(orderLineCustomText21);
	    	            			orderLine.setCustomText22(orderLineCustomText22);
	    	            			orderLine.setCustomText23(orderLineCustomText23);
	    	            			orderLine.setCustomText24(orderLineCustomText24);
	    	            			orderLine.setCustomText25(orderLineCustomText25);
	    	            			orderLine.setCustomText26(orderLineCustomText26);
	    	            			orderLine.setCustomText27(orderLineCustomText27);
	    	            			orderLine.setCustomText28(orderLineCustomText28);
	    	            			orderLine.setCustomText29(orderLineCustomText29);
	    	            			orderLine.setCustomText30(orderLineCustomText30);
	    	            			orderLine.setCustomNum1(orderLineCustomNum1);
	    	            			orderLine.setCustomNum2(orderLineCustomNum2);
	    	            			orderLine.setCustomNum3(orderLineCustomNum3);
	    	            			orderLine.setCustomNum4(orderLineCustomNum4);
	    	            			orderLine.setCustomNum5(orderLineCustomNum5);
	    	            			orderLine.setCustomNum6(orderLineCustomNum6);
	    	            			orderLine.setCustomNum7(orderLineCustomNum7);
	    	            			orderLine.setCustomNum8(orderLineCustomNum8);
	    	            			orderLine.setCustomNum9(orderLineCustomNum9);
	    	            			orderLine.setCustomNum10(orderLineCustomNum10);
	    	            			orderLine.setCustomEnum1(orderLineCustomEnum1);
	    	            			orderLine.setCustomEnum1(orderLineCustomEnum1);
	    	            			orderLine.setCustomEnum2(orderLineCustomEnum2);
	    	            			orderLine.setCustomEnum3(orderLineCustomEnum3);
	    	            			orderLine.setCustomEnum4(orderLineCustomEnum4);
	    	            			orderLine.setCustomEnum5(orderLineCustomEnum5);
	    	            			orderLine.setCustomEnum6(orderLineCustomEnum6);
	    	            			orderLine.setCustomEnum7(orderLineCustomEnum7);
	    	            			orderLine.setCustomEnum8(orderLineCustomEnum8);
	    	            			orderLine.setCustomEnum9(orderLineCustomEnum9);
	    	            			orderLine.setCustomEnum10(orderLineCustomEnum10);
	    	            			orderLine.setCustomEnum1Zh(orderLineCustomEnum1Zh);
	    	            			orderLine.setCustomEnum2Zh(orderLineCustomEnum2Zh);
	    	            			orderLine.setCustomEnum3Zh(orderLineCustomEnum3Zh);
	    	            			orderLine.setCustomEnum4Zh(orderLineCustomEnum4Zh);
	    	            			orderLine.setCustomEnum5Zh(orderLineCustomEnum5Zh);
	    	            			orderLine.setCustomEnum6Zh(orderLineCustomEnum6Zh);
	    	            			orderLine.setCustomEnum7Zh(orderLineCustomEnum7Zh);
	    	            			orderLine.setCustomEnum8Zh(orderLineCustomEnum8Zh);
	    	            			orderLine.setCustomEnum9Zh(orderLineCustomEnum9Zh);
	    	            			orderLine.setCustomEnum10Zh(orderLineCustomEnum10Zh);
	    	            			orderLine.setCustomEnum1En(orderLineCustomEnum1En);
	    	            			orderLine.setCustomEnum2En(orderLineCustomEnum2En);
	    	            			orderLine.setCustomEnum3En(orderLineCustomEnum3En);
	    	            			orderLine.setCustomEnum4En(orderLineCustomEnum4En);
	    	            			orderLine.setCustomEnum5En(orderLineCustomEnum5En);
	    	            			orderLine.setCustomEnum6En(orderLineCustomEnum6En);
	    	            			orderLine.setCustomEnum7En(orderLineCustomEnum7En);
	    	            			orderLine.setCustomEnum8En(orderLineCustomEnum8En);
	    	            			orderLine.setCustomEnum9En(orderLineCustomEnum9En);
	    	            			orderLine.setCustomEnum10En(orderLineCustomEnum10En);
	    	            			orderLineProductCode = null;
	    	            			orderLineProductName = null;	
	    	            			orderLineQuantity = null;
	    	            			orderLineVolume = null;		
	    	            			orderLineWeight = null;			
	    	            			orderLineCustomText1 = null;	
	    	            			orderLineCustomText2 = null;	
	    	            			orderLineCustomText3 = null;	
	    	            			orderLineCustomText4 = null;	
	    	            			orderLineCustomText5 = null;	
	    	            			orderLineCustomText6 = null;	
	    	            			orderLineCustomText7 = null;		
	    	            			orderLineCustomText8 = null;		
	    	            			orderLineCustomText9 = null;		
	    	            			orderLineCustomText10 = null;		
	    	            			orderLineCustomText11 = null;		
	    	            			orderLineCustomText12 = null;		
	    	            			orderLineCustomText13 = null;		
	    	            			orderLineCustomText14 = null;		
	    	            			orderLineCustomText15 = null;		
	    	            			orderLineCustomText16 = null;		
	    	            			orderLineCustomText17 = null;		
	    	            			orderLineCustomText18 = null;		
	    	            			orderLineCustomText19 = null;		
	    	            			orderLineCustomText20 = null;		
	    	            			orderLineCustomText21 = null;		
	    	            			orderLineCustomText22 = null;		
	    	            			orderLineCustomText23 = null;		
	    	            			orderLineCustomText24 = null;		
	    	            			orderLineCustomText25 = null;		
	    	            			orderLineCustomText26 = null;		
	    	            			orderLineCustomText27 = null;		
	    	            			orderLineCustomText28 = null;		
	    	            			orderLineCustomText29 = null;			
	    	            			orderLineCustomText30 = null;
	    	            			orderLineCustomNum1 = null;
	    	            			orderLineCustomNum2 = null;
	    	            			orderLineCustomNum3 = null;
	    	            			orderLineCustomNum4 = null;
	    	            			orderLineCustomNum5 = null;
	    	            			orderLineCustomNum6 = null;
	    	            			orderLineCustomNum7 = null;
	    	            			orderLineCustomNum8 = null;
	    	            			orderLineCustomNum9 = null;
	    	            			orderLineCustomNum10 = null;
	    	            			orderLineCustomEnum1 = null;	
	    	            			orderLineCustomEnum2 = null;	
	    	            			orderLineCustomEnum3 = null;	
	    	            			orderLineCustomEnum4 = null;	
	    	            			orderLineCustomEnum5 = null;	
	    	            			orderLineCustomEnum6 = null;	
	    	            			orderLineCustomEnum7 = null;	
	    	            			orderLineCustomEnum8 = null;	
	    	            			orderLineCustomEnum9 = null;	
	    	            			orderLineCustomEnum10 = null;		
	    	            			orderLineCustomEnum1Zh = null;			
	    	            			orderLineCustomEnum2Zh = null;			
	    	            			orderLineCustomEnum3Zh = null;			
	    	            			orderLineCustomEnum4Zh = null;			
	    	            			orderLineCustomEnum5Zh = null;			
	    	            			orderLineCustomEnum6Zh = null;			
	    	            			orderLineCustomEnum7Zh = null;			
	    	            			orderLineCustomEnum8Zh = null;			
	    	            			orderLineCustomEnum9Zh = null;		
	    	            			orderLineCustomEnum10Zh = null;		
	    	            			orderLineCustomEnum1En = null;	
	    	            			orderLineCustomEnum2En = null;		
	    	            			orderLineCustomEnum3En = null;		
	    	            			orderLineCustomEnum4En = null;		
	    	            			orderLineCustomEnum5En = null;		
	    	            			orderLineCustomEnum6En = null;		
	    	            			orderLineCustomEnum7En = null;		
	    	            			orderLineCustomEnum8En = null;		
	    	            			orderLineCustomEnum9En = null;		 	
	    	            			orderLineCustomEnum10En = null;	        			
	    	            		}else if(event.asEndElement().getName().getLocalPart().equals("orderLines")) {
	    	            			//End loop when processing all orderLine successfully
	    	            			break;
	    	            		}	
	    	            		
	    	            	}
	        			}   
	        			break;	
	        		
	        		case "customText1":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText1(event.asCharacters().getData());
	        				//LogFile.write("customText1: " + order.getCustomText1());
	        			}else {
	        				order.setCustomText1(null);
	        				//LogFile.write("customText1: ");
	        			} 
	        			break; 
	        		case "customText2":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText2(event.asCharacters().getData());
	        				//LogFile.write("customText2: " + order.getCustomText2());
	        			}else {
	        				order.setCustomText2(null);
	        				//LogFile.write("customText2: ");
	        			} 
	        			break; 
	        		case "customText3":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText3(event.asCharacters().getData());
	        				//LogFile.write("customText3: " + order.getCustomText3());
	        			}else {
	        				order.setCustomText3(null);
	        				//LogFile.write("customText3: ");
	        			} 
	        			break; 	
	        		case "customText4":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText4(event.asCharacters().getData());
	        				//LogFile.write("customText4: " + order.getCustomText4());
	        			}else {
	        				order.setCustomText4(null);
	        				//LogFile.write("customText4: ");
	        			} 
	        			break; 	 	
	        		case "customText5":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText5(event.asCharacters().getData());
	        				//LogFile.write("customText5: " + order.getCustomText5());
	        			}else {
	        				order.setCustomText5(null);
	        				//LogFile.write("customText5: ");
	        			} 
	        			break;  	
	        		case "customText6":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText6(event.asCharacters().getData());
	        				//LogFile.write("customText6: " + order.getCustomText6());
	        			}else {
	        				order.setCustomText6(null);
	        				//LogFile.write("customText6: ");
	        			} 
	        			break;  	
	        		case "customText7":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText7(event.asCharacters().getData());
	        				//LogFile.write("customText7: " + order.getCustomText7());
	        			}else {
	        				order.setCustomText7(null);
	        				//LogFile.write("customText7: ");
	        			} 
	        			break;  	
	        		case "customText8":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText8(event.asCharacters().getData());
	        				//LogFile.write("customText8: " + order.getCustomText8());
	        			}else {
	        				order.setCustomText8(null);
	        				//LogFile.write("customText8: ");
	        			} 
	        			break;  	
	        		case "customText9":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText9(event.asCharacters().getData());
	        				//LogFile.write("customText9: " + order.getCustomText9());
	        			}else {
	        				order.setCustomText9(null);
	        				//LogFile.write("customText9: ");
	        			} 
	        			break;  	
	        		case "customText10":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText10(event.asCharacters().getData());
	        				//LogFile.write("customText10: " + order.getCustomText10());
	        			}else {
	        				order.setCustomText10(null);
	        				//LogFile.write("customText10: ");
	        			} 
	        			break;  	
	        		case "customText11":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText11(event.asCharacters().getData());
	        				//LogFile.write("customText11: " + order.getCustomText11());
	        			}else {
	        				order.setCustomText11(null);
	        				//LogFile.write("customText11: ");
	        			} 
	        			break;  	
	        		case "customText12":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText12(event.asCharacters().getData());
	        				//LogFile.write("customText12: " + order.getCustomText12());
	        			}else {
	        				order.setCustomText12(null);
	        				//LogFile.write("customText12: ");
	        			} 
	        			break;  	
	        		case "customText13":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText13(event.asCharacters().getData());
	        				//LogFile.write("customText13: " + order.getCustomText13());
	        			}else {
	        				order.setCustomText13(null);
	        				//LogFile.write("customText13: ");
	        			} 
	        			break;  	
	        		case "customText14":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText14(event.asCharacters().getData());
	        				//LogFile.write("customText14: " + order.getCustomText14());
	        			}else {
	        				order.setCustomText4(null);
	        				//LogFile.write("customText14: ");
	        			} 
	        			break; 
	        		case "customText15":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText15(event.asCharacters().getData());
	        				//LogFile.write("customText15: " + order.getCustomText15());
	        			}else {
	        				order.setCustomText15(null);
	        				//LogFile.write("customText15: ");
	        			} 
	        			break; 	
	        		case "customText16":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText16(event.asCharacters().getData());
	        				//LogFile.write("customText16: " + order.getCustomText16());
	        			}else {
	        				order.setCustomText16(null);
	        				//LogFile.write("customText16: ");
	        			} 
	        			break; 	
	        		case "customText17":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText17(event.asCharacters().getData());
	        				//LogFile.write("customText17: " + order.getCustomText17());
	        			}else {
	        				order.setCustomText17(null);
	        				//LogFile.write("customText17: ");
	        			} 
	        			break; 	
	        		case "customText18":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText18(event.asCharacters().getData());
	        				//LogFile.write("customText18: " + order.getCustomText18());
	        			}else {
	        				order.setCustomText18(null);
	        				//LogFile.write("customText18: ");
	        			} 
	        			break; 	
	        		case "customText19":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText19(event.asCharacters().getData());
	        				//LogFile.write("customText19: " + order.getCustomText19());
	        			}else {
	        				order.setCustomText19(null);
	        				//LogFile.write("customText19: ");
	        			} 
	        			break; 	
	        		case "customText20":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText20(event.asCharacters().getData());
	        				//LogFile.write("customText20: " + order.getCustomText20());
	        			}else {
	        				order.setCustomText20(null);
	        				//LogFile.write("customText20: ");
	        			} 
	        			break; 	
	        		case "customText21":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText21(event.asCharacters().getData());
	        				//LogFile.write("customText21: " + order.getCustomText21());
	        			}else {
	        				order.setCustomText21(null);
	        				//LogFile.write("customText21: ");
	        			} 
	        			break;	
	        		case "customText22":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText22(event.asCharacters().getData());
	        				//LogFile.write("customText22: " + order.getCustomText22());
	        			}else {
	        				order.setCustomText22(null);
	        				//LogFile.write("customText22: ");
	        			} 
	        			break;		
	        		case "customText23":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText23(event.asCharacters().getData());
	        				//LogFile.write("customText23: " + order.getCustomText23());
	        			}else {
	        				order.setCustomText23(null);
	        				//LogFile.write("customText23: ");
	        			} 
	        			break;	
	        		case "customText24":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText24(event.asCharacters().getData());
	        				//LogFile.write("customText24: " + order.getCustomText24());
	        			}else {
	        				order.setCustomText24(null);
	        				//LogFile.write("customText24: ");
	        			} 
	        			break;	
	        		case "customText25":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText25(event.asCharacters().getData());
	        				//LogFile.write("customText25: " + order.getCustomText25());
	        			}else {
	        				order.setCustomText25(null);
	        				//LogFile.write("customText25: ");
	        			} 
	        			break;	
	        		case "customText26":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText26(event.asCharacters().getData());
	        				//LogFile.write("customText26: " + order.getCustomText26());
	        			}else {
	        				order.setCustomText26(null);
	        				//LogFile.write("customText26: ");
	        			} 
	        			break;
	        		case "customText27":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText27(event.asCharacters().getData());
	        				//LogFile.write("customText27: " + order.getCustomText27());
	        			}else {
	        				order.setCustomText27(null);
	        				//LogFile.write("customText27: ");
	        			} 
	        			break;	
	        		case "customText28":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText28(event.asCharacters().getData());
	        				//LogFile.write("customText28: " + order.getCustomText28());
	        			}else {
	        				order.setCustomText28(null);
	        				//LogFile.write("customText28: ");
	        			} 
	        			break;
	        		case "customText29":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText29(event.asCharacters().getData());
	        				//LogFile.write("customText29: " + order.getCustomText29());
	        			}else {
	        				order.setCustomText29(null);
	        				//LogFile.write("customText29: ");
	        			} 
	        			break;	
	        		case "customText30":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomText30(event.asCharacters().getData());
	        				//LogFile.write("customText30: " + order.getCustomText30());
	        			}else {
	        				order.setCustomText30(null);
	        				//LogFile.write("customText30: ");
	        			} 
	        			break;		
	        		case "customNum1":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum1(event.asCharacters().getData());
	        				//LogFile.write("customNum1: " + order.getCustomNum1());
	        			}else {
	        				order.setCustomEnum1(null);
	        				//LogFile.write("customNum1: ");
	        			} 
	        			break;			
	        		case "customNum2":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum2(event.asCharacters().getData());
	        				//LogFile.write("customNum2: " + order.getCustomNum2());
	        			}else {
	        				order.setCustomEnum2(null);
	        				//LogFile.write("customNum2: ");
	        			} 
	        			break;			
	        		case "customNum3":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum3(event.asCharacters().getData());
	        				//LogFile.write("customNum3: " + order.getCustomNum3());
	        			}else {
	        				order.setCustomEnum3(null);
	        				//LogFile.write("customNum3: ");
	        			} 
	        			break;			
	        		case "customNum4":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum4(event.asCharacters().getData());
	        				//LogFile.write("customNum4: " + order.getCustomNum4());
	        			}else {
	        				order.setCustomEnum4(null);
	        				//LogFile.write("customNum4: ");
	        			} 
	        			break;			
	        		case "customNum5":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum5(event.asCharacters().getData());
	        				//LogFile.write("customNum5: " + order.getCustomNum5());
	        			}else {
	        				order.setCustomEnum5(null);
	        				//LogFile.write("customNum5: ");
	        			} 
	        			break;			
	        		case "customNum6":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum6(event.asCharacters().getData());
	        				//LogFile.write("customNum6: " + order.getCustomNum6());
	        			}else {
	        				order.setCustomEnum6(null);
	        				//LogFile.write("customNum6: ");
	        			} 
	        			break;			
	        		case "customNum7":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum7(event.asCharacters().getData());
	        				//LogFile.write("customNum7: " + order.getCustomNum7());
	        			}else {
	        				order.setCustomEnum7(null);
	        				//LogFile.write("customNum7: ");
	        			} 
	        			break;			
	        		case "customNum8":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum8(event.asCharacters().getData());
	        				//LogFile.write("customNum8: " + order.getCustomNum8());
	        			}else {
	        				order.setCustomEnum8(null);
	        				//LogFile.write("customNum8: ");
	        			} 
	        			break;			
	        		case "customNum9":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum9(event.asCharacters().getData());
	        				//LogFile.write("customNum9: " + order.getCustomNum9());
	        			}else {
	        				order.setCustomEnum9(null);
	        				//LogFile.write("customNum9: ");
	        			} 
	        			break;			
	        		case "customNum10":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomNum10(event.asCharacters().getData());
	        				//LogFile.write("customNum10: " + order.getCustomNum10());
	        			}else {
	        				order.setCustomEnum10(null);
	        				//LogFile.write("customNum10: ");
	        			} 
	        			break;	
	        		case "customEnum1":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum1(event.asCharacters().getData());
	        				//LogFile.write("customEnum1: " + order.getCustomEnum1());
	        			}else {
	        				order.setCustomEnum1(null);
	        				//LogFile.write("customEnum1: ");
	        			} 
	        			break;		
	        		case "customEnum2":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum2(event.asCharacters().getData());
	        				//LogFile.write("customEnum2: " + order.getCustomEnum2());
	        			}else {
	        				order.setCustomEnum2(null);
	        				//LogFile.write("customEnum2: ");
	        			} 
	        			break;	
	        		case "customEnum3":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum3(event.asCharacters().getData());
	        				//LogFile.write("customEnum3: " + order.getCustomEnum3());
	        			}else {
	        				order.setCustomEnum3(null);
	        				//LogFile.write("customEnum3: ");
	        			} 
	        			break;	
	        		case "customEnum4":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum4(event.asCharacters().getData());
	        				//LogFile.write("customEnum4: " + order.getCustomEnum4());
	        			}else {
	        				order.setCustomEnum4(null);
	        				//LogFile.write("customEnum4: ");
	        			} 
	        			break;	
	        		case "customEnum5":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum5(event.asCharacters().getData());
	        				//LogFile.write("customEnum5: " + order.getCustomEnum5());
	        			}else {
	        				order.setCustomEnum5(null);
	        				//LogFile.write("customEnum5: ");
	        			} 
	        			break;	
	        		case "customEnum6":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum6(event.asCharacters().getData());
	        				//LogFile.write("customEnum6: " + order.getCustomEnum6());
	        			}else {
	        				order.setCustomEnum6(null);
	        				//LogFile.write("customEnum6: ");
	        			} 
	        			break;	
	        		case "customEnum7":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum7(event.asCharacters().getData());
	        				//LogFile.write("customEnum7: " + order.getCustomEnum7());
	        			}else {
	        				order.setCustomEnum7(null);
	        				//LogFile.write("customEnum7: ");
	        			} 
	        			break;	
	        		case "customEnum8":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum8(event.asCharacters().getData());
	        				//LogFile.write("customEnum8: " + order.getCustomEnum8());
	        			}else {
	        				order.setCustomEnum8(null);
	        				//LogFile.write("customEnum8: ");
	        			} 
	        			break;	
	        		case "customEnum9":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum9(event.asCharacters().getData());
	        				//LogFile.write("customEnum9: " + order.getCustomEnum9());
	        			}else {
	        				order.setCustomEnum9(null);
	        				//LogFile.write("customEnum9: ");
	        			} 
	        			break;	
	        		case "customEnum10":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum10(event.asCharacters().getData());
	        				//LogFile.write("customEnum10: " + order.getCustomEnum10());
	        			}else {
	        				order.setCustomEnum10(null);
	        				//LogFile.write("customEnum10: ");
	        			} 
	        			break;
	        		case "customEnum1Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum1Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum1Zh: " + order.getCustomEnum1Zh());
	        			}else {
	        				order.setCustomEnum1Zh(null);
	        				//LogFile.write("customEnum1Zh: ");
	        			} 
	        			break;		
	        		case "customEnum2Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum2Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum2Zh: " + order.getCustomEnum2Zh());
	        			}else {
	        				order.setCustomEnum2Zh(null);
	        				//LogFile.write("customEnum2Zh: ");
	        			} 
	        			break;	
	        		case "customEnum3Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum3Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum3Zh: " + order.getCustomEnum3Zh());
	        			}else {
	        				order.setCustomEnum3Zh(null);
	        				//LogFile.write("customEnum3Zh: ");
	        			} 
	        			break;	
	        		case "customEnum4Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum4Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum4Zh: " + order.getCustomEnum4Zh());
	        			}else {
	        				order.setCustomEnum4Zh(null);
	        				//LogFile.write("customEnum4Zh: ");
	        			} 
	        			break;	
	        		case "customEnum5Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum5Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum5Zh: " + order.getCustomEnum5Zh());
	        			}else {
	        				order.setCustomEnum5Zh(null);
	        				//LogFile.write("customEnum5Zh: ");
	        			} 
	        			break;		
	        		case "customEnum6Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum6Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum6Zh: " + order.getCustomEnum6Zh());
	        			}else {
	        				order.setCustomEnum6Zh(null);
	        				//LogFile.write("customEnum6Zh: ");
	        			} 
	        			break;		
	        		case "customEnum7Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum7Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum7Zh: " + order.getCustomEnum7Zh());
	        			}else {
	        				order.setCustomEnum7Zh(null);
	        				//LogFile.write("customEnum7Zh: ");
	        			} 
	        			break;	
	        		case "customEnum8Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum8Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum8Zh: " + order.getCustomEnum8Zh());
	        			}else {
	        				order.setCustomEnum8Zh(null);
	        				//LogFile.write("customEnum8Zh: ");
	        			} 
	        			break;	
	        		case "customEnum9Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum9Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum9Zh: " + order.getCustomEnum9Zh());
	        			}else {
	        				order.setCustomEnum9Zh(null);
	        				//LogFile.write("customEnum9Zh: ");
	        			} 
	        			break;	
	        		case "customEnum10Zh":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum10Zh(event.asCharacters().getData());
	        				//LogFile.write("customEnum10Zh: " + order.getCustomEnum10Zh());
	        			}else {
	        				order.setCustomEnum10Zh(null);
	        				//LogFile.write("customEnum10Zh: ");
	        			} 
	        			break;
	        		case "customEnum1En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum1En(event.asCharacters().getData());
	        				//LogFile.write("customEnum1En: " + order.getCustomEnum1En());
	        			}else {
	        				order.setCustomEnum1En(null);
	        				//LogFile.write("customEnum1En: ");
	        			} 
	        			break;		
	        		case "customEnum2En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum2En(event.asCharacters().getData());
	        				//LogFile.write("customEnum2En: " + order.getCustomEnum2En());
	        			}else {
	        				order.setCustomEnum2En(null);
	        				//LogFile.write("customEnum2En: ");
	        			} 
	        			break;	
	        		case "customEnum3En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum3En(event.asCharacters().getData());
	        				//LogFile.write("customEnum3En: " + order.getCustomEnum3En());
	        			}else {
	        				order.setCustomEnum3En(null);
	        				//LogFile.write("customEnum3En: ");
	        			} 
	        			break;		
	        		case "customEnum4En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum4En(event.asCharacters().getData());
	        				//LogFile.write("customEnum4En: " + order.getCustomEnum4En());
	        			}else {
	        				order.setCustomEnum4En(null);
	        				//LogFile.write("customEnum4En: ");
	        			} 
	        			break;	
	        		case "customEnum5En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum5En(event.asCharacters().getData());
	        				//LogFile.write("customEnum5En: " + order.getCustomEnum5En());
	        			}else {
	        				order.setCustomEnum5En(null);
	        				//LogFile.write("customEnum5En: ");
	        			} 
	        			break;	
	        		case "customEnum6En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum6En(event.asCharacters().getData());
	        				//LogFile.write("customEnum6En: " + order.getCustomEnum6En());
	        			}else {
	        				order.setCustomEnum6En(null);
	        				//LogFile.write("customEnum6En: ");
	        			} 
	        			break;	
	        		case "customEnum7En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum7En(event.asCharacters().getData());
	        				//LogFile.write("customEnum7En: " + order.getCustomEnum7En());
	        			}else {
	        				order.setCustomEnum7En(null);
	        				//LogFile.write("customEnum7En: ");
	        			} 
	        			break;	
	        		case "customEnum8En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum8En(event.asCharacters().getData());
	        				//LogFile.write("customEnum8En: " + order.getCustomEnum8En());
	        			}else {
	        				order.setCustomEnum8En(null);
	        				//LogFile.write("customEnum8En: ");
	        			} 
	        			break;	
	        		case "customEnum9En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum9En(event.asCharacters().getData());
	        				//LogFile.write("customEnum9En: " + order.getCustomEnum9En());
	        			}else {
	        				order.setCustomEnum9En(null);
	        				//LogFile.write("customEnum9En: ");
	        			} 
	        			break;	
	        		case "customEnum10En":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCustomEnum10En(event.asCharacters().getData());
	        				//LogFile.write("customEnum10En: " + order.getCustomEnum10En());
	        			}else {
	        				order.setCustomEnum10En(null);
	        				//LogFile.write("customEnum10En: ");
	        			} 
	        			break;
	        			
	        		//dockAppointment	
	        		case "dockAppointment":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "expectedArrivalTime":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				dockAppointmentExpectedArrivalTime = event.asCharacters().getData();	 
	    		        				//LogFile.write("expectedArrivalTime: " + dockAppointmentExpectedArrivalTime);
	    		        			}else {
	    		        				//LogFile.write("expectedArrivalTime: ");
	    		        			}  
	    	            			break;           		
	    	            		case "driverName":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				dockAppointmentDriverName = event.asCharacters().getData();
	    		        				//LogFile.write("driverName: " + dockAppointmentDriverName);
	    		        			}else {
	    		        				//LogFile.write("driverName: ");
	    		        			}  
	    	            			break;     		
	    	            		case "truckPlate":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				dockAppointmentTruckPlate = event.asCharacters().getData();
	    		        				//LogFile.write("truckPlate: " + dockAppointmentTruckPlate);
	    		        			}else {
	    		        				//LogFile.write("truckPlate: ");
	    		        			}  
	    	            			break;     		
	    	            		case "driverMobile":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				dockAppointmentDriverMobile = event.asCharacters().getData();
	    		        				//LogFile.write("driverMobile: " + dockAppointmentDriverMobile);
	    		        			}else {
	    		        				//LogFile.write("driverMobile: ");
	    		        			}  
	    	            			break;  
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("dockAppointment")) {	
	    	            			//Set value for every dockAppointment
	    	            			dockAppointment.setExpectedArrivalTime(dockAppointmentExpectedArrivalTime);
	    	            			dockAppointment.setDriverName(dockAppointmentDriverName);
	    	            			dockAppointment.setTruckPlate(dockAppointmentTruckPlate);
	    	            			dockAppointment.setDriverMobile(dockAppointmentDriverMobile);
	    	            			dockAppointmentExpectedArrivalTime = null;
	    	            			dockAppointmentDriverName = null;
	    	            			dockAppointmentTruckPlate = null;
	    	            			dockAppointmentDriverMobile = null;
    		        				//End loop when processing all dockAppointment successfully
	    	            			break;
	    	            		}
	    	            	}//if
	        			}//while for dockAppointment  
	        			break;		

	        		//positions
	        		case "positions":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "truckPlate":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				positionTruckPlate = event.asCharacters().getData();	 
	    		        				//LogFile.write("truckPlate: " + positionTruckPlate);
	    		        			}else {
	    		        				//LogFile.write("truckPlate: ");
	    		        			}  
	    	            			break;           		
	    	            		case "address":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				positionAddress = event.asCharacters().getData();
	    		        				//LogFile.write("address: " + positionAddress);
	    		        			}else {
	    		        				//LogFile.write("address: ");
	    		        			}  
	    	            			break;
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("position")) {	
	    	            			//Set value for every position
	    	            			position.setTruckPlate(positionTruckPlate);
	    	            			position.setAddress(positionAddress);
	    	            			positionTruckPlate = null;
	    	            			positionAddress = null;
	    	            		}else if(event.asEndElement().getName().getLocalPart().equals("positions")) {
	    	            			//End loop when processing all position successfully
	    	            			break;
	    	            		}	
	    	            	}
	        			}   
	        			break;	
	        			
	        		case "cargoType":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setCargoType(event.asCharacters().getData());
	        				//LogFile.write("cargoType: " + order.getCargoType());
	        			}else {
	        				order.setCargoType(null);
	        				//LogFile.write("cargoType: ");
	        			} 
	        			break;	
	        		case "pickupSla":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setPickupSla(event.asCharacters().getData());
	        				//LogFile.write("pickupSla: " + order.getPickupSla());
	        			}else {
	        				order.setPickupSla(null);
	        				//LogFile.write("pickupSla: ");
	        			} 
	        			break;       		 	
	        		case "deliverySla":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setDeliverySla(event.asCharacters().getData());
	        				//LogFile.write("deliverySla: " + order.getDeliverySla());
	        			}else {
	        				order.setDeliverySla(null);
	        				//LogFile.write("deliverySla: ");
	        			} 
	        			break;       		 	
	        		case "orderStatus":
	        			event = r.nextEvent();
	        			if(event.isCharacters()) {
	        				order.setOrderStatus(event.asCharacters().getData());
	        				//LogFile.write("orderStatus: " + order.getOrderStatus());
	        			}else {
	        				order.setOrderStatus(null);
	        				//LogFile.write("orderStatus: ");
	        			} 
	        			break;
	        		
	        		//orderEvents	
	        		case "orderEvents":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "name":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderEventName = event.asCharacters().getData();
	    		        				//LogFile.write("name: " + orderEventName);
	    		        			}else {
	    		        				//LogFile.write("name: ");
	    		        			} 
	    	            			break;           		
	    	            		case "time":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderEventTime = event.asCharacters().getData();
	    		        				//LogFile.write("time: " + orderEventTime);
	    		        			}else {
	    		        				//LogFile.write("time: ");
	    		        			} 
	    	            			break;         		
	    	            		case "operationTime":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderEventOperationTime = event.asCharacters().getData();
	    		        				//LogFile.write("operationTime: " + orderEventOperationTime);
	    		        			}else {
	    		        				//LogFile.write("operationTime: ");
	    		        			} 
	    	            			break;      		
	    	            		case "latitude":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderEventLatitude = event.asCharacters().getData();
	    		        				//LogFile.write("latitude: " + orderEventLatitude);
	    		        			}else {
	    		        				//LogFile.write("latitude: ");
	    		        			} 
	    	            			break;      		
	    	            		case "longitude":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				orderEventLongitude = event.asCharacters().getData();
	    		        				//LogFile.write("longitude: " + orderEventLongitude);
	    		        			}else {
	    		        				//LogFile.write("longitude: ");
	    		        			} 
	    	            			break;
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("event")) {	
	    	            			//Set value for every orderEvent
	    	            			orderEvent.setName(orderEventName);
	    	            			orderEvent.setTime(orderEventTime);
	    	            			orderEvent.setOperationTime(orderEventOperationTime);
	    	            			orderEvent.setLatitude(orderEventLatitude);
	    	            			orderEvent.setLongitude(orderEventLongitude);
	    	            			orderEventName = null;
	    	            			orderEventTime = null;	
	    	            			orderEventOperationTime = null;
	    	            			orderEventLatitude = null;		
	    	            			orderEventLongitude = null;		        			
	    	            		}else if(event.asEndElement().getName().getLocalPart().equals("orderEvents")) {
	    	            			//End loop when processing all orderEvent successfully
	    	            			break;
	    	            		}	
	    	            		
	    	            	}
	        			}   
	        			break;	
	        			
	        		//pickup	
	        		case "pickup":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "driverName":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				pickupDriverName = event.asCharacters().getData();
	    		        				//LogFile.write("driverName: " + pickupDriverName);
	    		        			}else {
	    		        				//LogFile.write("driverName: ");
	    		        			} 
	    	            			break;           		
	    	            		case "mobile":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				pickupMobile = event.asCharacters().getData();
	    		        				//LogFile.write("mobile: " + pickupMobile);
	    		        			}else {
	    		        				//LogFile.write("mobile: ");
	    		        			} 
	    	            			break;         		
	    	            		case "truckPlate":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				pickupTruckPlate = event.asCharacters().getData();
	    		        				//LogFile.write("truckPlate: " + pickupTruckPlate);
	    		        			}else {
	    		        				//LogFile.write("truckPlate: ");
	    		        			} 
	    	            			break;
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("assignedDriver")) {
	    	            			//Set value for every pickupAssignedDriver
	    	            			pickupAssignedDriver.setDriverName(pickupDriverName);  
	    	            			pickupAssignedDriver.setMobile(pickupMobile);  
	    	            			pickupAssignedDriver.setTruckPlate(pickupTruckPlate);
	    	            			pickupDriverName = null;
	    	            			pickupMobile = null;
	    	            			pickupTruckPlate = null;	    	            			
	    	            		}else if(event.asEndElement().getName().getLocalPart().equals("pickup")) {
	    	            			//End loop when processing all pickupAssignedDriver successfully
	    	            			break;
	    	            		}	
	    	            		
	    	            	}
	        			}   
	        			break;
	        		
	        		//delivery	
	        		case "delivery":
	        			while (r.hasNext()) {
	        				event = r.nextEvent();
	    	            	if(event.isStartElement()) {
	    	            		qName = event.asStartElement().getName().getLocalPart();
	    	            		switch(qName) {            		
	    	            		case "driverName":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				deliveryDriverName = event.asCharacters().getData();
	    		        				//LogFile.write("driverName: " + deliveryDriverName);
	    		        			}else {
	    		        				//LogFile.write("driverName: ");
	    		        			}     	            			
	    	            			break;           		
	    	            		case "mobile":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				deliveryMobile = event.asCharacters().getData();
	    		        				//LogFile.write("mobile: " + deliveryMobile);
	    		        			}else {
	    		        				//LogFile.write("mobile: ");
	    		        			} 
	    	            			break;         		
	    	            		case "truckPlate":
	    		        			event = r.nextEvent();
	    		        			if(event.isCharacters()) {
	    		        				deliveryTruckPlate = event.asCharacters().getData();
	    		        				//LogFile.write("truckPlate: " + deliveryTruckPlate);
	    		        			}else {
	    		        				//LogFile.write("truckPlate: ");
	    		        			} 
	    	            			break;
	    	            		}
	    	            	}else if(event.isEndElement()){
	    	            		if(event.asEndElement().getName().getLocalPart().equals("assignedDriver")) {
	    	            			//Set value for every deliveryAssignedDriver
	    	            			deliveryAssignedDriver.setDriverName(deliveryDriverName);  
	    	            			deliveryAssignedDriver.setMobile(deliveryMobile); 
	    	            			deliveryAssignedDriver.setTruckPlate(deliveryTruckPlate); 
	    	            			deliveryDriverName = null;
	    	            			deliveryMobile = null;
	    	            			deliveryTruckPlate = null;	    	            			
	    	            		}else if(event.asEndElement().getName().getLocalPart().equals("delivery")) {
	    	            			//End loop when processing all deliveryAssignedDriver successfully
	    	            			break;
	    	            		}
	    	            		
	    	            	}
	        			}   
	        			break;
	        			
	        		//Order statistics
	        		case "start":
	        			//LogFile.write("start: " + r.nextEvent().asCharacters().getData());
	        			break;
	        		case "count":
	        			//LogFile.write("count: " + r.nextEvent().asCharacters().getData());
	        			break;
	        		case "total":
	        			//LogFile.write("total: " + r.nextEvent().asCharacters().getData());
	        			break;	
	        		
	        		//Exception
	        		case "type":
	        			System.out.println("type: " + r.nextEvent().asCharacters().getData());
	        			break;		
	        			
	        		}
	        	}else if(event.isEndElement()){	        		
            		if(event.asEndElement().getName().getLocalPart().equals("order")) {
            			//Load one order once to DB, including Order, PriceDetail, shipFrom, shipTo, orderLine, dockAppointment, position, 
            			//OrderEvent, PickupAssignedDriver and DeliveryAssignedDriver
        				System.out.println("=================Parsed");
            			extractToStaging = new ExtractToStaging();
            			result = extractToStaging.load(order, priceDetail, shipFrom, shipTo, orderLine, dockAppointment, 
            					position, orderEvent, pickupAssignedDriver, deliveryAssignedDriver);
            			
            			//Set initial value
            			order = new Order();
            			priceDetail = new PriceDetail();
            			shipFrom = new ShipFrom();
            			shipTo = new ShipTo();
            			orderLine = new OrderLine();
            			dockAppointment = new DockAppointment();
            			position = new Position();
            			orderEvent = new OrderEvent();
            		    pickupAssignedDriver = new PickupAssignedDriver();
            		    deliveryAssignedDriver = new DeliveryAssignedDriver();
            		}
            	}//if
	        	
	        }//while	        
	        
	        
		}catch(Exception e) {
			//e.printStackTrace();
			result = result + e.toString() +"\n";
		}finally {
			inputStream.close();
		}//try

		return result;
		
	}//getOrder method

}
