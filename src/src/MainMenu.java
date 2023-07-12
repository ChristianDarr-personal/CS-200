package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This class is the main class for the project.
 * It initializes the frame and creates the options for actions.
 * 
 * @author Christian Darr
 * 
 */
public class MainMenu {
	
	private JFrame frame;
	private JButton selectUserButton;
	private VerificationController verificationController;
	public enum UserType{
		Provider,
		Manager,
		Operator
	}
	
	/**
	 * Initializes the main program and presents user options
	 */
	public MainMenu() {
		frame = new JFrame("MainMenu");
	    selectUserButton = new JButton("Select User");
	    verificationController = new VerificationController();
	}
	
    /**
     * @param args
     */
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
		mainMenu.openMainMenu();
    }
    
    /**
     * Opens the main menu
     */
    public void openMainMenu() {
    	frame.setTitle("Chocoholics Anonymous Main Menu");

		// selectUserButton.setBorder(BorderFactory.createLineBorder(Color.black));
	    // frame.add(selectUserButton);
		// create the return to main menu button
        JPanel panel = new JPanel();
		JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());
        panel.add(selectUserButton, BorderLayout.CENTER);
		panel.add(Box.createVerticalGlue());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        centerPanel.add(panel, gbc);
        frame.add(centerPanel);

	    selectUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectUser();
		}});

		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
			
        }
    	frame.getContentPane().setBackground(Color.GREEN);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
    }

	/**
	 * This method opens the option menu to select which user to log in as.
	 * After the user selects the user type, they are verified.
	 * Then the main menu closes and the new one opens.
	 */
	public void selectUser() {
		// user options 
    	UserType[] options = {UserType.Provider, UserType.Manager, UserType.Operator};

		// prompt the user to select user type
		int choice = JOptionPane.showOptionDialog(null, "Select an option:", "My Input Dialog",
		JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		boolean verified;
		
		// verify the user
		verified = verificationController.verifyUser(choice);
		
		// if the user is verified, open the menu of the user type
		if(verified) {
			switch (options[choice]) {
				case Provider:
					ProviderMenu providerMenu = new ProviderMenu();
					frame.dispose();
					providerMenu.openMenu();
					break;
				case Manager:
					ManagerMenu managerMenu = new ManagerMenu();
					frame.dispose();
					managerMenu.openMenu();
					break;
				case Operator:
					OperatorMenu opMenu = new OperatorMenu();
					frame.dispose();
					opMenu.openMenu();
					break;
				default:
					System.out.println("No option selected");
			}     
		}															
	}
}



