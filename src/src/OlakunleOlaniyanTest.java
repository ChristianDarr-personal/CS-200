package src;

import static org.junit.Assert.*;

import javax.swing.*;

import org.junit.Before;
import org.junit.Test;

 
public class OlakunleOlaniyanTest {
	private ProviderController testProviderController;
	private VerificationController testVerification; 
	@Before
	public void setUp() throws Exception {
		testProviderController = new ProviderController();
		testVerification = new VerificationController(); 
	}


	@Test
	public void testConstructor() {
		assertEquals(testProviderController.getProviderVerified(), false); 
	}
	
	@Test	
	public void testAddServiceDirect(){
		testProviderController.addServiceToDirector("therapy", 1234, 100);
		assertEquals(testProviderController.getServiceCodeDirect("therapy", 1234, 100), true); 
		
	}
	
	@SuppressWarnings("deprecation")
	@Test 
	public void testGetProviderEntries() {
		assertEquals(testProviderController.getProviderEntries(), null); 
	}
	

		

}
