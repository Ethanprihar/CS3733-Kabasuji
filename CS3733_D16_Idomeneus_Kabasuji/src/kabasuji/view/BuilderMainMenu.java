package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
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

public class BuilderMainMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuilderMainMenu() {
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		JLabel lblKabasuji = new JLabel("Builder");
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
		
		JButton btnNewButton1 = new JButton("Load Level");
		btnNewButton1.setBounds(425, 700, 100, 50);
		btnNewButton1.setBackground(Color.cyan);
		btnNewButton1.setForeground(Color.BLACK);
		btnNewButton1.setContentAreaFilled(false);
		btnNewButton1.setOpaque(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		setLayout(null);
		add(lblNewLabel);
		add(label);
		add(label_1);
		add(label_2);
		add(label_3);
		add(lblKabasuji);
		add(btnNewButton);
		add(btnNewButton1);

	}
}
