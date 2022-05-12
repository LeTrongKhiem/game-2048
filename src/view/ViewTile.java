package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;

public class ViewTile extends JLabel {
	private static final long serialVersionUID = -971197911043571453L;
	private static Dimension prefSize = new Dimension(117, 117);
	private static Dimension actSize = new Dimension(prefSize.width, prefSize.height);
	private static Font font;

	public ViewTile(int val, Point p) throws IllegalArgumentException {
		super(val == 0 ? "" : String.valueOf(val), CENTER);
		if (p.x < 0 || p.y < 0)
			throw new IllegalArgumentException("Invalid tile location!");
		setLocation(p);
		setOpaque(true);
		setSize(actSize);
		if (font == null)
			font = (new ClearSansLoader()).importFont("Bold");
		setStyle(val); // sets the color and fontsize for this tile based on its value
		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(CENTER_ALIGNMENT);
	}
	public static Dimension getPrefSize() {
		return new Dimension(prefSize.width, prefSize.height);
	}
	public static void setActualWidth(int width) {
		actSize.width = width;
	}


	public static void setActualHeight(int height) {
		actSize.height = height;
	}

	public static int getActualHeight() {
		return actSize.height;
	}

	public static int getActualWidth() {
		return actSize.width;
	}


	public void moveTileBy(int dx, int dy) {
		setLocation(getLocation().x + dx, getLocation().y + dy);
	}

	public void setTileVal(int val) {
		setText(val == 0 ? "" : String.valueOf(val));
		setStyle(val);
	}

	private void setStyle(int val) {
		float scaleF;
		if (actSize.width < actSize.height)
			scaleF = actSize.width / (float) prefSize.width;
		else
			scaleF = actSize.height / (float) prefSize.height;
		switch (val) {
		case 0:
			setBackground(new Color(238, 228, 218, 89));
			setForeground(new Color(119, 110, 101));
			setFont(font.deriveFont(scaleF * 55f));
			break;
		case 2:
			setBackground(new Color(238, 228, 218));
			setForeground(new Color(119, 110, 101));
			setFont(font.deriveFont(scaleF * 55f));
			break;
		case 4:
			setBackground(new Color(237, 224, 200));
			setForeground(new Color(119, 110, 101));
			setFont(font.deriveFont(scaleF * 55f));
			break;
		case 8:
			setBackground(new Color(242, 177, 121));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 55f));
			break;
		case 16:
			setBackground(new Color(245, 149, 99));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 55f));
			break;
		case 32:
			setBackground(new Color(246, 124, 95));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 55f));
			break;
		case 64:
			setBackground(new Color(246, 94, 59));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 55f));
			break;
		case 128:
			setBackground(new Color(237, 207, 114));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 45f));
			break;
		case 256:
			setBackground(new Color(237, 204, 97));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 45f));
			break;
		case 512:
			setBackground(new Color(237, 200, 80));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 45f));
			break;
		case 1024:
			setBackground(new Color(237, 197, 63));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 35f));
			break;
		case 2048:
			setBackground(new Color(237, 194, 46));
			setForeground(new Color(249, 246, 242));
			setFont(font.deriveFont(scaleF * 35f));
			break;
		default:
			setBackground(new Color(60, 58, 50));
			setForeground(new Color(249, 246, 242));
			if (val <= 524288)
				setFont(font.deriveFont(scaleF * 30f));
			else
				setFont(font.deriveFont(scaleF * 15f)); // in case of absurdly large values, shrink text to fit
			break;
		}
	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		CustomPainter.paintComponentRounded(this, g, 3);
//	}
}