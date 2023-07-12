package src;


import java.util.ArrayList;

/** Class for Member Accounts
 * Stores member's personal information and billing information
 * 
 * @author Jack Orear
 */
public class MemberAccount extends BaseAccount {
	

	ArrayList<String> providersSeen;
	ArrayList<Service> services;
	ArrayList<String> serviceDates;

	public MemberAccount() {
		//Base constructor, initializes to zero or blank

		this.id = 0;
		this.address = "";
		this.name = "";
		this.city = "";
		this.state = "";
		this.zip = 0;
		this.providersSeen = new ArrayList<String>();
		this.services = new ArrayList<Service>();
		this.serviceDates = new ArrayList<String>();
	}
	
	public MemberAccount(int id, String address, String name, String city, String state, int zip){
		//Constructor that builds from known information

		this.id = id;
		this.address = address;
		this.name = name;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.providersSeen = new ArrayList<String>();
		this.services = new ArrayList<Service>();
		this.serviceDates = new ArrayList<String>();
	}
	
	
	/** 
	 * @return providersSeen
	 */
	public ArrayList<String> getProvidersSeen() {
		return providersSeen;
	}
	
	
	/** 
	 * @return services
	 */
	public ArrayList<Service> getServices() {
		return services;
	}
	
	
	/** 
	 * @return serviceDates
	 */
	public ArrayList<String> getServiceDates() {
		return serviceDates;
	}
	
	
	/** 
	 * @param providerName
	 * @param newService
	 * @param serviceDate
	 */
	public void addService(String providerName, Service newService, String serviceDate) {
		//Adds record of individual service to memberAccount

		services.add(newService);
		providersSeen.add(providerName);
		serviceDates.add(serviceDate);
	}
	
	public void resetServiceRecord() {
		//Deletes all service records from account
		
		this.providersSeen.clear();
		this.services.clear();
		this.serviceDates.clear();
	}
}
