package levelbuilder.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kabasuji.model.Builder;
import kabasuji.model.Screen;
import kabasuji.view.MainMenu;
import kabasuji.view.TopLevelApplication;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;

public class TopLevelApplicationBuilder extends JFrame {

	public Builder builder;
	public JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public TopLevelApplicationBuilder(Builder builder) {
		this.builder = builder;
		init();
	}
	
	public JPanel getContentPanel(){
		return contentPane;
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
		int x0 = (int) (width - Screen.width)/2;
		int y0 = (int) (height-Screen.height)/2;
		setBounds(x0,y0,Screen.width,Screen.height);
		// not resizable
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create new panel
		BuilderMainMenu panel = new BuilderMainMenu(builder,TopLevelApplicationBuilder.this);
		panel.setBounds(0, 0, Screen.width, Screen.height);
		// ** set contentPanel for JFrame
		setContentPane(panel);
	}
}

