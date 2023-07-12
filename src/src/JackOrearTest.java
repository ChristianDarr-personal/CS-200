package src;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
public class JackOrearTest {
    MemberAccount TestAcctMember;
    ProviderAccount TestAcct;
   
    
    @Test
	public void serviceTest() {
	   // public Service(String serviceName, int serviceCode, int serviceFee) {

		Service Test = new Service("Name", 123, 123);
		assertEquals(Test.serviceName, "Name");
		assertEquals(Test.getServiceFee(), 123);
	}

    
	@Test
	public void testConstructorProviderAccount() {
		//public ProviderAccount(int id, String address, String name, String city, String state, int zip){
		TestAcct = new ProviderAccount(1, "Address", "Name Name", "city", "state", 1234);
		assertEquals(TestAcct.address, "Address");
		assertEquals(TestAcct.id, 1);
	}
	
	@Test
	public void testGetsProviderAccount() {
		TestAcct = new ProviderAccount(1, "Address", "Name Name", "city", "state", 1234);
		assertEquals(TestAcct.getCity(), "city");
		assertEquals(TestAcct.getZip(), 1234 );
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testServiceProviderAccount() {
		//public void addService(String dataRecDate, String dataRecTime, String memberName, int i, Service toAdd) {
		TestAcct = new ProviderAccount(1, "Address", "Name Name", "city", "state", 1234);
		Service toAdd = new Service();
		
		TestAcct.addService("MM-DD-YYYY", "HH:MM:SS", "Name", 1, toAdd);
		assertEquals(TestAcct.membersSeenNames.get(0), "Name");
		
		TestAcct.resetServiceRecord();
			TestAcct.membersSeenNames.get(0);
		
	}
    
	
	@Test
	public void testConstructorMemberAccount() {
		//public ProviderAccount(int id, String address, String name, String city, String state, int zip){
		TestAcctMember = new MemberAccount(1, "Address", "Name Name", "city", "state", 1234);
		assertEquals(TestAcctMember.address, "Address");
		assertEquals(TestAcctMember.id, 1);
	}
	
	@Test
	public void testGetsMemberAccount() {
		TestAcctMember = new MemberAccount(1, "Address", "Name Name", "city", "state", 1234);
		assertEquals(TestAcctMember.getCity(), "city");
		assertEquals(TestAcctMember.getZip(), 1234 );
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testServiceMemberAccount() {
		//public void addService(String providerName, Service newService, String serviceDate) 
		TestAcctMember = new MemberAccount(1, "Address", "Name Name", "city", "state", 1234);
		Service toAdd = new Service();
		
		TestAcctMember.addService("Provider", toAdd, "MM-DD-YYYY");
		
		assertEquals(TestAcctMember.providersSeen.get(0), "Provider");
		
		TestAcctMember.resetServiceRecord();
		TestAcctMember.providersSeen.get(0);
		
	}
}
