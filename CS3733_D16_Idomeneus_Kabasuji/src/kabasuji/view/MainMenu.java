package kabasuji.view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import kabasuji.controller.GoToLevelSelectController;
import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MainMenu extends JPanel {
	Kabasuji kabasuji;
	TopLevelApplication app;

	/**
	 * Create the Main Menu Panel.
	 */

	public MainMenu(Kabasuji kabasuji, TopLevelApplication app) {
		this.kabasuji = kabasuji;
		this.app = app;
		
		JLabelIcon background = new JLabelIcon("KabasujiTitleScreen.png",Screen.width,Screen.height);
		background.setBounds(0, 0, Screen.width, Screen.height);
		add(background);
		
		JLabelIcon levelselectbtn = new JLabelIcon("generalbutton.png",50,50);
		levelselectbtn.setLocation((int)(Screen.width-levelselectbtn.getSize().getWidth())/2,(int)(Screen.height-levelselectbtn.getSize().getHeight())/2);

		JLabel buttonlbl = new JLabel("<html>Select<br> Level</html>", SwingConstants.CENTER);
		buttonlbl.setBounds(0,0,50,50);	
		buttonlbl.setFont(new Font("Onyx", Font.BOLD, 18));

		levelselectbtn.add(buttonlbl);
		levelselectbtn.addMouseListener(new GoToLevelSelectController(kabasuji, app));
		background.add(levelselectbtn);
	}
	
}
