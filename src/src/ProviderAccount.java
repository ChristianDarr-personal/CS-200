package src;

import java.util.ArrayList;

/** Class for Provider Accounts
 * Stores provider's personal information and billing information
 * 
 * @author Jack Orear
 */
import java.lang.String;

public class ProviderAccount extends BaseAccount {
	
	

	ArrayList<String> dataRecDates;
	ArrayList<String> dataRecTimes;

	ArrayList<String> membersSeenNames;
	ArrayList<Integer> serviceCodes;
	ArrayList<Integer> serviceFees;
	ArrayList<Integer> membersSeenIds;
	int totalConsults;
	int totalFee;
	
	public ProviderAccount() {
		//Base constructor, initializes everything to zero or blank

		this.id = 0;
		this.address = "";
		this.name = "";
		this.city = "";
		this.state = "";
		this.zip = 0;
		this.dataRecDates = new ArrayList<String>();
		this.dataRecTimes = new ArrayList<String>();
		this.membersSeenNames = new ArrayList<String>();
		this.membersSeenIds = new ArrayList<Integer>();
		this.serviceCodes = new ArrayList<Integer>();
		this.serviceFees = new ArrayList<Integer>();
		this.totalConsults = 0;
		this.totalFee = 0;
	}
	
	public ProviderAccount(int id, String address, String name, String city, String state, int zip){
		//Constructor that builds from known personal information

		this.id = id;
		this.address = address;
		this.name = name;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.dataRecDates = new ArrayList<String>();
		this.dataRecTimes = new ArrayList<String>();
		this.membersSeenNames = new ArrayList<String>();
		this.membersSeenIds = new ArrayList<Integer>();
		this.serviceCodes = new ArrayList<Integer>();
		
		this.serviceFees = new ArrayList<Integer>();
		
		this.totalConsults = 0;
		this.totalFee = 0;
	}
	
	
	/** 
	 * @return sataRecDates
	 */
	public ArrayList<String> getDataRecDates(){
		return dataRecDates;
	}
	
	
	/** 
	 * @return dataRecTimes
	 */
	public ArrayList<String> getDataRecTimes(){
		return dataRecTimes;
	}
	
	
	/** 
	 * @return membersSeenNames
	 */
	public ArrayList<String> getMembersSeen(){
		return membersSeenNames;
	}
	
	
	/** 
	 * @return serviceCodes
	 */
	public ArrayList<Integer> getServiceCodes() {
		return serviceCodes;
	}

	
	/** 
	 * @return serviceFees
	 */
	public ArrayList<Integer> getServiceFees() {
		return serviceFees;
	}
	
	public int getTotalConsults() {
		return totalConsults;
	}
	
	public int getTotalFee() {
		return totalFee;
	}

	public ArrayList<Integer> getMemberIds() {
		return membersSeenIds;
	}
	
	public void addService(String dataRecDate, String dataRecTime, String memberName, int i, Service toAdd) {
		//Adds billing information from individual service to account

		this.dataRecDates.add(dataRecDate);
		this.dataRecTimes.add(dataRecTime);
		this.membersSeenNames.add(memberName);
		this.membersSeenIds.add(i);
		
		int codeToAdd = toAdd.getServiceCode();
		this.serviceCodes.add(codeToAdd);
		
		int feeToAdd = toAdd.getServiceFee();
		this.serviceFees.add(feeToAdd);
		this.totalFee += feeToAdd;
		
		this.totalConsults++;
	}
	
	public void resetServiceRecord() {
		//clears all service records from account

		this.totalFee = 0;
		this.totalConsults = 0;
		this.dataRecDates.clear();
		this.dataRecTimes.clear();
		this.membersSeenNames.clear();
		this.serviceCodes.clear();
		this.membersSeenIds.clear();
	}
}

