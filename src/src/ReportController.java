package src;

import java.awt.JobAttributes;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * This class calls and creates the reports and manages the options for creating reports.
 * 
 * @author Christian Darr
 * 
 */
public class ReportController {


    /**
     * This is an empty default constructor.
     */
    public ReportController(){
    }

    /**
     * This will create all of the reports.
     */
    public void generateAllReports(){
        generateMemberReports();
        generateProviderReports();    
        generateSummaryReport();
    }

    /**
     * This cleans the member reports and creates the directory and creates the reports.
     */
    public void generateMemberReports(){
        File memberDir = new File("reports/member");
        deleteDirectory(memberDir);
        memberDir.mkdirs();
        StringBuilder fails = new StringBuilder();
        // ArrayList<String> fails = new ArrayList<String>();
        MemberDatabase memberDatabase = MemberDatabase.getInstance();
        ArrayList<MemberAccount> memberList = memberDatabase.getMemberAccounts();
        for(int i = 0; i < memberList.size(); i ++){
            MemberAccount member = memberList.get(i);
            String name = member.getName();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			LocalDate localDate = LocalDate.now();
            String filename = name + "_" + dtf.format(localDate);
        
            File file = new File("reports/member", filename);
            
            try{
                file.createNewFile();
                System.out.println("File created: " + file.getName());
                MemberReport memberReport = new MemberReport(member, file);
                fails.append(file.getName() + ": Success\n");
                    } catch (IOException e) {
                System.out.println(e.getMessage());
                fails.append(file.getName() + ": Fail\n");
            }
        }
        JOptionPane.showMessageDialog(null, fails.toString(), "Member Report",1);
    }

    /**
     * This cleans the summary reports and creates a new report.
     */
    public void generateSummaryReport() {
        // get provider database
        ProviderDatabase providerDatabase = ProviderDatabase.getInstance();
        ArrayList<ProviderAccount> providerList = providerDatabase.getProviderAccounts();
        //
        String filename = "Summary Report";
        File summaryDir = new File("reports/summary");
        deleteDirectory(summaryDir);
        summaryDir.mkdirs();
        File file = new File(summaryDir, filename);

        try{
            file.createNewFile();
            System.out.println("File created: " + file.getName());
            SummaryReport summaryReport = new SummaryReport(providerList, file);
            JOptionPane.showMessageDialog(null, "Summary Report Created", "Summary Report", 1);
        } catch (IOException e) {
            System.out.println("File already exists.");
            JOptionPane.showMessageDialog(null, "Summary Report Not Created");
        }
    }

    /**
     * This cleans the provider reports, creates the directory, and creates the reports.
     */
    public void generateProviderReports(){
        ProviderDatabase providerDatabase = ProviderDatabase.getInstance();
        ArrayList<ProviderAccount> providerList = providerDatabase.getProviderAccounts();

        File providerDir = new File("reports/provider");
        deleteDirectory(providerDir);
        providerDir.mkdirs();

        StringBuilder fails = new StringBuilder();
        for(int i = 0; i < providerList.size(); i ++){
            ProviderAccount provider = providerList.get(i);
            String name = provider.getName();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
			LocalDate localDate = LocalDate.now();
            String filename = name + "_" + dtf.format(localDate);
            File file = new File("reports/provider", filename);

            try{
                file.createNewFile();
                System.out.println("File created: " + file.getName());
                ProviderReport providerReport = new ProviderReport(provider, file);
                fails.append(file.getName() + ": Success\n");
            } catch (IOException e) {
                System.out.println("File already exists.");
                fails.append(file.getName() + ": Failed\n");
            }
        }        
        JOptionPane.showMessageDialog(null, fails.toString(), "Provider Reports", 1);
    }
    
    /** 
     * This is a helper function to clear the reports from previous instances of the app.
     * 
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
