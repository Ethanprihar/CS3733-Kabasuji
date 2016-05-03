package levelbuilder.view;

import javax.swing.JOptionPane;
/**
 * this class is used to display an error message to the player if they do something
 * wrong
 * @author V
 *
 */
public class ErrorDialogBox {

	/**
	 * creates a dialogue box with the provided message and title
	 * @param infoMessage message for the dialogue box
	 * @param titleBar title for the dialogue box
	 */
    public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}