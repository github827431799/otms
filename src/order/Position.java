package order;

import java.util.ArrayList;
import java.util.List;

//Model Position
public class Position {	

	private List<String> truckPlate = new ArrayList<String>();
	private List<String> address = new ArrayList<String>();
	
	//Get method
	public String getTruckPlate(int i) {
		return truckPlate.get(i);
	}
	public String getAddress(int i) {
		return address.get(i);
	}

	//Set method
	public void setTruckPlate(String newTruckPlate) {
		truckPlate.add(newTruckPlate);
	}	
	public void setAddress(String newAddress) {
		address.add(newAddress);
	}	
	
	//Calculate size
	public int getSize() {
		return this.truckPlate.size();
	}

}
