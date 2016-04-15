package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToLevelSelectController;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MainMenu extends JPanel {
	Kabasuji kabasuji;
	TopLevelApplication app;

	/**
	 * Create the panel.
	 */

	public MainMenu(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;

		Image img = null;
		Image img2 = null;
		
		String path = System.getProperty("user.dir") + File.separator + "src\\images\\waterfall.jpg";
		String path2 = System.getProperty("user.dir") + File.separator + "src\\images\\star_score.png";
		try {
			img = ImageIO.read(new File(path));
			img2 = ImageIO.read(new File(path2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		PaintPane panel = new PaintPane(img);
		
		String path1 = System.getProperty("user.dir") + File.separator + "src\\images\\clover.png";
	
		Image scaledImage2 = img.getScaledInstance(Screen.width,Screen.height,Image.SCALE_SMOOTH);
		ImageIcon imgi2 = new ImageIcon();
		imgi2.setImage(scaledImage2);
		
		JLabel panel = new JLabel(imgi2);
		JLabel panel1 = new JLabel(new ImageIcon(path1));
		
		Image scaledImage = img2.getScaledInstance(10,10,Image.SCALE_SMOOTH);
		ImageIcon imgi = new ImageIcon();
		imgi.setImage(scaledImage);
		

		
		JLabel panel2 = new JLabel(imgi);
		panel2.setBounds(0,0,700,700);
		panel1.setSize(700,700);
		panel1.setLocation(0,0);
		
		Dimension mmSize = this.getSize();
		double width = mmSize.getWidth();
		double height = mmSize.getHeight();
		
		int x0 = (int) (0.1*width);
		int x1 = (int) (0.8*width);
		int y0 = (int) (0.1*height);
		int y1 = (int) (0.8*height);
		
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		setLayout(null);
		
		panel.setBounds(0, 0, Screen.width, Screen.height);
		add(panel);
		
		String[] names = {"Odell Dotson", "Breanne Happell", "Ethan Prihar", "Vishal Rathi","Yu-sen Wu"};
		JLabel[] label = new JLabel[names.length];
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setFont(new Font("Onyx", Font.BOLD, 125));
		lblKabasuji.setSize(500,100);
		lblKabasuji.setLocation((int) ((Screen.width-lblKabasuji.getSize().getWidth())/2), (int)((Screen.height)/(names.length+3)));
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < names.length ;i++){
			label[i] = new JLabel(names[i]);
			label[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			label[i].setSize(200, 50);
			label[i].setLocation((int) ((Screen.width-label[i].getSize().getWidth())/2), (int)((Screen.height)/(names.length+3))*(i+2));
			label[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		
		JButton label_5 = new JButton("Level Select");
		
		label_5.setBackground(Color.cyan);
		label_5.setForeground(Color.BLACK);
		label_5.setContentAreaFilled(false);
		label_5.setOpaque(true);
		label_5.setSize(200, 50);
		label_5.setLocation((int) ((Screen.width-label_5.getSize().getWidth())/2), (int)((Screen.height)/(names.length+3))*(names.length+2));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		System.out.println(Screen.width);
		
		panel.addMouseListener(new GoToLevelSelectController(kabasuji, app));
		
		
//		panel.add(lblKabasuji);
//		panel.add(label[0]);
//		panel.add(label[1]);
//		panel.add(label[2]);
//		panel.add(label[3]);
//		panel.add(label[4]);
//		panel.add(label_5);
//		panel.add(panel1);
		panel.add(panel2);
	}
	
}
