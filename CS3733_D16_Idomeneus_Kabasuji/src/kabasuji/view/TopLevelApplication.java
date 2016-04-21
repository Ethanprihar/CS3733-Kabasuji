package kabasuji.view;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;
import java.awt.Dimension;

/**
 * Top level GUI class; acts as the container of all gui elements.
 * 
 * @author jwu
 *
 */

public class TopLevelApplication extends JFrame {
	// top level model element
	public Kabasuji kabasuji;
	// contentPanel that will be each different screen
	public JPanel contentPanel;
	/**
	 * Create the frame.
	 */
	public TopLevelApplication(Kabasuji kabasuji) {
		this.kabasuji = kabasuji;
		init();
	}
	// getter contentPanel
	public JPanel getContentPanel(){
		return contentPanel;
	}
	// setter contentPanel
	public void setContentPanel(JPanel j){
		// set location and size relative to JFrame ***
		j.setBounds(0,0,Screen.width,Screen.height);
		// change contentPanel
		setContentPane(j);
		// redraw screen
		repaint();
	}
	void init(){
		// puts top left corner into 10% of screen height and width
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x0 = (int) (0.1*screenSize.getWidth());
		int y0 = (int) (0.1*screenSize.getHeight());
		// sets location and size of JFrame
		setBounds(x0,y0,Screen.width,Screen.height);
		// not resizable
		setResizable(false);
		// standard close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create new panel (MainMenu) 
		MainMenu panel = new MainMenu(kabasuji,TopLevelApplication.this);
		// set location and size relative to JFrame
		panel.setBounds(0, 0, Screen.width, Screen.height);
		// ** set contentPanel for JFrame
		setContentPane(panel);
	}
}

