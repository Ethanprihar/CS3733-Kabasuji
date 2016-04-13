package kabasuji.view;

import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.SystemColor;

public class PuzzleLevelPanel extends JPanel {

	/**
	 * Create the bullpen.
	 */
	public PuzzleLevelPanel() {
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		setLayout(null);
		
		JPanel bullpen = new JPanel();
		bullpen.setBounds(0, 0, 1000, 320);
		add(bullpen);
		bullpen.setBackground(Color.gray);
		bullpen.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Flip Horizontally");
		btnNewButton_1.setBounds(830, 11, 150, 50);
		btnNewButton_1.setBackground(Color.orange);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setOpaque(true);
		
		JButton btnNewButton_2 = new JButton("Flip Vertically");
		btnNewButton_2.setBounds(830, 70, 150, 50);
		btnNewButton_2.setBackground(Color.orange);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setOpaque(true);
		
		JButton btnNewButton_3 = new JButton("Turn Clockwise");
		btnNewButton_3.setBounds(830, 200, 150, 50);
		btnNewButton_3.setBackground(Color.orange);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setOpaque(true);
		
		JButton btnNewButton_4 = new JButton("Turn Counter-Clockwise");
		btnNewButton_4.setBounds(830, 260, 150, 50);
		btnNewButton_4.setBackground(Color.orange);
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setOpaque(true);
		
		bullpen.add(btnNewButton_1);
		bullpen.add(btnNewButton_2);
		bullpen.add(btnNewButton_3);
		bullpen.add(btnNewButton_4);
		
	}
}
