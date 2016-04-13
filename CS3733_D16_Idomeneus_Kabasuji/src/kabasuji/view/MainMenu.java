package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToLevelSelectController;
import kabasuji.model.Kabasuji;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		String path = System.getProperty("user.dir") + File.separator + "src\\images\\waterfall.jpg";
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PaintPane panel = new PaintPane(img);
		
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
		
		panel.setBounds(0, 0, 520, 656);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Odell Dotson");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label = new JLabel("Ethan Prihar");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("Vishal Rathi");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("Breanne Happell");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("yu-Sen Wu");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Level Select");
		btnNewButton.setBackground(Color.cyan);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		
		btnNewButton.addMouseListener(new GoToLevelSelectController(kabasuji, app));
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 73));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(174)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)))
				.addComponent(lblKabasuji, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblKabasuji, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
