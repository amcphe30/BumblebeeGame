import java.awt.Image;

public class MessageTest implements DisplayableSprite, MovableSprite {
	
	private double centerX = 0;
	private double centerY = 0;
	private double height = 50;
	private double width = 50;

	public MessageTest() {
		String message = "Hello World!";
		PrintMessage.printMessage(message, 0, 0, 0);
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;		
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;		
	}

	public void moveX(double pixelsPerSecond) {
		// unimplemented		
	}

	public void moveY(double pixelsPerSecond) {
		// unimplemented		
	}

	public void stop() {
		// unimplemented		
	}

	public Image getImage() {
		return null;
	}

	public boolean getVisible() {
		return true;
	}

	public double getMinX() {
		return centerX - (width / 2);
	}

	public double getMaxX() {
		return centerX + (width / 2);
	}

	public double getMinY() {
		return centerY - (width / 2);
	}

	public double getMaxY() {
		return centerY + (width / 2);
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public double getCenterX() {
		return centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public boolean getDispose() {
		return false;
	}

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		
	}

}
