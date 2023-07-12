package src;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author marisagibbons
 * This is the test file for the 3 methods I chose to test.
 *
 */
public class MarisaGibbonsTest {

	
	/** 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * This is a test of a method I wrote in Service class
	 * The method is getServiceFee()
	 * There are 3 tests: for a null service fee, large service fee, and small service fee
	 */
	@Test
	public void testGetNullServiceFee() {
		Service service = new Service();
		assertEquals(0, service.getServiceFee());
	}
	
	@Test
	public void testGetLargeServiceFee() {
		Service service = new Service("testService", 1004, 10000000);
		assertEquals(10000000, service.getServiceFee());
	}
	
	@Test
	public void testGetSmallServiceFee() {
		Service service = new Service("testService", 1004, 10);
		assertEquals(10, service.getServiceFee());
	}
	
	/**
	 * This is a test of a method I wrote in Service class
	 * The method is setServiceFee()
	 * There are 3 tests: for a null service fee, small service fee, and large service fee
	 */
	@Test
	public void testSetNullServiceFee() {
		Service service = new Service("testService", 1004, 10);
		service.setServiceFee(0);
		assertEquals(0, service.getServiceFee());
	}
	
	@Test
	public void testSetLargeServiceFee() {
		Service service = new Service("testService", 1004, 10);
		service.setServiceFee(100000000);
		assertEquals(100000000, service.getServiceFee());
	}
	
	@Test
	public void testSetSmallServiceFee() {
		Service service = new Service("testService", 1004, 10);
		service.setServiceFee(15);
		assertEquals(15, service.getServiceFee());
	}
	
	
	/**
	 * This is a test of a method authored by Jack Orear in ProviderAccount class
	 * The method is getTotalConsults()
	 * There are 3 tests: for null total consults, one total consult, and multiple total consults
	 */
	@Test
	public void testGetOneTotalConsults() {
		Service service = new Service("testService", 1004, 10);
		ProviderAccount testAccount = new ProviderAccount(1004, "311 lane", "Test name", "washington", "tennessee",  92834);
		testAccount.addService("may 8", "10:34", "member", 4, service);
		assertEquals(1, testAccount.getTotalConsults());
	}
	
	@Test
	public void testGetMultipleTotalConsults() {
		Service service1 = new Service("testService", 1004, 10);
		Service service2 = new Service("testService", 1003, 10);
		Service service3 = new Service("testService", 1002, 10);
		Service service4 = new Service("testService", 1001, 10);
		ProviderAccount testAccount = new ProviderAccount(1004, "311 lane", "Test name", "washington", "tennessee",  92834);
		testAccount.addService("may 8", "10:34", "member1", 4, service1);
		testAccount.addService("may 9", "10:35", "member2", 5, service2);
		testAccount.addService("may 10", "10:36", "member3", 6, service3);
		testAccount.addService("may 11", "10:37", "member4", 7, service4);
		assertEquals(4, testAccount.getTotalConsults());
	}
	
	@Test
	public void testGetNullTotalConsults() {
		ProviderAccount testAccount = new ProviderAccount();
		assertEquals(0, testAccount.getTotalConsults());
	}

}
