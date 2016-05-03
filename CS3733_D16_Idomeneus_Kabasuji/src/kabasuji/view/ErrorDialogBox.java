package kabasuji.view;

import javax.swing.JOptionPane;
/**
 * Error Box Display for User Interaction.
 * @author vkr
 *
 */
public class ErrorDialogBox {

    public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.
    }
}