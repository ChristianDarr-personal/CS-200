package src;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This is the manager menu that provides the options for the actions of a manager
 * 
 * @author Christian Darr
 */
public class ManagerMenu {

    private JFrame managerFrame;

    /**
     * Constructor for the managerMenu
     * Declares the main frame
     */
    public ManagerMenu(){
        managerFrame = new JFrame("Chocoholics Anonymous Manager Menu");
    }
    
	/**
	 * Opens the managerMenu, with the necessary buttons
	 */
	public void openMenu() {
        // define buttons
        JButton singleReportButton = new JButton("Generate Single Report");
        JButton allReportsButton = new JButton("Generate All Reports");

        // add buttons to frame and center them.
        JPanel panel = new JPanel();
		JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());
	    panel.add(singleReportButton);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(allReportsButton);
		panel.add(Box.createVerticalGlue());
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        centerPanel.add(panel, gbc);
		managerFrame.add(centerPanel);

        // create the return to main menu button
        JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton returnButton = new JButton("Return to Main Menu");
        returnPanel.add(returnButton);
        managerFrame.add(returnPanel, BorderLayout.NORTH);
        returnButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = new MainMenu();
                managerFrame.dispose();
                mainMenu.openMainMenu();
        	}
    	});

        
        ReportController reportController = new ReportController();
        // Generate all reports buttons
        allReportsButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Generate All Reports");
                reportController.generateAllReports();
        	}
    	});

        // Generate a single report. Prompt the user for the 4 types of reports
        singleReportButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String[] reportOptions = {"Member Reports", "Provider Reports", "Summary Report"};
                int reportChoice = JOptionPane.showOptionDialog(null, "Select an option:", "My Input Dialog",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, reportOptions, reportOptions[0]);
                switch (reportChoice){
                    case 0:
                        reportController.generateMemberReports();
                        break;
                    case 1:
                        reportController.generateProviderReports();
                        break;
                    case 2:
                        reportController.generateSummaryReport();
                        break;
                    default:
                        break;
                }
        	}
    	});

        // wrap up frame information
	    managerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    managerFrame.setVisible(true);
    }
}
