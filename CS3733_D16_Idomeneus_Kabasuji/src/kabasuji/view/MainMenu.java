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

public class MainMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainMenu() {
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 73));
		
		JLabel lblNewLabel = new JLabel("Odell Dotson");
		
		JLabel label = new JLabel("Ethan Prihar");
		
		JLabel label_1 = new JLabel("Vishal Rathi");
		
		JLabel label_2 = new JLabel("Breanne Happell");
		
		JLabel label_3 = new JLabel("yu-Sen Wu");
		
		JButton btnNewButton = new JButton("Level Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(lblKabasuji))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(216)
							.addComponent(btnNewButton)))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(lblKabasuji)
					.addGap(76)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(label)
					.addGap(18)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(label_2)
					.addGap(18)
					.addComponent(label_3)
					.addGap(71)
					.addComponent(btnNewButton)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
