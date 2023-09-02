import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel {
	public enum Resolution {
		nHD360(640, 360), SVGA600(800, 600), XGA768(1024, 768), WXGA720(1280, 720), WXGA800(1280, 800), SXGA1024(1280, 1024), HD768(1366, 768),
		WXGAp900(1440, 900), HDp900(1600, 900), UXGA1200(1600, 1200), WSXGAp1050(1050, 1680), FHD1080(1920, 1080), WUXGA1200(1920, 1200), QWXGA1152(2048, 1152),
		UWFHD1080(2560, 1080), QHD1440(2560, 1440), WQXGA1600(2560, 1600), UWQHD1440(3440, 1440), UHD4K2160(3840, 2160);

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
		window = new JFrame();
		window.getContentPane().add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(resolution.x, resolution.y);
		window.setLocationRelativeTo(relativeComponent);
		window.setVisible(true);
	}
}