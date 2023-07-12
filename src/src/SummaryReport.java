package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Christian Darr
 */
public class SummaryReport {
    /**
     * This prints the list of providers who have provided services.
     * This includes provider name, consults, and fee
     * It then provides the total providers, consultations and fees.
     * 
     * @throws IOException
     * 
     * @param providerList This is a list of providers who may or may not have provided services.
     * @param file This is the files that the report is to be put in.
     * 
     */
    public SummaryReport(ArrayList<ProviderAccount> providerList, File file) throws IOException {
        int totalConsultsSummary = 0;
        int totalFeesSummary = 0;
            try{ 
                FileWriter writer = new FileWriter(file);
                for(int i = 0; i < providerList.size(); i++){
                    ProviderAccount provider = providerList.get(i);
                    writer.append("Provider" + "-" + provider.getID() + "\n");
                    writer.append("Name: " + provider.getName() + "\n");
                    writer.append("Consults: " + provider.getTotalConsults() + "\n");
                    writer.append("Fee: " + provider.getTotalFee() + "\n");
                    totalConsultsSummary += provider.getTotalConsults();
                    totalFeesSummary += provider.getTotalFee();
                }
                writer.append("Total providers: "+ providerList.size() + "\n");
                writer.append("Total Consultations: "  + totalConsultsSummary + "\n");
                writer.append("Total fees: " + totalFeesSummary + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("File already exists.");
                throw e;
            }
    }
}

