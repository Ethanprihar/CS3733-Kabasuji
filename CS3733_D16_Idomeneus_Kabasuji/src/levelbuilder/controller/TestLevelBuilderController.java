package levelbuilder.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kabasuji.model.Builder;
import kabasuji.model.Kabasuji;
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
		
		builder.setEndCondition(Integer.parseInt(ec.getText()));
		builder.saveLevel(numOfPiecesOnLoad);

		int index = builder.getLevels().indexOf(builder.getSelectedLevel());
		builder.saveToDisc();
		
		Kabasuji kabasuji = new Kabasuji();
		kabasuji.selectLevel(kabasuji.getLevels().get(index));
		TopLevelApplication app1 = new TopLevelApplication(kabasuji);

		ChangeScreenBuilderMove gtsm = new ChangeScreenBuilderMove(Screen.PlayLevel);

		// Attempt to execute action on model
		if (gtsm.execute(builder)) {
			
			kabasuji.loadLevel(); 
			
			// first make the foundation panel and pass model and container
			// panel
			PlayLevelPanel plp = new PlayLevelPanel(kabasuji, app1);

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

			// set the content panel of container to contain PlayLevelPanel
			app.setContentPanel(plp);
		}
	}
	public void mouseEntered(MouseEvent e) {
		button.setImg("generalhoverbutton.png");
	}

	public void mouseExited(MouseEvent e) {
		button.setImg(fn);
	}
}
