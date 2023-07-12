package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * This class creates the provider menu and its options
 * 
 * @author Travis
 * 
 */
public class ProviderMenu {
	private JFrame providerFrame;
	private ProviderController providerController;
	
	/**
	 * This initializes the frame and controller for the provider menu
	 */
	public ProviderMenu() {
		providerFrame = new JFrame("Chocoholics Anonymous Provider Menu");
		providerController = new ProviderController();
	}
	
	/**
	 * This adds the buttons for the actions of the provider
	 */
	public void openMenu() {
		// create and center buttons
		JButton getDirectoryButton = new JButton("Provider Directory");
		JButton billServiceButton = new JButton("Bill Service");
        JMenuBar menuBar = new JMenuBar();
        JPanel panel = new JPanel();
		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Return to Main Menu");
		returnPanel.add(returnButton);
		providerFrame.add(returnPanel, BorderLayout.NORTH);
        panel.add(getDirectoryButton);
        panel.add(billServiceButton);
		providerFrame.add(panel, BorderLayout.CENTER);

		// create action listener for the return button
		returnButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = new MainMenu();
                providerFrame.dispose();
                mainMenu.openMainMenu();
        	}
    	});

		// create action listener for the get provider directory button
        getDirectoryButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		providerController.getDirectory(providerFrame);
        	}
    	});

		// create action listener for te bill service button
        billServiceButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		providerController.billService(providerFrame);	
        	}
    	});
        
		// wrap up frame information 
        providerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        providerFrame.setJMenuBar(menuBar);
        providerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        providerFrame.setVisible(true);  
    }
}
