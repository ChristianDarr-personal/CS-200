package src;


import javax.swing.JOptionPane;


public class VerificationController {

	
    /** 
     * @param user
     * @return boolean
     */
    public boolean verifyUser(int user) {
		String[] usernames = {"user1", "user2", "user3"};
		String[] passwords = {"pass1", "pass2", "pass3"};
		String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        if (username != null && password != null && username.equals(usernames[user]) && password.equals(passwords[user])) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
	}
}
