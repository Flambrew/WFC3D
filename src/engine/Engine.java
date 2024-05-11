public abstract class Engine extends Thread {
	private double millisPerFrame, lastFrameMillis;

	private Window window;

	public Engine(int framesPerSecond) {
		this.millisPerFrame = 1000. / framesPerSecond;
		start();
	}

	public void run() {
		init();
		lastFrameMillis = System.currentTimeMillis();

		while (true) {
			frameupdate();

			if (System.currentTimeMillis() - lastFrameMillis > millisPerFrame) {
				fixedupdate();
				lastFrameMillis += millisPerFrame;
			}

			window.repaint();
		}
	}

	public abstract void init();

	public abstract void frameupdate();

	public abstract void fixedupdate();
}