package src;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ProviderDatabase {
	private static ProviderDatabase instance;
    private ArrayList<ProviderAccount> providerList;
    private ProviderDatabase() {
		providerList = new ArrayList<ProviderAccount>();
        // Private constructor to prevent direct instantiation

		//Read in list of providers stored (not yet persistent data, just for ease of testing)
		try{
			File myObj = new File("old/Database.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String name = myReader.nextLine();
				String address = myReader.nextLine();
				String city = myReader.nextLine();
				String state = myReader.nextLine();
				Integer zip = Integer.parseInt(myReader.nextLine());
				Integer id = Integer.parseInt(myReader.nextLine());
				ProviderAccount account = new ProviderAccount(id, address, name, city, state, zip);
				providerList.add(account);
			}
		myReader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
    }


	
	/** 
	 * @return providerList
	 */
	public ArrayList<ProviderAccount> getProviderAccounts(){
		return providerList;
	}
    
    
	/** 
	 * @return ProviderDatabase
	 */
	public static synchronized ProviderDatabase getInstance() {
        if (instance == null) {
            instance = new ProviderDatabase();
        }
        return instance;
    }
    
    
	/** 
	 * @param operatorFrame
	 */
	public void addPerson(JFrame operatorFrame) {
		System.out.println(providerList.size());
		String[] columnNames = {"ID", "Address", "Name", "City","State", "Zip"};
		String[] data = {"","","","","", ""};
		
		DefaultTableModel tableModel = new DefaultTableModel(null, columnNames){
			@Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
		};
		/*if(providerList.size() > 0){
			for(int i = 0; i < providerList.size(); i++){
				String[] existingData = {Integer.toString(
					providerList.get(i).getID()),
					providerList.get(i).getAddress(), 
					providerList.get(i).getName(), 
					providerList.get(i).getCity(), 
					providerList.get(i).getState(),
					Integer.toString(providerList.get(i).getZip())};
				tableModel.addRow(existingData);
			}
		}*/
		tableModel.addRow(data);
		
        JTable personTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(personTable);
		scrollPane.setMaximumSize(null);
		scrollPane.setPreferredSize(new Dimension(1200, 200));

		JOptionPane.showMessageDialog(operatorFrame, scrollPane, "Providers",JOptionPane.PLAIN_MESSAGE);
		for(int i = 0; i < data.length;i++)	{
			data[i] = tableModel.getValueAt(0, i).toString();
			System.out.println(Integer.toString(i) + ": " + data[i]);
		}
		try{
			ProviderAccount providerAccount = new ProviderAccount(Integer.parseInt(data[0]), 
			data[1], data[2], data[3], data[4],Integer.parseInt(data[5]));
			providerList.add(providerAccount);
			JOptionPane.showMessageDialog(null, "Provider Created");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Provider not created: data formatting issue");
		}
		System.out.println(providerList.get(0).getAddress());
	}
    
    
	/** 
	 * @param id
	 * @param address
	 * @param name
	 * @param city
	 * @param state
	 * @param zip
	 * @throws NumberFormatException
	 */
	public void addPersonEntry(int id, String address, String name,String city, String state, int zip) throws NumberFormatException {
		try{
			ProviderAccount providerAccount = new ProviderAccount(id, address, name, city, state, zip);
			
			providerList.add(providerAccount);
		}catch (NumberFormatException e){
			throw e;
		}
	}
    
	
	/** 
	 * @param id
	 * @return int
	 */
	public int idSearch(int id) {
		for (int i = 0; i < providerList.size(); i++) {
			if (providerList.get(i).getID() == id) {
				return i;
			}
		}
		return -1;
	}

	public ProviderAccount searchID(int id) {
		for (int i = 0; i < providerList.size(); i++) {
			if (providerList.get(i).getID() == id) {
				return providerList.get(i);
			}
		}
		return null;
	}

	public void editPerson(JFrame operatorFrame) {
		String[] columnNames = {"ID", "Address", "Name", "City","State", "Zip"};

		DefaultTableModel tableModel = new DefaultTableModel(null,columnNames){
			@Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
		};
		
		int id = Integer.parseInt(JOptionPane.showInputDialog(operatorFrame, "Enter user id"));
		int index = idSearch(id);
		String[] userData = {
				Integer.toString(providerList.get(index).getID()),
				providerList.get(index).getAddress(), 
				providerList.get(index).getName(), 
				providerList.get(index).getCity(), 
				providerList.get(index).getState(),
				Integer.toString(providerList.get(index).getZip())
			};

		tableModel.addRow(userData);

		JTable personTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(personTable);
		scrollPane.setMaximumSize(null);
		scrollPane.setPreferredSize(new Dimension(1200, 200));
		//implement try catch
		JOptionPane.showMessageDialog(operatorFrame, scrollPane, "Members",JOptionPane.PLAIN_MESSAGE);
		for(int i = 0; i < userData.length;i++)	{
			userData[i] = tableModel.getValueAt(0, i).toString();
			System.out.println(Integer.toString(i) + ": " + userData[i]);
		}
		
		providerList.get(index).setID(Integer.parseInt(userData[0]));
		providerList.get(index).setAddress(userData[1]);
		providerList.get(index).setName(userData[2]);
		providerList.get(index).setCity(userData[3]);
		providerList.get(index).setState(userData[4]);
		providerList.get(index).setZip(Integer.parseInt(userData[5]));
	} 

	public void deletePerson(JFrame operatorFrame) {
		String[] columnNames = {"ID", "Address", "Name", "City","State", "Zip"};
		DefaultTableModel tableModel = new DefaultTableModel(null, columnNames){
			@Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
		};

		int id = Integer.parseInt(JOptionPane.showInputDialog(operatorFrame, "Enter user id"));
		int index = idSearch(id);
		String[] userData = {
				Integer.toString(providerList.get(index).getID()),
				providerList.get(index).getAddress(), 
				providerList.get(index).getName(), 
				providerList.get(index).getCity(), 
				providerList.get(index).getState(),
				Integer.toString(providerList.get(index).getZip())
			};

		tableModel.addRow(userData);

		JTable personTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(personTable);
		scrollPane.setMaximumSize(null);
		scrollPane.setPreferredSize(new Dimension(1200, 200));
		//implement try catch
		JOptionPane.showMessageDialog(operatorFrame, scrollPane, "Members",JOptionPane.PLAIN_MESSAGE);
		providerList.remove(index);
		System.out.println("deleted user:" + id);
	}

	public ProviderAccount[] getEntries() {
		return null;
	}
}
