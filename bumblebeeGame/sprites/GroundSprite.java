import java.awt.Image; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GroundSprite implements DisplayableSprite, MovableSprite {
	
	private static Image image = null;
	private double centerX = 0;
	private double centerY = 0;
	private double width = 50;
	private double height = 50;
	private boolean visible = true;
	
	public GroundSprite(int minX, int minY, int maxX, int maxY, boolean visible) {
		
		if (image == null) {
			try {
				image = ImageIO.read(new File("res/background-3-1.png.png"));
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		
		this.centerX = (minX + maxX) / 2;
		this.centerY = (minY + maxY) / 2;
		this.width = maxX - minX;
		this.height = maxY - minY;
		this.visible = visible;
		
	}

	
	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}

	
	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}

	
	public void moveX(double pixelsPerSecond) {		
		//unimplemented
	}

	
	public void moveY(double pixelsPerSecond) {		
		//unimplemented
	}

	
	public void stop() {	
		//unimplemented
	}

	
	public Image getImage() {	
		return image;
	}

	public boolean getVisible() {
		return visible;
	}

	public double getMinX() {
		return centerX - (getWidth() / 2);
	}

	public double getMaxX() {
		return centerX + (getWidth() / 2);
	}

	public double getMinY() {
		return centerY - (getHeight() / 2);
	}

	public double getMaxY() {
		return centerY + (getHeight() / 2);
	}

	public double getHeight() {
		height = image.getHeight(null);
		return height;
	}

	public double getWidth() {
		width = image.getWidth(null);
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
