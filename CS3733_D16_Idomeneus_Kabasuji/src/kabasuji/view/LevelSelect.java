package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.model.Kabasuji;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;

public class LevelSelect extends JPanel {
	
	Kabasuji kabasuji;
	TopLevelApplication app;

	/**
	 * Create the panel.
	 */
	public LevelSelect(Kabasuji kabasuji, TopLevelApplication app) {
		
		this.kabasuji = kabasuji;
		this.app = app;
		
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		JLabel lblKabasuji = new JLabel("Kabasuji Level Select");
		lblKabasuji.setBounds(30, 30, 970, 90);
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 73));
		
		JButton btnNewButton_1 = new JButton("Level 1");
		btnNewButton_1.setBounds(200, 200, 100, 100);
		btnNewButton_1.setBackground(Color.orange);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setOpaque(true);
		
		BufferedImage img = null;
		try {
			// maps path to the image file
			String path = System.getProperty("user.dir") + File.separator + "src\\images\\star.png";
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
		}
		
		PaintPane panel = new PaintPane(img);
		PaintPane panel1 = new PaintPane(img);
		
		JButton btnNewButton_2 = new JButton("Level 2");
		btnNewButton_2.setBounds(350, 200, 100, 100);
		btnNewButton_2.setBackground(Color.gray);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setOpaque(true);
		
		JButton btnNewButton_3 = new JButton("Level 3");
		btnNewButton_3.setBounds(500, 200, 100, 100);
		btnNewButton_3.setBackground(Color.gray);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setOpaque(true);
		
		JButton btnNewButton_4 = new JButton("Level 4");
		btnNewButton_4.setBounds(650, 200, 100, 100);
		btnNewButton_4.setBackground(Color.gray);
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setOpaque(true);
		
		JButton btnNewButton_5 = new JButton("Level 5");
		btnNewButton_5.setBounds(800, 200, 100, 100);
		btnNewButton_5.setBackground(Color.gray);
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setOpaque(true);
		
		JButton btnNewButton_6 = new JButton("Level 6");
		btnNewButton_6.setBounds(200, 350, 100, 100);
		btnNewButton_6.setBackground(Color.gray);
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setOpaque(true);
		 
		JButton btnNewButton_7 = new JButton("Level 7");
		btnNewButton_7.setBounds(350, 350, 100, 100);
		btnNewButton_7.setBackground(Color.gray);
		btnNewButton_7.setForeground(Color.BLACK);
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setOpaque(true);
		
		JButton btnNewButton_8 = new JButton("Level 8");
		btnNewButton_8.setBounds(500, 350, 100, 100);
		btnNewButton_8.setBackground(Color.gray);
		btnNewButton_8.setForeground(Color.BLACK);
		btnNewButton_8.setContentAreaFilled(false);
		btnNewButton_8.setOpaque(true);
		
		JButton btnNewButton_9 = new JButton("Level 9");
		btnNewButton_9.setBounds(650, 350, 100, 100);
		btnNewButton_9.setBackground(Color.gray);
		btnNewButton_9.setForeground(Color.BLACK);
		btnNewButton_9.setContentAreaFilled(false);
		btnNewButton_9.setOpaque(true);
		
		
		JButton btnNewButton_10 = new JButton("Level 10");
		btnNewButton_10.setBounds(800, 350, 100, 100);
		btnNewButton_10.setBackground(Color.gray);
		btnNewButton_10.setForeground(Color.BLACK);
		btnNewButton_10.setContentAreaFilled(false);
		btnNewButton_10.setOpaque(true);
		
		
		JButton btnNewButton_11 = new JButton("Level 11");
		btnNewButton_11.setBounds(200, 500, 100, 100);
		btnNewButton_11.setBackground(Color.gray);
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setContentAreaFilled(false);
		btnNewButton_11.setOpaque(true);
		
		
		JButton btnNewButton_12 = new JButton("Level 12");
		btnNewButton_12.setBounds(350, 500, 100, 100);
		btnNewButton_12.setBackground(Color.gray);
		btnNewButton_12.setForeground(Color.BLACK);
		btnNewButton_12.setContentAreaFilled(false);
		btnNewButton_12.setOpaque(true);
		
		JButton btnNewButton_13 = new JButton("Level 13");
		btnNewButton_13.setBounds(500, 500, 100, 100);
		btnNewButton_13.setBackground(Color.gray);
		btnNewButton_13.setForeground(Color.BLACK);
		btnNewButton_13.setContentAreaFilled(false);
		btnNewButton_13.setOpaque(true);
		
		JButton btnNewButton_14 = new JButton("Level 14");
		btnNewButton_14.setBounds(650, 500, 100, 100);
		btnNewButton_14.setBackground(Color.gray);
		btnNewButton_14.setForeground(Color.BLACK);
		btnNewButton_14.setContentAreaFilled(false);
		btnNewButton_14.setOpaque(true);
		
		JButton btnNewButton_15 = new JButton("Level 15");
		btnNewButton_15.setBounds(800, 500, 100, 100);
		btnNewButton_15.setBackground(Color.gray);
		btnNewButton_15.setForeground(Color.BLACK);
		btnNewButton_15.setContentAreaFilled(false);
		btnNewButton_15.setOpaque(true);
		
		JButton btnNewButton_16 = new JButton("Quit");
		btnNewButton_16.setBounds(500, 650, 100, 100);
		btnNewButton_16.setBackground(Color.cyan);
		btnNewButton_16.setForeground(Color.BLACK);
		btnNewButton_16.setContentAreaFilled(false);
		btnNewButton_16.setOpaque(true);
		
		JButton btnReturnToTitle = new JButton("Next");
		btnReturnToTitle.setBounds(650, 650, 100, 100);
		btnReturnToTitle.setBackground(Color.cyan);
		btnReturnToTitle.setForeground(Color.BLACK);
		btnReturnToTitle.setContentAreaFilled(false);
		btnReturnToTitle.setOpaque(true);
		
		setLayout(null);
		add(btnNewButton_16);
		add(btnNewButton_15);
		add(btnNewButton_10);
		add(btnNewButton_5);
		add(btnNewButton_6);
		add(btnNewButton_7);
		add(btnNewButton_8);
		add(btnNewButton_9);
		add(btnNewButton_1);
		add(btnNewButton_2);
		add(btnNewButton_3);
		add(btnNewButton_4);
		add(btnNewButton_11);
		add(btnReturnToTitle);
		add(btnNewButton_12);
		add(btnNewButton_13);
		add(btnNewButton_14);
		add(lblKabasuji);
		
		panel.setBounds(228, 279, 10, 10);
		add(panel);
		
		panel1.setBounds(257, 279, 10, 10);
		add(panel1);
		
	}
}
