package kabasuji.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import java.awt.Dimension;

public class TopLevelApplication extends JFrame {

	public Kabasuji kabasuji;
	public JPanel contentPanel;
	/**
	 * Create the frame.
	 */
	public TopLevelApplication(Kabasuji kabasuji) {
		this.kabasuji = kabasuji;
		init();
	}
	
	public JPanel getContentPanel(){
		return contentPanel;
	}
	public void setContentPanel(JPanel j){
		j.setBounds(0,0,Screen.width,Screen.height);
		setContentPane(j);
		repaint();
	}
	void init(){
		// puts top left corner into 10% of screen height and width
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		int x0 = (int) (0.1*width);
		int y0 = (int) (0.1*height);
		setBounds(x0,y0,Screen.width,Screen.height);
		// not resizable
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create new panel
		MainMenu panel = new MainMenu(kabasuji,TopLevelApplication.this);
		panel.setBounds(0, 0, Screen.width, Screen.height);
		// ** set contentPanel for JFrame
		setContentPane(panel);
	}
}

