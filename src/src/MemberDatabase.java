package src;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MemberDatabase{

	private static MemberDatabase instance;
	private ArrayList<MemberAccount> memberList;
    
    private MemberDatabase() {
        // Private constructor to prevent direct instantiation
		memberList = new ArrayList<MemberAccount>();
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
				MemberAccount account = new MemberAccount(id, address, name, city, state, zip);
				memberList.add(account);
			}
		myReader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
		//Read in list of members stored (not yet persistent data, just for ease of testing)
		

    }
    
    
	/** 
	 * @return MemberDatabase
	 */
	public static synchronized MemberDatabase getInstance() {
        if (instance == null) {
            instance = new MemberDatabase();
        }
        return instance;
    }

	
	/** 
	 * @param operatorFrame
	 */
	public void addPerson(JFrame operatorFrame) {
		System.out.println(memberList.size());
		String[] columnNames = {"ID", "Address", "Name", "City","State", "Zip"};
		String[] data = {"","","","","",""};
		
		DefaultTableModel tableModel = new DefaultTableModel(null, columnNames){
			@Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
		};
		tableModel.addRow(data);
		
        JTable personTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(personTable);
		scrollPane.setMaximumSize(null);
		scrollPane.setPreferredSize(new Dimension(1200, 200));
	
		JOptionPane.showMessageDialog(operatorFrame, scrollPane, "Members",JOptionPane.PLAIN_MESSAGE);
		for(int i = 0; i < data.length;i++)	{
			data[i] = tableModel.getValueAt(0, i).toString();
			System.out.println(Integer.toString(i) + ": " + data[i]);
		}
		try {
			addPersonEntry(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4],Integer.parseInt(data[5]));
			JOptionPane.showMessageDialog(null, "Member Added");
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Member Not Added - input formatting");
		}
		
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
		if(id < 0 || zip <0) {
			throw new NumberFormatException("Invlaid Input - negative number");
		}
		try{
			MemberAccount memberAccount = new MemberAccount(id, address, name, city, state, zip);
			memberList.add(memberAccount);
		}catch (NumberFormatException e){
			throw e;
		}
	}
	
	
	/** 
	 * @param operatorFrame
	 */
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
		if(index == -1){
			JOptionPane.showMessageDialog(null, "Member not found");
			return;
		}
		String[] userData = {
				Integer.toString(memberList.get(index).getID()),
				memberList.get(index).getAddress(), 
				memberList.get(index).getName(), 
				memberList.get(index).getCity(), 
				memberList.get(index).getState(),
				Integer.toString(memberList.get(index).getZip())
			};

		tableModel.addRow(userData);

		JTable personTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(personTable);
		scrollPane.setMaximumSize(null);
		scrollPane.setPreferredSize(new Dimension(1200, 200));
		JOptionPane.showMessageDialog(operatorFrame, scrollPane, "Members",JOptionPane.PLAIN_MESSAGE);
		
		memberList.remove(index);
		JOptionPane.showMessageDialog(null, "Member Deleted");
		System.out.println("deleted user:" + id);
	}
	
	
	/** 
	 * @param operatorFrame
	 */
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
		if(index == -1){
			JOptionPane.showMessageDialog(null, "Member Added");
			return;
		}
		String[] userData = {
				Integer.toString(memberList.get(index).getID()),
				memberList.get(index).getAddress(), 
				memberList.get(index).getName(), 
				memberList.get(index).getCity(), 
				memberList.get(index).getState(),
				Integer.toString(memberList.get(index).getZip())
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
		try{
			memberList.get(index).setID(Integer.parseInt(userData[0]));
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Improper formatting for ID");
		}
		memberList.get(index).setAddress(userData[1]);
		memberList.get(index).setName(userData[2]);
		memberList.get(index).setCity(userData[3]);
		memberList.get(index).setState(userData[4]);
		try{
			memberList.get(index).setZip(Integer.parseInt(userData[5]));
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Improper formatting for Zip");
		}
	} 

	public int idSearch(int id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getID() == id) {
				return i;
			}
		}
		return -1;
	}

	public MemberAccount searchID(int id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getID() == id) {
				return memberList.get(i);
			}
		}
		return null;
	}


	public ArrayList<MemberAccount> getMemberAccounts(){
		return memberList;
	}
}
