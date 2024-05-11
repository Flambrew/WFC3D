package engine;

public abstract class Engine extends Thread {
	private long nanosPerFrame, prevFrameNanos, firstFrameNanos;

	private final Window window;

	public Engine(final int framesPerSecond, final Resolution resolution) {
		this.nanosPerFrame = 1000_000_000 / framesPerSecond;
		this.window = new Window(resolution);
		start();
	}

	public void run() {
		init();
		firstFrameNanos = prevFrameNanos = System.nanoTime();

		while (true) {
			if (System.nanoTime() - prevFrameNanos > nanosPerFrame) {
				fixedUpdate();
				prevFrameNanos += nanosPerFrame;
			}

			frameUpdate();
			window.repaint();
		}
	}

	public long lifetimeMillis() {
		return (prevFrameNanos - firstFrameNanos) / 1000_000;
	}

	public Scene setScene(Scene scene) {
		return window.currentScene = scene;
	}

	public abstract void init();

	public abstract void frameUpdate();

	public abstract void fixedUpdate();
}