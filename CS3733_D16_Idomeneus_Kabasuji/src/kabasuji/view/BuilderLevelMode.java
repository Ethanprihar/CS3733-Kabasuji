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
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		
		JLabel lblKabasuji = new JLabel("Builder Level Select");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Tahoma", Font.BOLD, 73));
		
		JButton btnNewButton = new JButton("Level 1 ");
		
		JButton btnNewButton_1 = new JButton("Level 2 ");
		
		JButton btnNewButton_2 = new JButton("Level 3 ");
		
		JButton btnNewButton_3 = new JButton("Level 4 ");
		
		JButton btnNewButton_4 = new JButton("Level 5 ");
		
		JButton btnNewButton_5 = new JButton("Level 6 ");
		
		JButton btnNewButton_6 = new JButton("Level 7 ");
		 
		JButton btnNewButton_7 = new JButton("Level 8 ");
		
		JButton btnNewButton_8 = new JButton("Level 9 ");
		
		JButton btnNewButton_9 = new JButton("Level 10");
		
		JButton btnNewButton_10 = new JButton("Level 11");
		
		JButton btnNewButton_11 = new JButton("Level 12");
		
		JButton btnNewButton_12 = new JButton("Level 13");
		
		JButton btnNewButton_13 = new JButton("Level 14");
		
		JButton btnNewButton_14 = new JButton("Level 15");
		
		JButton btnNewButton_15 = new JButton("Forward");
		
		JButton button = new JButton("Back");
		
		JButton btnReturnToTitle = new JButton("Return to Title");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblKabasuji)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addGap(18)
					.addComponent(btnNewButton_3)
					.addGap(18)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(btnNewButton_5)
					.addGap(18)
					.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnNewButton_7, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnNewButton_8)
					.addGap(18)
					.addComponent(btnNewButton_9))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(381)
							.addComponent(btnNewButton_15))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_10)
							.addGap(18)
							.addComponent(btnNewButton_11)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReturnToTitle)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_12)
									.addGap(18)
									.addComponent(btnNewButton_13)
									.addGap(18)
									.addComponent(btnNewButton_14)))))
					.addContainerGap(191, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(lblKabasuji)
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_6)
						.addComponent(btnNewButton_7)
						.addComponent(btnNewButton_8)
						.addComponent(btnNewButton_9))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_10)
						.addComponent(btnNewButton_11)
						.addComponent(btnNewButton_12)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_13)
							.addComponent(btnNewButton_14)))
					.addGap(94)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_15)
						.addComponent(button))
					.addGap(34)
					.addComponent(btnReturnToTitle)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
