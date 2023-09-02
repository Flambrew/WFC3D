public abstract class Engine extends Thread {
	private double millisecondsPerFrame, lastFrameMillis;

	private Window window;

	public Engine(int framesPerSecond) {
		this.millisecondsPerFrame = 1000. / framesPerSecond;
		start();
	}

	public void run() {
		init();
		lastFrameMillis = System.currentTimeMillis();

		while (true) {
			frameupdate();

			if (System.currentTimeMillis() - lastFrameMillis > millisecondsPerFrame) {
				fixedupdate();
				lastFrameMillis += millisecondsPerFrame;
			}

			window.repaint();
		}
	}

	public abstract void init();

	public abstract void frameupdate();

	public abstract void fixedupdate();
}