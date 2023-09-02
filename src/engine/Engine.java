public abstract class Engine extends Thread {
	private int framesPerSecond, currentFrame;
	private double millisecondsPerFrame, lastFrameMillis;

	public Engine(int framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
		this.millisecondsPerFrame = 1000. / framesPerSecond;
	}

	public void run() {
		lastFrameMillis = System.currentTimeMillis();
		init();

		while (true) {
			frameupdate();

			if (System.currentTimeMillis() - lastFrameMillis > millisecondsPerFrame) {
				lastFrameMillis += millisecondsPerFrame;
				currentFrame += 1;

				fixedupdate();
			}
		}
	}

	public abstract void init();

	public abstract void frameupdate();

	public abstract void fixedupdate();
}