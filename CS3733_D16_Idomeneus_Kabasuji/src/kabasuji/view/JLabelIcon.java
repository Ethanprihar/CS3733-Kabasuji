package kabasuji.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * JLabelIcon; an image object for easy displaying and scaling of images.
 * @author jwu
 *
 */
public class JLabelIcon extends JLabel {
	/** attributes: img, filename, and dimensions **/
	Image img;
	String filename;
	int dimX;
	int dimY;

	/**
	 * Create new JLabelIcon.
	 * @param filename - filename of image
	 * @param dimX - desired size in x
	 * @param dimY - desired size in y
	 */
	public JLabelIcon(String filename, int dimX, int dimY) {
		this.filename = filename;
		this.dimX = dimX;
		this.dimY = dimY;

		// sets size
		setSize(dimX, dimY);
		// sets image
		setImg(filename);

	}
	/**
	 * Sets the image of JLabelIcon with new given filename (fn).
	 * @param fn
	 */
	public void setImg(String fn) {
		// maps a path to the desired picture
		String path = System.getProperty("user.dir") + File.separator + "src//images" + File.separator + fn;
		// attempts to read picture
		//System.out.println(path);
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
	/**
	 * Get Width.
	 */
	public int getWidth() {
		return dimX;
	}
	/**
	 * Set Width to given input.
	 * @param w
	 */
	public void setWidth(int w) {
		setSize(w, dimY);
	}
	/**
	 * Get Height.
	 */
	public int getHeight() {
		return dimY;
	}
	/**
	 * Set Height to given input.
	 * @param h
	 */
	public void setHeight(int h) {
		setSize(dimX, h);
	}
	/**
	 * Get FileName.
	 * @return
	 */
	public String getFileName(){
		return filename;
	}
	/**
	 * Set new FileName.
	 * @param newfilename
	 */
	public void setFileName(String newfilename){
		filename = newfilename;
	}
	/**
	 * Get Image used.
	 * @return
	 */
	public Image getImage(){
		return img;
	}
	
}
