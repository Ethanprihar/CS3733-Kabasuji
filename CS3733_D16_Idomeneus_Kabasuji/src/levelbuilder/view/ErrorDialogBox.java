package levelbuilder.view;

import javax.swing.JOptionPane;

public class ErrorDialogBox {

    public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}