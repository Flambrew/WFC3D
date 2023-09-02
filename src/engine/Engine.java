public abstract class Engine extends Thread {
	private double millisecondsPerFrame, lastFrameMillis;

	public Engine(int framesPerSecond) {
		this.millisecondsPerFrame = 1000. / framesPerSecond;
	}

	public void run() {
		lastFrameMillis = System.currentTimeMillis();
		init();

		while (true) {
			frameupdate();

			if (System.currentTimeMillis() - lastFrameMillis > millisecondsPerFrame) {
				lastFrameMillis += millisecondsPerFrame;
				fixedupdate();
			}
		}
	}

	public abstract void init();

	public abstract void frameupdate();

	public abstract void fixedupdate();
}