package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToLevelSelectController;
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

public class MainMenu extends JPanel {
	Kabasuji kabasuji;
	TopLevelApplication app;

	/**
	 * Create the panel.
	 */

	public MainMenu(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;

		BufferedImage img = null;
		String path = System.getProperty("user.dir") + File.separator + "src\\images\\pusheen.gif";
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PaintPane panel = new PaintPane(img);
		
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setBounds(250, 90, 500, 90);
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 73));
		
		JLabel lblNewLabel = new JLabel("Odell Dotson");
		lblNewLabel.setBounds(425, 200, 500, 90);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label = new JLabel("Ethan Prihar");
		label.setBounds(425, 250, 500, 90);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("Vishal Rathi");
		label_1.setBounds(425, 301, 500, 90);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("Breanne Happell");
		label_2.setBounds(425, 351, 500, 90);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("yu-Sen Wu");
		label_3.setBounds(425, 402, 500, 90);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Level Select");
		btnNewButton.setBounds(425, 600, 100, 50);
		btnNewButton.setBackground(Color.cyan);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		
		btnNewButton.addMouseListener(new GoToLevelSelectController(kabasuji, app));
		
		setLayout(null);
		add(lblNewLabel);
		add(label);
		add(label_1);
		add(label_2);
		add(label_3);
		add(lblKabasuji);
		add(btnNewButton);
		
		panel.setBounds(0, 0, 1000, 800);
		add(panel);
	}
}
