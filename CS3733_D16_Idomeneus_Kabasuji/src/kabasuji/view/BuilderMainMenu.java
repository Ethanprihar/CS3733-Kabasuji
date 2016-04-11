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
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		
		JLabel lblKabasuji = new JLabel("Kabasuji Builder");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 73));
		
		JLabel lblNewLabel = new JLabel("Odell Dotson");
		
		JLabel label = new JLabel("Ethan Prihar");
		
		JLabel label_1 = new JLabel("Vishal Rathi");
		
		JLabel label_2 = new JLabel("Breanne Happell");
		
		JLabel label_3 = new JLabel("yu-Sen Wu");
		
		JButton btnNewButton = new JButton("Build Level");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Idomeneus");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		
		JButton btnNewButton_1 = new JButton("Load Level");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(lblKabasuji))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(281)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(label)
								.addComponent(label_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(273)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(286)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(181)
							.addComponent(btnNewButton)
							.addGap(120)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(194)
							.addComponent(lblNewLabel_1)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblKabasuji)
					.addGap(18)
					.addComponent(lblNewLabel_1)
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
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
