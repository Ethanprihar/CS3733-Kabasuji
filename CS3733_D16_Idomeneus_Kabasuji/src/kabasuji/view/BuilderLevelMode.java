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

public class BuilderLevelMode extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuilderLevelMode() {
		setSize(1000,800);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		JLabel lblKabasuji = new JLabel("Builder Level Mode");
		lblKabasuji.setBounds(125, 90, 750, 90);
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 73));
		
		JButton btnNewButton = new JButton("Puzzle");
		btnNewButton.setBounds(425, 300, 100, 50);
		btnNewButton.setBackground(Color.cyan);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		
		JButton btnNewButton1 = new JButton("Lightning");
		btnNewButton1.setBounds(425, 400, 100, 50);
		btnNewButton1.setBackground(Color.orange);
		btnNewButton1.setForeground(Color.BLACK);
		btnNewButton1.setContentAreaFilled(false);
		btnNewButton1.setOpaque(true);
		
		JButton btnNewButton2 = new JButton("Release");
		btnNewButton2.setBounds(425, 500, 100, 50);
		btnNewButton2.setBackground(Color.green);
		btnNewButton2.setForeground(Color.BLACK);
		btnNewButton2.setContentAreaFilled(false);
		btnNewButton2.setOpaque(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		setLayout(null);
		add(lblKabasuji);
		add(btnNewButton);
		add(btnNewButton1);
		add(btnNewButton2);
	}
}
