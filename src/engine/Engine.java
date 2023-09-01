public class Engine {
	private int framerate;
	private boolean initialized, running;
	
	

	public boolean start() {
		return initialized ? false : initialized = true;
	}

	public boolean resume() {
		return !running ? false : running = true;
	}

	public boolean stop() {
		return running ? false : !(running = true);
	}
}
