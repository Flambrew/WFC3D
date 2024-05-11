package src.engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import basic_structs.Scene;
import data.Resolution;

public class Window extends JPanel {
	private final JFrame window;
	public Scene currentScene;

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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		currentScene.paint(g);
	}
}