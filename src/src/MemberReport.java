package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;

/**
 * @author Christian Darr
 */
public class MemberReport {
    /**
     * This class creates the report for a member, printing the id, name, address, city
     * state and zip of the member.
     * 
     * @throws IOException
     * 
     * @param member This is the member that the report is to be created for.
     * @param file This is the file the report is to be put in.
     */
    public MemberReport(MemberAccount member, File file) throws IOException {
        try{
            FileWriter writer = new FileWriter(file);
            writer.append("Member Report\n");
            writer.append("ID: " + member.getID() + "\n");
            writer.append("Name: " + member.getName() + "\n");
            writer.append("Address: " + member.getAddress() + "\n");
            writer.append("City: " + member.getCity() + "\n");
            writer.append("State: " + member.getState() + "\n");
            writer.append("Zip: " + member.getZip() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("File already exists.");
            throw e;
        }
    }
}
