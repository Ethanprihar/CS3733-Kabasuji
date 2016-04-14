package levelbuilder.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToLevelSelectController;
import kabasuji.model.Builder;
import levelbuilder.controller.CreateNewLevelBuilderController;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class BuilderMainMenu extends JPanel {
	Builder builder;
	TopLevelApplicationBuilder app;
	/**
	 * Create the panel.
	 */
	// The Image to store the background image in.

	public BuilderMainMenu(Builder builder, TopLevelApplicationBuilder app) {
		this.builder = builder;
		this.app = app;
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		JLabel lblKabasuji = new JLabel("Builder");
		lblKabasuji.setBounds(123, 11, 500, 90);
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 73));
		
		JLabel lblNewLabel = new JLabel("Odell Dotson");
		lblNewLabel.setBounds(285, 94, 500, 90);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label = new JLabel("Ethan Prihar");
		label.setBounds(285, 149, 500, 90);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("Vishal Rathi");
		label_1.setBounds(285, 195, 500, 90);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("Breanne Happell");
		label_2.setBounds(285, 250, 500, 90);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("yu-Sen Wu");
		label_3.setBounds(285, 291, 500, 90);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Level Select");
		btnNewButton.setBounds(20, 33, 100, 50);
		btnNewButton.setBackground(Color.cyan);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		
		JButton btnNewButton1 = new JButton("Load Level");
		btnNewButton1.setBounds(20, 94, 100, 50);
		btnNewButton1.setBackground(Color.cyan);
		btnNewButton1.setForeground(Color.BLACK);
		btnNewButton1.setContentAreaFilled(false);
		btnNewButton1.setOpaque(true);
		
		JButton btnNewButton2 = new JButton("New Level");
		btnNewButton2.setBounds(20, 155, 100, 50);
		btnNewButton2.setBackground(Color.cyan);
		btnNewButton2.setForeground(Color.BLACK);
		btnNewButton2.setContentAreaFilled(false);
		btnNewButton2.setOpaque(true);
		
		btnNewButton2.addMouseListener(new CreateNewLevelBuilderController(builder, app));
		
		setLayout(null);
		add(lblNewLabel);
		add(label);
		add(label_1);
		add(label_2);
		add(label_3);
		add(lblKabasuji);
		add(btnNewButton);
		add(btnNewButton1);
		add(btnNewButton2);
	}
}
