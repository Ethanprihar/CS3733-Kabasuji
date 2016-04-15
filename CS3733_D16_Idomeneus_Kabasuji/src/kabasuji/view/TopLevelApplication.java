package kabasuji.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kabasuji.model.Kabasuji;
import kabasuji.model.Screen;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;

public class TopLevelApplication extends JFrame {

	public Kabasuji kabasuji;
	public JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public TopLevelApplication(Kabasuji kabasuji) {
		this.kabasuji = kabasuji;
		init();
	}
	
	public JPanel getContentPane(){
		return contentPane;
	}
	public void changeContentPane(JPanel j){
		contentPane.removeAll();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(j, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(j, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		contentPane.repaint();
	}
	void init(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		int x0 = (int) (0.1*width);
		int y0 = (int) (0.1*height);
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x0,y0,Screen.width,Screen.height);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, Screen.width, Screen.height);
		setContentPane(contentPane);
		
		MainMenu panel = new MainMenu(kabasuji,TopLevelApplication.this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}

