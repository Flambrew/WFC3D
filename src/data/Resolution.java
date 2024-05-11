package src.data;

public enum Resolution {
    SVGA(800, 600), HD(1280, 720), HDP(1600, 900), FHD(1920, 1080), WFHD(2560, 1080), QHD(2560, 1440), WQHD(3440, 1440), HD4K(3840, 2160);

    public final int x, y;

    private Resolution(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public double aspectRatio() {
        return (double) y / x;
    }
}