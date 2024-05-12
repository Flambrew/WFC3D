package src.engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	public Window(final Resolution resolution, final Input input) {
		this(resolution, input, null);
	}

	public Window(final Resolution resolution, final Input input, final Component relativeComponent) {
		setBackground(Color.BLACK);
		frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(resolution.x, resolution.y);
		frame.setLocationRelativeTo(relativeComponent);
		frame.addKeyListener(this);
		frame.setVisible(true);

		this.input = input;
		this.resolution = resolution;
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