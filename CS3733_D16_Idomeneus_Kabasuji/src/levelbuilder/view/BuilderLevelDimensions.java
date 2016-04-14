package levelbuilder.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.model.Builder;
import levelbuilder.controller.GoToMainMenuBuilderController;
import levelbuilder.controller.SelectDimensionsBuilderController;
import levelbuilder.controller.SelectLevelModeBuilderController;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuilderLevelDimensions extends JPanel {
	private JTextField textField;
	
	Builder builder;
	TopLevelApplicationBuilder app;

	/**
	 * Create the panel.
	 */
	public BuilderLevelDimensions(Builder builder, TopLevelApplicationBuilder app) {
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		JLabel lblKabasuji = new JLabel("Builder Level Dimensions");
		lblKabasuji.setBounds(50, 90, 900, 90);
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 60));
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.setBounds(425, 500, 100, 50);
		btnNewButton.setBackground(Color.cyan);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		
		//TODO : Add logic to go to the right level
		btnNewButton.addMouseListener(new SelectDimensionsBuilderController(builder, app, 1));
		
		JButton btnNewButton1 = new JButton("Main Menu");
		btnNewButton1.setBounds(425, 700, 100, 50);
		btnNewButton1.setBackground(Color.orange);
		btnNewButton1.setForeground(Color.BLACK);
		btnNewButton1.setContentAreaFilled(false);
		btnNewButton1.setOpaque(true);
		
		JLabel height = new JLabel("Height");
		height.setBounds(300, 218, 100, 50);
		height.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel width = new JLabel("Width");
		width.setBounds(300, 318, 100, 50);
		width.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		textField = new JTextField();
		textField.setBounds(425, 218, 100, 50);
		add(textField);
		textField.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(425, 318, 100, 50);
		add(textField);
		textField.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		setLayout(null);
		add(lblKabasuji);
		add(btnNewButton);
		add(btnNewButton1);
		add(height);
		add(width);
		
}
}
