package levelbuilder.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.controller.moves.ChangeScreenMove;
import kabasuji.model.Builder;
import kabasuji.model.Kabasuji;
import kabasuji.model.Piece;
import kabasuji.model.Screen;
import kabasuji.view.BoardView;
import kabasuji.view.BullpenView;
import kabasuji.view.JLabelIcon;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;
import levelbuilder.controller.moves.ChangeScreenBuilderMove;
import levelbuilder.view.TopLevelApplicationBuilder;

/**
 * Controller for Moving Screens; Go To BuilderMainMenu Screen (Panel)
 * 
 * When the button is pressed to attempt to go to the next screen, the model
 * will update what screen it is on and the gui will reflect the changes
 * 
 * @author jwu
 *
 */
public class TestLevelBuilderController extends MouseAdapter {

	/** Entity and Boundaries Associated **/
	Builder builder;
	TopLevelApplicationBuilder app;
	JPanel contentPanel;	
	JLabelIcon button;	
	String fn;
	JTextField ec;
	int[] numOfPiecesOnLoad;

	public TestLevelBuilderController(Builder builder, TopLevelApplicationBuilder app, JLabelIcon button, int[] numOfPiecesOnLoad, JTextField ec) {
		this.builder = builder;
		this.app = app;
		this.contentPanel = app.getContentPanel();		
		this.button = button;
		this.fn = button.getFileName();
		this.numOfPiecesOnLoad = numOfPiecesOnLoad;
		this.ec = ec;
	}

	/**
	 * Whenever mouse is pressed (left button), attempt to select object. This
	 * is a GUI controller.
	 */
	public void mousePressed(MouseEvent me) {
	/*** MODEL CHANGES ***/
		builder.setEndCondition(1000);
		builder.makeTestLevel(numOfPiecesOnLoad);
		Kabasuji kabasuji = new Kabasuji();
		kabasuji.loadTestLevels();
		kabasuji.selectLevel(kabasuji.getLevels().get(0));
		TopLevelApplication app1 = new TopLevelApplication(kabasuji);

		// Created ChangeScreenMove and input desired screen
		//ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.PlayLevel);

		// Attempt to execute action on model
		//if (gtsm.execute(builder)) {
			
		kabasuji.loadLevel(); 
		
		// first make the foundation panel and pass model and container
		// panel
		PlayLevelPanel plp = new PlayLevelPanel(kabasuji, app1, 1);
		
		System.out.println("I am in Test Level again");

		// create components of panel and pass model and container panel
		BullpenView bpv = new BullpenView(kabasuji, plp, 4,
				(int) (kabasuji.selectedLevel.getBullpen().getPieces().size() + 3) / 4);
		BoardView bv = new BoardView(kabasuji, plp);

		// set location and size of components (**necessary)
		bv.setBounds((int) (Screen.width * 0.35), (int) (Screen.height * 0.36), (int) (Screen.height * 0.54),
				(int) (Screen.height * 0.54));
		bpv.setBounds((int) (Screen.width * 0.05), (int) (Screen.height * 0.05), (int) (Screen.width * 0.25),
				(int) (Screen.height * 0.85));

		// remove all components from PLP -> update PLP -> add controllers
		plp.removeAll();
		plp.updatePlayLevelPanel(bv, bpv);
		plp.addControllers();

		// repaint the PlayLevelPanel
		plp.repaint();
		
		System.out.println(kabasuji.selectedLevel.getBullpen().getPieces().size());
		// set the content panel of container to contain PlayLevelPanel
		//app.setContentPanel(plp);
		
		JFrame frame = new JFrame("TestWindow");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		int x0 = (int) (width - Screen.width)/2;
		int y0 = (int) (height-Screen.height)/2;
		frame.setBounds(x0,y0,Screen.width,Screen.height);
		// not resizable
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		plp.setBounds(0,0,Screen.width,Screen.height);
		frame.setContentPane(plp);
		frame.repaint();
	}
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg(fn);
	}
}
