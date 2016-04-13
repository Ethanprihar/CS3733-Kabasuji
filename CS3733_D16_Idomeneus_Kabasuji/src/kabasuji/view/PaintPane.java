package kabasuji.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JPanel;

public class PaintPane extends JPanel {

	private Image background;

	public PaintPane(Image image) {
		// This is just an example, I'd prefer to use setters/getters
		// and would also need to provide alignment options ;)
		background = image;
	}

	@Override
	public Dimension getPreferredSize() {
		return background == null ? new Dimension(0, 0)
				: new Dimension(background.getWidth(this), background.getHeight(this));
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		if (background != null) {
			Insets insets = getInsets();

			int width = getWidth() - 1 - (insets.left + insets.right);
			int height = getHeight() - 1 - (insets.top + insets.bottom);

			int x = (width - background.getWidth(this)) / 2;
			int y = (height - background.getHeight(this)) / 2;

			g.drawImage(background, x, y, this);
		}

	}

}