package order;

import java.util.ArrayList;
import java.util.List;

//Model ShipTo
public class ShipTo {	

	private List<String> name = new ArrayList<String>();
	private List<String> externalId = new ArrayList<String>();
	private List<String> province = new ArrayList<String>();
	private List<String> town = new ArrayList<String>();
	private List<String> county = new ArrayList<String>();
	private List<String> address = new ArrayList<String>();
	private List<String> contactName = new ArrayList<String>();
	private List<String> contactMobile = new ArrayList<String>();
	private List<String> contactEmail = new ArrayList<String>();
	
	//Get method
	public String getName(int i) {
		return name.get(i);
	}
	public String getExternalId(int i) {
		return externalId.get(i);
	}
	public String getProvince(int i) {
		return province.get(i);
	}

	public String getTown(int i) {
		return town.get(i);
	}

	public String getCountry(int i) {
		return county.get(i);
	}

	public String getAddress(int i) {
		return address.get(i);
	}

	public String getContactName(int i) {
		return contactName.get(i);
	}

	public String getContactMobile(int i) {
		return contactMobile.get(i);
	}

	public String getContactEmail(int i) {
		return contactEmail.get(i);
	}


	//Set method
	public void setName(String newName) {
		name.add(newName);
	}	
	public void setExternalId(String newExternalId) {
		externalId.add(newExternalId);
	}		
	public void setProvince(String newProvince) {
		province.add(newProvince);
	}		
	public void setTown(String newTown) {
		town.add(newTown);
	}		
	public void setCounty(String newCounty) {
		county.add(newCounty);
	}		
	public void setAddress(String newAddress) {
		address.add(newAddress);
	}		
	public void setContactName(String newContactName) {
		contactName.add(newContactName);
	}		
	public void setContactMobile(String newContactMobile) {
		contactMobile.add(newContactMobile);
	}		
	public void setContactEmail(String newContactEmail) {
		contactEmail.add(newContactEmail);
	}	
	
	//Calculate size
	public int getSize() {
		return this.name.size();
	}

}
