package src;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * @Author Christian Darr
 */
public class ChristianDarrTest {

	/** 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		MemberDatabase memberDatabase = MemberDatabase.getInstance();
		for(int i = 5; i < 8; i++){
			memberDatabase.addPersonEntry(i, Integer.toString(i),Integer.toString(i),Integer.toString(i),Integer.toString(i),i);
		}
		File testDir = new File("old/testOutput/member");
		deleteDirectory(testDir);
		testDir.mkdirs();

        ProviderDatabase providerDatabase = ProviderDatabase.getInstance();
		for(int i = 5; i < 8; i++){
			providerDatabase.addPersonEntry(i, Integer.toString(i),Integer.toString(i),Integer.toString(i),Integer.toString(i),i);
		}
		File testProviderDir = new File("old/testOutput/provider");
		deleteDirectory(testProviderDir);
		testProviderDir.mkdirs();
	}

	@Test
	public void testMemberCreation() {
		MemberDatabase memberDatabase = MemberDatabase.getInstance();
		int i = 5;
		try {
			File file = new File("old/testOutput/member", Integer.toString(i));
			file.createNewFile();
			new MemberReport(memberDatabase.getMemberAccounts().get(i), file);
		} catch (IOException e) {
			fail("IOException occured");
		}
	}

	@Test
	public void testMemberCorrectness(){
		MemberDatabase memberDatabase = MemberDatabase.getInstance();
		int i = 6;
		try {
			File file = new File("old/testOutput/member", Integer.toString(i));
			file.createNewFile();
			MemberAccount testMember = memberDatabase.searchID(i);
			new MemberReport(testMember, file);
			File compareFile = new File("old/testOutput/compare/member", Integer.toString(i));
			String file1Contents = new String(Files.readAllBytes(compareFile.toPath()));
	        String file2Contents = new String(Files.readAllBytes(file.toPath()));
	        System.out.println(file1Contents);
	        System.out.println(file2Contents);
	        assertEquals(file1Contents, file2Contents);
		} catch (IOException e) {
			fail("IOException occured");
		}	 
	}
	
	
	/** 
	 * @throws IOException
	 */
	@Test(expected = IOException.class)
	public void testMemberFailureReadOnly() throws IOException{
		MemberDatabase memberDatabase = MemberDatabase.getInstance();
		int i = 7;
		File file = new File("old/testOutput/member", Integer.toString(i));
		file.createNewFile();
		file.setReadOnly();
		new MemberReport(memberDatabase.getMemberAccounts().get(i), file);
	}

  

	@Test
	public void testProviderCreation() {
		ProviderDatabase providerDatabase = ProviderDatabase.getInstance();
		int i = 5;
		try {
			File file = new File("old/testOutput/provider", Integer.toString(i));
			file.createNewFile();
			new ProviderReport(providerDatabase.getProviderAccounts().get(i), file);
		} catch (IOException e) {
			fail("IOException occured");
		}
	}

	@Test
	public void testProviderCorrectness(){
		ProviderDatabase providerDatabase = ProviderDatabase.getInstance();
		int i = 6;
		try {
			File file = new File("old/testOutput/provider", Integer.toString(i));
			file.createNewFile();
			ProviderAccount testProvider = providerDatabase.searchID(i);
			new ProviderReport(testProvider, file);
			File compareFile = new File("old/testOutput/compare/provider", Integer.toString(i));
			String file1Contents = new String(Files.readAllBytes(compareFile.toPath()));
	        String file2Contents = new String(Files.readAllBytes(file.toPath()));
	        System.out.println(file1Contents);
	        System.out.println(file2Contents);
	        assertEquals(file1Contents, file2Contents);
		} catch (IOException e) {
			fail("IOException occured");
		}	 
	}
	
	
	/** 
	 * @throws IOException
	 */
	@Test(expected = IOException.class)
	public void testProviderFailureReadOnly() throws IOException{
		ProviderDatabase providerDatabase = ProviderDatabase.getInstance();
		int i = 7;
		File file = new File("old/testOutput/provider", Integer.toString(i));
		file.createNewFile();
		file.setReadOnly();
		new ProviderReport(providerDatabase.getProviderAccounts().get(i), file);
	}
	
	@Test
	public void testAddPersonEntry() {
		MemberDatabase memberDatabase = MemberDatabase.getInstance();
		int testId = 8;
		String testAddress = "testAddress";
		String testName = "testName";
		String testCity = "testCity";
		String testState = "testState";
		int testZip = 7;
		memberDatabase.addPersonEntry(testId, testAddress,testName, testCity, testState, testZip);
		int index = memberDatabase.idSearch(testId);
		MemberAccount memberAccount  = memberDatabase.getMemberAccounts().get(index);
		assertEquals(memberAccount.getID(), testId);
		assertEquals(memberAccount.getAddress(), testAddress);
		assertEquals(memberAccount.getName(), testName);
		assertEquals(memberAccount.getZip(), testZip);
		assertEquals(memberAccount.getCity(), testCity);
		assertEquals(memberAccount.getState(), testState);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testAddPersonEntryFail() throws NumberFormatException {
		MemberDatabase memberDatabase = MemberDatabase.getInstance();
		int testId = -1;
		String testAddress = "testAddress";
		String testName = "testName";
		String testCity = "testCity";
		String testState = "testState";
		int testZip = 123456109;
		try {
		memberDatabase.addPersonEntry(testId, testAddress,testName, testCity, testState, testZip);
		} catch (NumberFormatException e){
			throw e;
		}
	}

	/** 
	 * @param directory
	 */
	private void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
            directory.delete();
        }
    }

}
