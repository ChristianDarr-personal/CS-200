package src;

import javax.swing.*;

public class OperatorController {
    
    private MemberDatabase memberDatabase;
    private ProviderDatabase providerDatabase;
    public OperatorController(){
        memberDatabase = MemberDatabase.getInstance();
        providerDatabase = ProviderDatabase.getInstance();
    }

    
    /** 
     * @param operatorFrame
     */
    public void editMemberDatabase(JFrame operatorFrame){
        String[] options = {"Add Member", "Edit Member", "DeleteMember"};

        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "My Input Dialog",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	    switch (choice) {
            case 0:
                memberDatabase.addPerson(operatorFrame);
                break;
            case 1:
                memberDatabase.editPerson(operatorFrame);
                break;
            case 2:
            memberDatabase.deletePerson(operatorFrame);
                break;
            default:
                System.out.println("No option selected");
        }     
    }

    
    /** 
     * @param operatorFrame
     */
    public void editProviderDatabase(JFrame operatorFrame){
        String[] options = {"Add Provider", "Edit Provider", "Delete Provider"};

        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "My Input Dialog",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	    switch (choice) {
            case 0:
                providerDatabase.addPerson(operatorFrame);
                break;
            case 1:
                providerDatabase.editPerson(operatorFrame);
                break;
            case 2:
                providerDatabase.deletePerson(operatorFrame);
                break;
            default:
                System.out.println("No option selected");
        }     
    }


}
