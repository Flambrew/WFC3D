package src.engine;

import src.data.Resolution;
import src.structs.Camera;
import src.structs.Scene;

public abstract class Engine extends Thread {
	private long nanosPerFrame, prevFrameNanos, firstFrameNanos;

	public final Window window;
	public final Input input;

	public Engine(final int framesPerSecond, final Resolution resolution) {
		this.nanosPerFrame = 1000_000_000 / framesPerSecond;
		this.window = new Window(resolution, input = new Input());
		input.setWindow(window);

		start();
	}

	public final void run() {
		init();
		firstFrameNanos = prevFrameNanos = System.nanoTime();

		while (true) {
			if (System.nanoTime() - prevFrameNanos > nanosPerFrame) {
				fixedUpdate();
				prevFrameNanos += nanosPerFrame;
				window.input.update();
			}

			frameUpdate();
			window.repaint();
		}
	}

	public final long lifetimeMillis() {
		return (prevFrameNanos - firstFrameNanos) / 1000_000;
	}

	public final Scene setScene(final Scene scene) {
		return window.currentScene = scene;
	}

	public final Camera setCamera(final Camera camera) {
		return window.camera = camera;
	}

	public abstract void init();

	public abstract void frameUpdate();

	public abstract void fixedUpdate();
}