package kabasuji.view;

import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

public class PuzzleBoardPanel extends JPanel {

	/**
	 * Create the bullpen.
	 */
	public PuzzleBoardPanel() {
		setSize(250,250);
		setBackground(SystemColor.textHighlight);
		setBorder(new CompoundBorder());
		setBackground(Color.WHITE);
		
		setLayout(null);
		
		JPanel board = new JPanel();
		board.setBackground(Color.cyan);
		board.setBounds(155, 74, 250, 250);
		add(board);
		
		for (int i = 0; i < 10; i++){
			ImageIcon image = new ImageIcon("src\\images\\tile.PNG");
			JLabel starlabel = new JLabel("", image, JLabel.CENTER);
			starlabel.setBounds(i*50, i*50, i*50, i*50);
			board.add(starlabel);
		}
	}
}
