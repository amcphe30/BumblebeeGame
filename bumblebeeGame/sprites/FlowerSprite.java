import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FlowerSprite implements DisplayableSprite {
	
	private static Image[] image = null;
	private final int FRAMES = 8;
	private double centerX;
	private double centerY;
	private double width = 60;
	private double height = 52;
	private boolean visible = true;
	private static boolean pollinated = false;
	private int colour;
	
	public FlowerSprite() {
		
		newFlower();
		
		if (image == null) {
			try {				
				image = new Image[FRAMES];
				for (int i = 0; i < FRAMES; i++) {
					String path = String.format("res/flowers/flower-%d.png", i);
					image[i] = ImageIO.read(new File(path));
				}
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	private void newFlower() {
		centerX = randomInt(AnimationFrame.SCREEN_WIDTH / 2 - 50, AnimationFrame.SCREEN_WIDTH / -2 + 50);
		centerY = randomInt(AnimationFrame.SCREEN_HEIGHT / 2 - 50, AnimationFrame.SCREEN_HEIGHT / -2 + 50);
		colour = randomInt(0, 7);
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

	public Image getImage() {
		return image[colour];
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
		newFlower();
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
