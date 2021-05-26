import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FlowerSprite implements DisplayableSprite, MovableSprite {
	
	//private static final int MAX = 300;
	//private static final int MIN_Y = -300;
	//private static final int MIN_X = 0;
	private static Image image = null;
	private double centerX = randomInt(0, 300);
	private double centerY = randomInt(-300, 200);
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
		return getCenterX() - (width / 2);
	}

	public double getMaxX() {
		return getCenterX() + (width / 2);
	}

	public double getMinY() {
		return getCenterY() - (height / 2);
	}

	public double getMaxY() {
		return getCenterY() + (height / 2);
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
		
		if (checkCollision(universe, "Player1") == true) {
			BeeSprite.addPoint();
			pollinated = true;
			getNextFlower();
		}
	}

	public static void setPollination(boolean x) {
		pollinated = x;
		if (pollinated == true) {
			pollinated = false;
		}		
	}
	
	public void getNextFlower() {
		centerX = randomInt(0, 300);
		centerY = randomInt(-300, 300);
		pollinated = false;
	}
	
public boolean checkCollision(Universe sprites, String instance) {
		
		boolean colliding = false;
		
		for (DisplayableSprite sprite : sprites.getSprites()) {

			if (instance == "Player1") {
				if (sprite instanceof BeeSprite) {
					if (CollisionDetection.overlaps(this.getMinX(), this.getMinY(), 
							this.getMaxX(), this.getMaxY(), 
							sprite.getMinX(),sprite.getMinY(), 
							sprite.getMaxX(), sprite.getMaxY()) && getPollination() == false) {
						colliding = true;
						break;					
					}
				}
			}	
		}
		return colliding;		
	}

}
