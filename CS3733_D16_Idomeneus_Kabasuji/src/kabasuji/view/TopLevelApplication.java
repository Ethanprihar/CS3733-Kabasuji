package kabasuji.view;

import java.awt.AlphaComposite;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class TopLevelApplication extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopLevelApplication frame = new TopLevelApplication();
					final SplashScreen splash = SplashScreen.getSplashScreen();
					if (splash == null) {
						System.out.println("SplashScreen.getSplashScreen() returned null");
						return;
					}
					Graphics2D g = splash.createGraphics();
					if (g == null) {
						System.out.println("g is null");
						return;
					}
					for (int i = 0; i < 6; i++) {
						renderSplashFrame(g, i);
						splash.update();
						try {
							if (i > 4) {
								Thread.sleep(1700);
							} else {
								Thread.sleep(550);
							}
						} catch (InterruptedException e) {
						}
					}
					splash.close();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static void renderSplashFrame(Graphics2D g, int frame) {
		final String[] names = { "THE COOLEST KIDS", "Odell Dotson", "Breanne Happell", "Ethan Prihar", "Vishal Rathi",
				"Yu-sen Wu" };
		g.setComposite(AlphaComposite.Clear);
		g.fillRect(20, 20, 200, 200);
		g.setPaintMode();
		g.setColor(Color.BLACK);
		g.setFont(Font.decode("Arial-BOLD-18"));
		// need exception catching
		BufferedImage img = null;
		try {
			// maps path to the image file
			String path = System.getProperty("user.dir") + File.separator + "src\\images\\8bitbunny.jpg";
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
		}
		for (int i = 0; i < frame + 1; i++) {
			int plotX = 20;
			int plotY = 30 + 43 * i;
			if (i > 4) {
				plotX = 150;
				g.drawImage(img, 255, 10 + 43 * i, null);
			}
			g.drawString(" " + names[i], plotX, plotY);
		}
	}

	/**
	 * Create the frame.
	 */
	public TopLevelApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE).addComponent(btnNewButton)));

		MainMenu panel = new MainMenu();
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.PINK);
		contentPane.setLayout(gl_contentPane);
	}
}
