import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FlowerSprite implements DisplayableSprite, MovableSprite {
	
	private static final int MAX = 300;
	private static final int MIN = -300;
	private static Image image = null;
	private double centerX = randomInt(MIN, MAX);
	private double centerY = randomInt(MIN, MAX);
	private double width = 80;
	private double height = 80;
	private boolean visible = true;
	private static boolean pollinated = false;
	
	public FlowerSprite() {
		
		if (image == null) {
			try {
				image = ImageIO.read(new File("res/flower_pink-1.png"));
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
	
	public static boolean getPollination() {
		return pollinated;
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
		return centerX - (width / 2);
	}

	public double getMaxX() {
		return centerX + (width / 2);
	}

	public double getMinY() {
		return centerY - (height / 2);
	}

	public double getMaxY() {
		return centerY + (height / 2);
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
	
	public static int randomInt(int min, int max) {
		int randomNum = min + (int)(Math.random() * ((max - min) + 1));
		return randomNum;
	}

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		
	}

	public static void setPollination(boolean x) {
		pollinated = x;
		if (pollinated == true) {
			pollinated = false;
			getNextFlower();
		}		
	}
	
	public static void getNextFlower() {
		centerX = randomInt(MIN, MAX);
		centerY = randomInt(MIN, MAX);
	}

}
