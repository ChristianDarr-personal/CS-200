package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Christian Darr
 */
public class ProviderReport {
    /**
     * Generates the provider report including the name, id, address, city
     * zip, and list of services including the date, date and time, member name,
     * member number, service code and service fee. It finally prints the total consultations
     * and total fees.
     * 
     * @throws IOException
     * @param provider a provider for which the report should be generated
     * @param file the file in which the report should be put
     * 
     * 
     */
    public ProviderReport(ProviderAccount provider, File file) throws IOException {
        try{
            FileWriter writer = new FileWriter(file);
            writer.write("Provider Report\n");
            writer.append("Name: " + provider.getName() + "\n");
            writer.append("ID: " + provider.getID() + "\n");
            writer.append("Address: " + provider.getAddress() + "\n");
            writer.append("City: " + provider.getCity() + "\n");
            writer.append("State: " + provider.getState() + "\n");
            writer.append("Zip: " + provider.getZip() + "\n");
            writer.append("Services: \n\n");
            for(int i = 0; i < provider.getTotalConsults(); i++) {
                writer.append("Service "+ i + '\n');
                writer.append("Date: " + provider.getDataRecDates().get(i) + "\n");
                writer.append("Date & Time: " + provider.getDataRecDates().get(i) + " " + provider.getDataRecTimes().get(i) + "\n");
                writer.append("Member Name: " + provider.getMembersSeen().get(i) + "\n");
                writer.append("Member Number: " + provider.getMemberIds().get(i) + "\n");
                writer.append("Service Code: " + provider.getServiceCodes().get(i) + "\n");
                writer.append("Service Fee: " + provider.getServiceFees().get(i) + "\n\n");
            }
            writer.append("Total Consultations: "  + provider.totalConsults + "\n");
            writer.append("Total fees: " + provider.getTotalFee() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("File already exists.");
            throw e;
        }
    }
}
