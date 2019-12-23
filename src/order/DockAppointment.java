package order;

import java.util.ArrayList;
import java.util.List;

//Model DockAppointment
public class DockAppointment {	

	private List<String> expectedArrivalTime = new ArrayList<String>();
	private List<String> driverName = new ArrayList<String>();
	private List<String> truckPlate = new ArrayList<String>();
	private List<String> driverMobile = new ArrayList<String>();
	
	//Get method
	public String getExpectedArrivalTime(int i) {
		return expectedArrivalTime.get(i);
	}
	public String getDriverName(int i) {
		return driverName.get(i);
	}
	public String getTruckPlate(int i) {
		return truckPlate.get(i);
	}
	public String getDriverMobile(int i) {
		return driverMobile.get(i);
	}

	//Set method
	public void setExpectedArrivalTime(String newExpectedArrivalTime) {
		expectedArrivalTime.add(newExpectedArrivalTime);
	}	
	public void setDriverName(String newDriverName) {
		driverName.add(newDriverName);
	}	
	public void setTruckPlate(String newTruckPlate) {
		truckPlate.add(newTruckPlate);
	}	
	public void setDriverMobile(String newDriverMobile) {
		driverMobile.add(newDriverMobile);
	}	
	
	//Calculate size
	public int getSize() {
		return this.expectedArrivalTime.size();
	}

}
