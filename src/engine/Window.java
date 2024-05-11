import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel {
	public enum Resolution {
		SVGA(800, 600), HD(1280, 720), HDP(1600, 900), FHD(1920, 1080), WFHD(2560, 1080), QHD(2560, 1440), WQHD(3440, 1440), HD4K(3840, 2160);

		private int x, y;

		private Resolution(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int x() { return x; }

		public int y() { return y; }
	}

	private JFrame window;

	public Window(Resolution resolution) { this(resolution, null); }

	public Window(Resolution resolution, Component relativeComponent) {
		setBackground(Color.BLACK);
		window = new JFrame();
		window.getContentPane().add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(resolution.x, resolution.y);
		window.setLocationRelativeTo(relativeComponent);
		window.setVisible(true);
	}
}