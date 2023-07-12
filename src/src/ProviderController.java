package src;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

/** 
 * Class for controlling the provider
 * Calls the provider directory and database methods
 * 
 * @author Olakunle Olaniyan
 */
public class ProviderController {
	
	private ProviderDirectory directory; 
	private ProviderDatabase  pDatabase; 
	private MemberDatabase mDatabase;
	private boolean providerVerified; 
	
	public ProviderController(){
		directory = new ProviderDirectory(); 
		pDatabase = ProviderDatabase.getInstance();
		mDatabase = MemberDatabase.getInstance();
		this.providerVerified = false; 
	}
	
	public boolean getProviderVerified() {
		return this.providerVerified; 
	}
	/** 
	 * @param providerFrame
	 * @return directory
	 */
	public ArrayList<Service> getDirectory(JFrame providerFrame) {
		directory.displayList(providerFrame);
		return directory.getDirectory(); 
	}
	
	
	
	
	/** 
	 * @param name
	 * @param code
	 * @param fee
	 */
	public void addServiceToDirector(String name, int code, int fee) {
		directory.addService(name, code, fee); 
	}
	
	public boolean getServiceCodeDirect(String name, int code, int fee) {
		if(code == directory.findCode(name) && (fee == directory.findFee(name)))
				return true; 
		else return false; 		
	}

	/** 
	 * @param providerFrame
	 */
	public void billService(JFrame providerFrame) {
		//Get inputs for adding service info to member and provider accounts through GUI
		try{
			String serviceName = JOptionPane.showInputDialog(providerFrame, "Enter the name of service:");
			int serviceCode = Integer.parseInt(JOptionPane.showInputDialog(providerFrame, "Enter the service code:"));
			int serviceFee = Integer.parseInt(JOptionPane.showInputDialog(providerFrame, "Enter the service fee:"));
			int providerID = Integer.parseInt(JOptionPane.showInputDialog(providerFrame, "Enter the ID of provider:"));
			int memberID = Integer.parseInt(JOptionPane.showInputDialog(providerFrame, "Enter the member ID:"));
			
			//find accounts to add info to
			ProviderAccount currProvider = pDatabase.searchID(providerID);
			MemberAccount currMember = mDatabase.searchID(memberID);

			//Get date and time
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));

			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime localTime = LocalTime.now();
			System.out.println(dtf2.format(localTime));

			//Create service from input information
			Service tempService = new Service(serviceName, serviceCode, serviceFee);
			
			//Add billing info to accounts
			currProvider.addService(dtf.format(localDate), dtf2.format(localTime), currMember.getName(), currMember.getID(), tempService);
			currMember.addService(currProvider.getName(), tempService, dtf.format(localDate));
			JOptionPane.showMessageDialog(null, "Service Added");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Data formatting incorrect - numeric fields must contain numbers.");
			return;
		}

		//directory.addService(serviceName, serviceCode, serviceFee);
	}
	
	
	/** 
	 * @param action
	 * @param serviceName
	 */
	public void findCodeorFeeInDirectory( String action, String serviceName) {
		if(action == "findCode") {
			directory.findCode(serviceName); 
		}
		else if(action == "findFee") {
			directory.findFee(serviceName); 
		}
	}
	
	
	/** 
	 * @param Id
	 */
	public void searchProviderId(int Id) {
		pDatabase.idSearch(Id); 
	}
	
	public ProviderAccount[] getProviderEntries() {
		ProviderAccount[] no = pDatabase.getEntries(); 
		return no; 
	}
	
	public void clearProviderServiceInfo() {
//		database.clearServiceInfo(); 
	}

}
