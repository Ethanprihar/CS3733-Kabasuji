package kabasuji.view;

import kabasuji.model.Piece;

/**
 * ZoomPanel; to display enlarged PieceView.
 * @author jwu
 *
 */
public class ZoomPanel extends JLabelIcon {
	/** attributes: img, filename, and dimensions **/
	/**
	 * Create new ZoomPanel.
	 * @param filename filename of image
	 * @param dimX desired size in x
	 * @param dimY desired size in y
	 */
	public ZoomPanel(String filename, int dimX, int dimY) {
		super(filename, dimY, dimY);
		super.setup();
	}
	/**
	 * Removes current display on ZoomPanel and displays the PieceView on the ZoomPanel. 
	 * @param p piece of interest
	 */
	public void displayPieceView(Piece p){
		// clear components
		removeAll();
		// create pieceview
		PieceView pieceview = new PieceView(p);
		pieceview.setBounds(0, 0, (int) getSize().getWidth(), (int) getSize().getHeight());
		pieceview.setupPiece();
		// add to zoompanel and repaint
		add(pieceview);
		// repaints the zoompanel
		repaint();
	}
}
