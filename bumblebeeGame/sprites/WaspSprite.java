import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WaspSprite implements DisplayableSprite, MovableSprite {

	private static final int FRAMES = 9;
	private double speed = 1.5;
	private static int framesPerSecond = 20;
	private static int millisecondsPerFrame = 1000 / framesPerSecond;
	private static Image[] imageLeft = null;
	private static Image[] imageRight = null;
	private long elapsedTime = 0;
	private double centerX = -400;
	private double centerY = -450;
	private int randNum = randomInt(10, 0);
	private double deltaX = speed;
	private double deltaY = speed;
	private double height = 75;
	private double width = 75;
	private int direction = 2; //1 = left; 2 = right
	private static double playerX = 0;
	private static double playerY = 0;
	
	public WaspSprite(double speed) {
		super();
		this.speed = speed;
		
		if (imageLeft == null) {
			try {				
				imageLeft = new Image[FRAMES];
				for (int i = 0; i < FRAMES; i++) {
					String path = String.format("res/hornet/wasp_left-%d.png", i);
					imageLeft[i] = ImageIO.read(new File(path));
				}
				imageRight = new Image[FRAMES];
				for (int i = 0; i < FRAMES; i++) {
					String path = String.format("res/hornet/wasp_right-%d.png", i);
					imageRight[i] = ImageIO.read(new File(path));
				}
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}	
		}
		
	}
	
	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}

	public void moveX(double pixelsPerSecond) {
		//velocityX += pixelsPerSecond;
	}

	public void moveY(double pixelsPerSecond) {
		//velocityY += pixelsPerSecond;
	}

	public void stop() {
		
	}

	public Image getImage() {
		Image output = null;
		long frame = elapsedTime / millisecondsPerFrame;
		int index = (int) frame % FRAMES;
				
		if (deltaX < 0) {
			this.direction = 1;
		} else if (deltaX > 0) {
			this.direction = 2;
		}
		
		if (direction == 1) {
			output = imageLeft[index];
		} else if (direction == 2) {
			output = imageRight[index];
		} 
		
		return output;
		
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
	
	public static void setPlayerX(double x) {
		playerX = x;
	}
	
	public static void setPlayerY(double y) {
		playerY = y;
	}
	
	public static int randomInt(int min, int max) {
		int randomNum = min + (int)(Math.random() * ((max - min) + 1));
		return randomNum;
	}
	
	public boolean isAngry() {
		int points = BeeSprite.getPoints();
		boolean angry = false;
		if (points > 0) {
			angry = true;
		}
		
		return angry;
	}


	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		
		elapsedTime += actual_delta_time;
		
		double targetX;
		double targetY;
		
		if (BeeSprite.gameOver == true) {
			targetX = -600;
			targetY = -600;
		} else {
			targetX = playerX;
			targetY = playerY;
		}
				
		if (elapsedTime % randNum == 0)	 {
			if (centerX < targetX) {
				deltaX = speed;
			} else {
				deltaX = -speed;
			}
		
			if (centerY < targetY) {
				deltaY = speed;
			} else {
				deltaY = -speed;
			}
		}
		
		if (isAngry()) {
			centerX += deltaX;
			centerY += deltaY;
		}		

	}

}
