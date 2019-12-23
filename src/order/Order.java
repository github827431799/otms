package order;

//Order model
public class Order{
	
	private String partnerCode;
	private String partnerName;	
	private String partnerHeadOfficeCode;
	private String orderNumber;
	private String erpNumber;
	private String price;
	private String consolidationId;
	private String rateAdjustments;
	private String billAccepted;
	private String vat;
	private String pickupSla;
	private String deliverySla;
	private String orderStatus;
	private String remark;
	private String location;
	private String totalWeight;
	private String totalVolume;
	private String totalQuantity;
	private String totalInsurance;
	private String customText1;
	private String customText2;
	private String customText3;
	private String customText4;
	private String customText5;
	private String customText6;
	private String customText7;
	private String customText8;
	private String customText9;
	private String customText10;
	private String customText11;
	private String customText12;
	private String customText13;
	private String customText14;
	private String customText15;
	private String customText16;
	private String customText17;
	private String customText18;
	private String customText19;
	private String customText20;
	private String customText21;
	private String customText22;
	private String customText23;
	private String customText24;
	private String customText25;
	private String customText26;
	private String customText27;
	private String customText28;
	private String customText29;
	private String customText30;
	private String customNum1;
	private String customNum2;
	private String customNum3;
	private String customNum4;
	private String customNum5;
	private String customNum6;
	private String customNum7;
	private String customNum8;
	private String customNum9;
	private String customNum10;
	private String customEnum1;
	private String customEnum2;
	private String customEnum3;
	private String customEnum4;
	private String customEnum5;
	private String customEnum6;
	private String customEnum7;
	private String customEnum8;
	private String customEnum9;
	private String customEnum10;
	private String customEnum1Zh;
	private String customEnum2Zh;
	private String customEnum3Zh;
	private String customEnum4Zh;
	private String customEnum5Zh;
	private String customEnum6Zh;
	private String customEnum7Zh;
	private String customEnum8Zh;
	private String customEnum9Zh;
	private String customEnum10Zh;
	private String customEnum1En;
	private String customEnum2En;
	private String customEnum3En;
	private String customEnum4En;
	private String customEnum5En;
	private String customEnum6En;
	private String customEnum7En;
	private String customEnum8En;
	private String customEnum9En;
	private String customEnum10En;
	private String cargoType;
	
	//Get method
	public String getPartnerCode() {
		return partnerCode;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public String getPartnerHeadOfficeCode() {
		return partnerHeadOfficeCode;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public String getErpNumber() {
		return erpNumber;
	}
	public String getPrice() {
		return price;
	}
	public String getConsolidationId() {
		return consolidationId;
	}
	public String getRateAdjustments() {
		return rateAdjustments;
	}
	public String getBillAccepted() {
		return billAccepted;
	}
	public String getVat() {
		return vat;
	}
	public String getPickupSla() {
		return pickupSla;
	}
	public String getDeliverySla() {
		return deliverySla;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public String getRemark() {
		return remark;
	}
	public String getLocation() {
		return location;
	}
	public String getTotalWeight() {
		return totalWeight;
	}
	public String getTotalVolume() {
		return totalVolume;
	}
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public String getTotalInsurance() {
		return totalInsurance;
	}
	public String getCustomText1() {
		return customText1;
	}
	public String getCustomText2() {
		return customText2;
	}
	public String getCustomText3() {
		return customText3;
	}
	public String getCustomText4() {
		return customText4;
	}
	public String getCustomText5() {
		return customText5;
	}
	public String getCustomText6() {
		return customText6;
	}
	public String getCustomText7() {
		return customText7;
	}
	public String getCustomText8() {
		return customText8;
	}
	public String getCustomText9() {
		return customText9;
	}
	public String getCustomText10() {
		return customText10;
	}
	public String getCustomText11() {
		return customText11;
	}
	public String getCustomText12() {
		return customText12;
	}
	public String getCustomText13() {
		return customText13;
	}
	public String getCustomText14() {
		return customText14;
	}
	public String getCustomText15() {
		return customText15;
	}
	public String getCustomText16() {
		return customText16;
	}
	public String getCustomText17() {
		return customText17;
	}
	public String getCustomText18() {
		return customText18;
	}
	public String getCustomText19() {
		return customText19;
	}
	public String getCustomText20() {
		return customText20;
	}
	public String getCustomText21() {
		return customText21;
	}
	public String getCustomText22() {
		return customText22;
	}
	public String getCustomText23() {
		return customText23;
	}
	public String getCustomText24() {
		return customText24;
	}
	public String getCustomText25() {
		return customText25;
	}
	public String getCustomText26() {
		return customText26;
	}
	public String getCustomText27() {
		return customText27;
	}
	public String getCustomText28() {
		return customText28;
	}
	public String getCustomText29() {
		return customText29;
	}
	public String getCustomText30() {
		return customText30;
	}
	public String getCustomNum1() {
		return customNum1;
	}
	public String getCustomNum2() {
		return customNum2;
	}
	public String getCustomNum3() {
		return customNum3;
	}
	public String getCustomNum4() {
		return customNum4;
	}
	public String getCustomNum5() {
		return customNum5;
	}
	public String getCustomNum6() {
		return customNum6;
	}
	public String getCustomNum7() {
		return customNum7;
	}
	public String getCustomNum8() {
		return customNum8;
	}
	public String getCustomNum9() {
		return customNum9;
	}
	public String getCustomNum10() {
		return customNum10;
	}
	public String getCustomEnum1() {
		return customEnum1;
	}
	public String getCustomEnum2() {
		return customEnum2;
	}
	public String getCustomEnum3() {
		return customEnum3;
	}
	public String getCustomEnum4() {
		return customEnum4;
	}
	public String getCustomEnum5() {
		return customEnum5;
	}
	public String getCustomEnum6() {
		return customEnum6;
	}
	public String getCustomEnum7() {
		return customEnum7;
	}
	public String getCustomEnum8() {
		return customEnum8;
	}
	public String getCustomEnum9() {
		return customEnum9;
	}
	public String getCustomEnum10() {
		return customEnum10;
	}
	public String getCustomEnum1Zh() {
		return customEnum1Zh;
	}
	public String getCustomEnum2Zh() {
		return customEnum2Zh;
	}
	public String getCustomEnum3Zh() {
		return customEnum3Zh;
	}
	public String getCustomEnum4Zh() {
		return customEnum4Zh;
	}
	public String getCustomEnum5Zh() {
		return customEnum5Zh;
	}
	public String getCustomEnum6Zh() {
		return customEnum6Zh;
	}
	public String getCustomEnum7Zh() {
		return customEnum7Zh;
	}
	public String getCustomEnum8Zh() {
		return customEnum8Zh;
	}
	public String getCustomEnum9Zh() {
		return customEnum9Zh;
	}
	public String getCustomEnum10Zh() {
		return customEnum10Zh;
	}
	public String getCustomEnum1En() {
		return customEnum1En;
	}
	public String getCustomEnum2En() {
		return customEnum2En;
	}
	public String getCustomEnum3En() {
		return customEnum3En;
	}
	public String getCustomEnum4En() {
		return customEnum4En;
	}
	public String getCustomEnum5En() {
		return customEnum5En;
	}
	public String getCustomEnum6En() {
		return customEnum6En;
	}
	public String getCustomEnum7En() {
		return customEnum7En;
	}
	public String getCustomEnum8En() {
		return customEnum8En;
	}
	public String getCustomEnum9En() {
		return customEnum9En;
	}
	public String getCustomEnum10En() {
		return customEnum10En;
	}
	public String getCargoType() {
		return cargoType;
	}
	
	//Set method
	public void setPartnerCode(String newPartnerCode) {
		partnerCode = newPartnerCode;
	}
	public void setPartnerName(String newPartnerName) {
		partnerName = newPartnerName;
	}
	public void setPartnerHeadOfficeCode(String newPartnerHeadOfficeCode) {
		partnerHeadOfficeCode = newPartnerHeadOfficeCode;
	}
	public void setOrderNumber(String newOrderNumber) {
		orderNumber = newOrderNumber;
	}
	public void setErpNumber(String newErpNumber) {
		erpNumber = newErpNumber;
	}
	public void setPrice(String newPrice) {
		price = newPrice;
	}
	public void setConsolidationId(String newConsolidationId) {
		consolidationId = newConsolidationId;
	}
	public void setRateAdjustments(String newRateAdjustments) {
		rateAdjustments = newRateAdjustments;
	}
	public void setBillAccepted(String newBillAccepted) {
		billAccepted = newBillAccepted;
	}
	public void setVat(String newVat) {
		vat = newVat;
	}
	public void setPickupSla(String newPickupSla) {
		pickupSla = newPickupSla;
	}
	public void setDeliverySla(String newDeliverySla) {
		deliverySla = newDeliverySla;
	}
	public void setOrderStatus(String newOrderStatus) {
		orderStatus = newOrderStatus;
	}
	public void setRemark(String newRemark) {
		remark = newRemark;
	}
	public void setLocation(String newLocation) {
		location = newLocation;
	}
	public void setTotalWeight(String newTotalWeight) {
		totalWeight = newTotalWeight;
	}
	public void setTotalVolume(String newTotalVolume) {
		totalVolume = newTotalVolume;
	}
	public void setTotalQuantity(String newTotalQuantity) {
		totalQuantity = newTotalQuantity;
	}
	public void setTotalInsurance(String newTotalInsurance) {
		totalInsurance = newTotalInsurance;
	}
	public void setCustomText1(String newCustomText1) {
		customText1 = newCustomText1;
	}
	public void setCustomText2(String newCustomText2) {
		customText2 = newCustomText2;
	}
	public void setCustomText3(String newCustomText3) {
		customText3 = newCustomText3;
	}
	public void setCustomText4(String newCustomText4) {
		customText4 = newCustomText4;
	}
	public void setCustomText5(String newCustomText5) {
		customText5 = newCustomText5;
	}
	public void setCustomText6(String newCustomText6) {
		customText6 = newCustomText6;
	}
	public void setCustomText7(String newCustomText7) {
		customText7 = newCustomText7;
	}
	public void setCustomText8(String newCustomText8) {
		customText8 = newCustomText8;
	}
	public void setCustomText9(String newCustomText9) {
		customText9 = newCustomText9;
	}
	public void setCustomText10(String newCustomText10) {
		customText10 = newCustomText10;
	}
	public void setCustomText11(String newCustomText11) {
		customText11 = newCustomText11;
	}
	public void setCustomText12(String newCustomText12) {
		customText12 = newCustomText12;
	}
	public void setCustomText13(String newCustomText13) {
		customText13 = newCustomText13;
	}
	public void setCustomText14(String newCustomText14) {
		customText14 = newCustomText14;
	}
	public void setCustomText15(String newCustomText15) {
		customText15 = newCustomText15;
	}
	public void setCustomText16(String newCustomText16) {
		customText16 = newCustomText16;
	}
	public void setCustomText17(String newCustomText17) {
		customText17 = newCustomText17;
	}
	public void setCustomText18(String newCustomText18) {
		customText18 = newCustomText18;
	}
	public void setCustomText19(String newCustomText19) {
		customText19 = newCustomText19;
	}
	public void setCustomText20(String newCustomText20) {
		customText20 = newCustomText20;
	}
	public void setCustomText21(String newCustomText21) {
		customText21 = newCustomText21;
	}
	public void setCustomText22(String newCustomText22) {
		customText22 = newCustomText22;
	}
	public void setCustomText23(String newCustomText23) {
		customText23 = newCustomText23;
	}
	public void setCustomText24(String newCustomText24) {
		customText24 = newCustomText24;
	}
	public void setCustomText25(String newCustomText25) {
		customText25 = newCustomText25;
	}
	public void setCustomText26(String newCustomText26) {
		customText26 = newCustomText26;
	}
	public void setCustomText27(String newCustomText27) {
		customText27 = newCustomText27;
	}
	public void setCustomText28(String newCustomText28) {
		customText28 = newCustomText28;
	}
	public void setCustomText29(String newCustomText29) {
		customText29 = newCustomText29;
	}
	public void setCustomText30(String newCustomText30) {
		customText30 = newCustomText30;
	}
	public void setCustomNum1(String newCustomNum1) {
		customNum1 = newCustomNum1;
	}
	public void setCustomNum2(String newCustomNum2) {
		customNum2 = newCustomNum2;
	}
	public void setCustomNum3(String newCustomNum3) {
		customNum3 = newCustomNum3;
	}
	public void setCustomNum4(String newCustomNum4) {
		customNum4 = newCustomNum4;
	}
	public void setCustomNum5(String newCustomNum5) {
		customNum5 = newCustomNum5;
	}
	public void setCustomNum6(String newCustomNum6) {
		customNum6 = newCustomNum6;
	}
	public void setCustomNum7(String newCustomNum7) {
		customNum7 = newCustomNum7;
	}
	public void setCustomNum8(String newCustomNum8) {
		customNum8 = newCustomNum8;
	}
	public void setCustomNum9(String newCustomNum9) {
		customNum9 = newCustomNum9;
	}
	public void setCustomNum10(String newCustomNum10) {
		customNum10 = newCustomNum10;
	}
	public void setCustomEnum1(String newCustomEnum1) {
		customEnum1 = newCustomEnum1;
	}
	public void setCustomEnum2(String newCustomEnum2) {
		customEnum2 = newCustomEnum2;
	}
	public void setCustomEnum3(String newCustomEnum3) {
		customEnum3 = newCustomEnum3;
	}
	public void setCustomEnum4(String newCustomEnum4) {
		customEnum4 = newCustomEnum4;
	}
	public void setCustomEnum5(String newCustomEnum5) {
		customEnum5 = newCustomEnum5;
	}
	public void setCustomEnum6(String newCustomEnum6) {
		customEnum6 = newCustomEnum6;
	}
	public void setCustomEnum7(String newCustomEnum7) {
		customEnum7 = newCustomEnum7;
	}
	public void setCustomEnum8(String newCustomEnum8) {
		customEnum8 = newCustomEnum8;
	}
	public void setCustomEnum9(String newCustomEnum9) {
		customEnum9 = newCustomEnum9;
	}
	public void setCustomEnum10(String newCustomEnum10) {
		customEnum10 = newCustomEnum10;
	}
	public void setCustomEnum1Zh(String newCustomEnum1Zh) {
		customEnum1Zh = newCustomEnum1Zh;
	}
	public void setCustomEnum2Zh(String newCustomEnum2Zh) {
		customEnum2Zh = newCustomEnum2Zh;
	}
	public void setCustomEnum3Zh(String newCustomEnum3Zh) {
		customEnum3Zh = newCustomEnum3Zh;
	}
	public void setCustomEnum4Zh(String newCustomEnum4Zh) {
		customEnum4Zh = newCustomEnum4Zh;
	}
	public void setCustomEnum5Zh(String newCustomEnum5Zh) {
		customEnum5Zh = newCustomEnum5Zh;
	}
	public void setCustomEnum6Zh(String newCustomEnum6Zh) {
		customEnum6Zh = newCustomEnum6Zh;
	}
	public void setCustomEnum7Zh(String newCustomEnum7Zh) {
		customEnum7Zh = newCustomEnum7Zh;
	}
	public void setCustomEnum8Zh(String newCustomEnum8Zh) {
		customEnum8Zh = newCustomEnum8Zh;
	}
	public void setCustomEnum9Zh(String newCustomEnum9Zh) {
		customEnum9Zh = newCustomEnum9Zh;
	}
	public void setCustomEnum10Zh(String newCustomEnum10Zh) {
		customEnum10Zh = newCustomEnum10Zh;
	}
	public void setCustomEnum1En(String newCustomEnum1En) {
		customEnum1En = newCustomEnum1En;
	}
	public void setCustomEnum2En(String newCustomEnum2En) {
		customEnum2En = newCustomEnum2En;
	}
	public void setCustomEnum3En(String newCustomEnum3En) {
		customEnum3En = newCustomEnum3En;
	}
	public void setCustomEnum4En(String newCustomEnum4En) {
		customEnum4En = newCustomEnum4En;
	}
	public void setCustomEnum5En(String newCustomEnum5En) {
		customEnum5En = newCustomEnum5En;
	}
	public void setCustomEnum6En(String newCustomEnum6En) {
		customEnum6En = newCustomEnum6En;
	}
	public void setCustomEnum7En(String newCustomEnum7En) {
		customEnum7En = newCustomEnum7En;
	}
	public void setCustomEnum8En(String newCustomEnum8En) {
		customEnum8En = newCustomEnum8En;
	}
	public void setCustomEnum9En(String newCustomEnum9En) {
		customEnum9En = newCustomEnum9En;
	}
	public void setCustomEnum10En(String newCustomEnum10En) {
		customEnum10En = newCustomEnum10En;
	}
	public void setCargoType(String newCargoType) {
		cargoType = newCargoType;
	}
	
	
}	
