package order;

import java.util.ArrayList;
import java.util.List;

//Model OrderEvent
public class OrderEvent {	

	private List<String> name = new ArrayList<String>();
	private List<String> time = new ArrayList<String>();
	private List<String> operationTime = new ArrayList<String>();
	private List<String> latitude = new ArrayList<String>();
	private List<String> longitude = new ArrayList<String>();
	
	//Get method
	public String getName(int i) {
		return name.get(i);
	}
	public String getTime(int i) {
		return time.get(i);
	}
	public String getOperationTime(int i) {
		return operationTime.get(i);
	}
	public String getLatitude(int i) {
		return latitude.get(i);
	}
	public String getLongitude(int i) {
		return longitude.get(i);
	}

	//Set method
	public void setName(String newName) {
		name.add(newName);
	}	
	public void setTime(String newTime) {
		time.add(newTime);
	}	
	public void setOperationTime(String newOperationTime) {
		operationTime.add(newOperationTime);
	}	
	public void setLatitude(String newLatitude) {
		latitude.add(newLatitude);
	}	
	public void setLongitude(String newLongitude) {
		longitude.add(newLongitude);
	}
	
	//Calculate size
	public int getSize() {
		return this.name.size();
	}	

}
