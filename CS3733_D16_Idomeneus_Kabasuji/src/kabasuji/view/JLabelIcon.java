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

	public JLabelIcon(String filename, int dimX, int dimY) {
		super();
		this.filename = filename;
		this.dimX = dimX;
		this.dimY = dimY;

		// sets size
		setSize(dimX, dimY);
		setImg(filename);

	}

	public void setImg(String fn) {
		// maps a path to the desired picture
		String path = System.getProperty("user.dir") + File.separator + "src//images" + File.separator + fn;
		// attempts to read picture
		System.out.println(path);
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// scale the picture to desired resolution
		Image scaledImage = img.getScaledInstance(dimX, dimY, Image.SCALE_SMOOTH);
		ImageIcon imgi = new ImageIcon();
		imgi.setImage(scaledImage);
		// set picture on label
		setIcon(imgi);
		repaint();
	}

	// getter width
	public int getWidth() {
		return dimX;
	}

	// setter width
	public void setWidth(int w) {
		setSize(w, dimY);
	}

	// getting height
	public int getHeight() {
		return dimY;
	}

	// setter width
	public void setHeight(int h) {
		setSize(dimX, h);
	}
	public String getFileName(){
		return filename;
	}
}
