package order;

import java.util.ArrayList;
import java.util.List;

//Model PriceDetail
public class PriceDetail {	

	private List<String> name = new ArrayList<String>();
	private List<String> rate = new ArrayList<String>();
	
	//Get method
	public String getName(int i) {
		return name.get(i);
	}
	public String getRate(int i) {
		return rate.get(i);
	}

	//Set method
	public void setName(String newName) {
		name.add(newName);
	}	
	public void setRate(String newRate) {
		rate.add(newRate);
	}	
	
	//Calculate size
	public int getSize() {
		return this.name.size();
	}

}
