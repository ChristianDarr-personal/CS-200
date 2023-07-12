package src;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * This class instantiates a Provider Directory.
 * 
 * @author Marisa Gibbons
 *  
 */
public class ProviderDirectory {
    
	/**
	 * serviceList is a list of Services that are contained in the Provider Directory.
	 */
    ArrayList<Service> serviceList;

    /**
     * Creates a new Provider Directory with the given values.
     */
    public ProviderDirectory() {
        serviceList = new ArrayList<Service>();
        serviceList.add(new Service("service1", 001, 10));
        serviceList.add(new Service("service2", 002, 20));
        serviceList.add(new Service("service3", 003, 30));
        serviceList.add(new Service("service4", 004, 40));
    }

    
    /** 
     * Adds a new Service to the list of Services in the Provider Directory.
     * @param serviceName : The name of the Service as a String.
     * @param serviceCode : The service code of the Service as an int.
     * @param serviceFee : The service fee of the Service as an int.
     */
    public void addService(String serviceName, int serviceCode, int serviceFee) {
        Service newService = new Service(serviceName, serviceCode, serviceFee);
        serviceList.add(newService);
    }

    
    /** 
     * Finds the code of a Service given its name.
     * @param serviceName : The name of the Service whose code is in question.
     * @return int : The service code is returned as an int.
     */
    public int findCode(String serviceName) {
        int code = -1;
        for (Service service : serviceList) {
            if (service.getServiceName().equals(serviceName)) {
                code = service.getServiceCode();
            }
        }
        if (code == -1) {
            System.out.println("Service name not found.");
        }
        else {
            System.out.println("The service code for " + serviceName + " is " + code);
        }
        return code;
    }

    
    /** 
     * Finds the service fee of a Service given its name.
     * @param serviceName : The name of the Service whose fee is in question.
     * @return int : The service fee is returned as an int.
     */
    public int findFee(String serviceName) {
        int fee = -1;
        for (Service service : serviceList) {
            if (service.getServiceName().equals(serviceName)) {
                fee = service.getServiceFee();
            }
        }
        if (fee == -1) {
            System.out.println("Service name not found.");
        }
        else {
            System.out.println("The service fee for " + serviceName + " is " + fee);
        }
        return fee;
    }

    /**
     * Returns the directory as a list of Services.
     * @return serviceList : ArrayList of Service : The directory returned as a list of Services.
     */
    public ArrayList<Service> getDirectory() {
        for (int i = 0; i < serviceList.size(); i++) {
            String name = serviceList.get(i).getServiceName();
            int code = serviceList.get(i).getServiceCode();
            int fee = serviceList.get(i).getServiceFee();
            System.out.println("Service name: " + name + " , service code: " + code + " , service fee: " + fee);
        }
        return serviceList;
    }

    /**
     * Displays the Provider Directory to the GUI.
     * @param providerFrame
     */
    public void displayList(JFrame providerFrame){
        String[] columnNames = {"Name", "code", "fee"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
        for (Service service : serviceList) {
            Object[] rowData = {service.getServiceName(), service.getServiceCode(), service.getServiceFee()};
            tableModel.addRow(rowData);
        }
        JTable serviceTable = new JTable(tableModel);

        JOptionPane.showMessageDialog(providerFrame, new JScrollPane(serviceTable), "Services",JOptionPane.PLAIN_MESSAGE);

    }

}
