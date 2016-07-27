package domain;
import websiteAPI.AbstractPage;



public class ServicePageData extends AbstractPage{
	
	
	String noSeat;
	String insuranceOfCancelation;
	
	
	
	
	public ServicePageData (String noSeat, String insuranceOfCancelation){
		this.noSeat = noSeat;
		this.insuranceOfCancelation = insuranceOfCancelation;

	}

	public String getNoSeat() {
		return noSeat;
	}




	public void setNoSeat(String noSeat) {
		this.noSeat = noSeat;
	}




	public String getInsuranceOfCancelation() {
		return insuranceOfCancelation;
	}




	public void setinsuranceOfCancelation(String insuranceOfCancelation) {
		this.insuranceOfCancelation = insuranceOfCancelation;
	}
}
	


