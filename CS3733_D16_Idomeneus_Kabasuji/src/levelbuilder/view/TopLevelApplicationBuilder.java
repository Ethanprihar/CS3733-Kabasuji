package levelbuilder.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kabasuji.model.Builder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;

public class TopLevelApplicationBuilder extends JFrame {

	public Builder builder;
	public JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public TopLevelApplicationBuilder(Builder builder) {
		this.builder = builder;
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
		int x1 = (int) (0.8*width);
		int y0 = (int) (0.1*height);
		int y1 = (int) (0.8*height);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x0,y0,x1,y1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		BuilderMainMenu panel = new BuilderMainMenu(builder,TopLevelApplicationBuilder.this);
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

