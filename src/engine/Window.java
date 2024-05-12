package src.engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import src.data.Resolution;
import src.structs.Camera;
import src.structs.Scene;

public class Window extends JPanel implements KeyListener {
	private final JFrame frame;
	public Scene currentScene;
	public Camera camera;
	public Resolution resolution;
	public Input input;

	public final int padX = 14, padY = 38;

	public Window(final Resolution resolution, final Input input) {
		this(resolution, input, null);
	}

	public Window(final Resolution resolution, final Input input, final Component relativeComponent) {
		this.resolution = resolution;
		this.input = input;

		setBackground(Color.BLACK);
		frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(resolution.x + padX, resolution.y + padY);
		frame.setLocationRelativeTo(relativeComponent);
		frame.addKeyListener(this);
		frame.setVisible(true);

		frame.getContentPane().setCursor(
			Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor"));
	}

	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		if (camera != null && currentScene != null)
			currentScene.paint(g, camera, resolution);
	}

	public void keyTyped(KeyEvent k) {}

	public void keyPressed(KeyEvent k) {
		input.pressed(k);
	}

	public void keyReleased(KeyEvent k) {
		input.released(k);
	}
}