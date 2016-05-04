package levelbuilder.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import kabasuji.model.Builder;
import kabasuji.model.Screen;
import java.awt.Dimension;
/**
 * this class is the top level application panel for the builder, all other panels
 * are displayed in this panel
 * @author V & J
 *
 */
@SuppressWarnings("serial")
public class TopLevelApplicationBuilder extends JFrame {

	/** The builder that is being used in the top level application. */
	public Builder builder;
	/** The content pane that the top level application displays. */
	public JPanel contentPane;
	/**
	 * constructor for the frame.
	 * @builder the builder entity that records the state
	 */
	public TopLevelApplicationBuilder(Builder builder) {
		this.builder = builder;
		init();
	}
	
	/**
	 * returns the content panel
	 * @return the content panel
	 */
	public JPanel getContentPanel(){
		return contentPane;
	}
	/**
	 * sets the content panel to be the given panel
	 * @param j the panel to become the content panel
	 */
	public void setContentPanel(JPanel j){
		j.setBounds(0,0,Screen.width,Screen.height);
		setContentPane(j);
		repaint();
	}
	/**
	 * this function initializes the screen by setting parameters of the panel
	 * and displaying the main menu
	 */
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

