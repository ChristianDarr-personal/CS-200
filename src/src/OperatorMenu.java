package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *  This menu provides the options for the actions of an operator.
 *  
 * @author Christian Darr
 */
public class OperatorMenu {
    private JButton editMemberDatabaseButton;
	private JButton editProviderDatabaseButton;
    private JFrame operatorFrame;
	private OperatorController operatorController;
    
	/**
	 * This is the constructor for this class, creating the frame, controller, and buttons.
	 */
    public OperatorMenu(){
        operatorFrame = new JFrame("Chocoholics Anonymous Operator Menu");
		operatorController = new OperatorController();
        editMemberDatabaseButton = new JButton("Edit Member Database");
		editProviderDatabaseButton = new JButton("Edit Provider Database"); 
    }
    
    /**
     * This opens the menu and presents the options.
     */
	public void openMenu() {
		//Wrap multiple buttons in a panel, then add panel to frame, center it
		JMenuBar menuBar = new JMenuBar();
		JPanel panel = new JPanel();
		JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());
	    panel.add(editMemberDatabaseButton);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(editProviderDatabaseButton);
		panel.add(Box.createVerticalGlue());
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        centerPanel.add(panel, gbc);
		operatorFrame.add(centerPanel);

		// create return to main menu button
		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton returnButton = new JButton("Return to Main Menu");
        returnPanel.add(returnButton);
        operatorFrame.add(returnPanel, BorderLayout.NORTH);
        returnButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = new MainMenu();
                operatorFrame.dispose();
                mainMenu.openMainMenu();
        	}
    	});

		// action listener for edit member database
	    editMemberDatabaseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operatorController.editMemberDatabase(operatorFrame);
		}});

		// action listener for edit provider database
		editProviderDatabaseButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				operatorController.editProviderDatabase(operatorFrame);
			}
		});

		// frame wrap up information
    	operatorFrame.getContentPane().setBackground(Color.GREEN);
	    operatorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    operatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    operatorFrame.setVisible(true);
    }
}
