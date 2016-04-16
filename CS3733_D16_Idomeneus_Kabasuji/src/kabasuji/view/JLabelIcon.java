package kabasuji.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelIcon extends JLabel {
	/** attributes: filename, and dimensions **/
	Image img;
	String filename;
	int dimX;
	int dimY;
	public JLabelIcon(String filename, int dimX, int dimY){
		super();
		this.filename = filename;
		this.dimX = dimX;
		this.dimY = dimY;
		
		// sets size
		setSize(dimX,dimY);
		
		// maps a path to the desired picture
		String path = System.getProperty("user.dir") + File.separator + "src\\images" + File.separator + filename;
		// attempts to read picture
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// scale the picture to desired resolution
		Image scaledImage = img.getScaledInstance(dimX,dimY,Image.SCALE_SMOOTH);
		ImageIcon imgi = new ImageIcon();
		imgi.setImage(scaledImage);
		// set picture on label
		setIcon(imgi);
	}
}
