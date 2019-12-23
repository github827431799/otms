package order;

import java.util.ArrayList;
import java.util.List;

//Model pickupAssignedDriver
public class PickupAssignedDriver {	

	private List<String> driverName = new ArrayList<String>();
	private List<String> mobile = new ArrayList<String>();
	private List<String> truckPlate = new ArrayList<String>();
	
	//Get method
	public String getDriverName(int i) {
		return driverName.get(i);
	}
	public String getMoble(int i) {
		return mobile.get(i);
	}
	public String getTruckPlate(int i) {
		return truckPlate.get(i);
	}

	//Set method
	public void setDriverName(String newDriverName) {
		driverName.add(newDriverName);
	}	
	public void setMobile(String newMobile) {
		mobile.add(newMobile);
	}	
	public void setTruckPlate(String newTruckPlate) {
		truckPlate.add(newTruckPlate);
	}	
	
	//Calculate size
	public int getSize() {
		return this.driverName.size();
	}	


}
