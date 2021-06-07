import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PointsSprite implements DisplayableSprite{
	
	private Image[] image = null;
	private final int FRAMES = 10;
	private int place;
	private double centerX;
	private double centerY;
	private double width = 24;
	private double height = 32;
	
	public PointsSprite(int place) {

		this.place = place;
		if (place == 1) {
			//centerX = AnimationFrame.SCREEN_WIDTH / 2 - 40;
			//centerY = AnimationFrame.SCREEN_WIDTH / 2 - 40;
			centerX = 0;
			centerY = 0;
		} else if (place == 10) {
			//centerX = AnimationFrame.SCREEN_WIDTH / 2 - 40;
			//centerY = AnimationFrame.SCREEN_WIDTH / 2 - 80;
			centerX = 0;
			centerY = 0;
		}
		
		if (image == null) {
			try {				
				image = new Image[FRAMES];
				for (int i = 0; i < FRAMES; i++) {
					String path = String.format("res/digits/digit-%d.png", i);
					image[i] = ImageIO.read(new File(path));
				}
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}	
		}	
		
	}


	public Image getImage() {
		return image[getValue()];
	}

	public boolean getVisible() {
		return true;
	}
	
	public int getValue() {
		int value = 0;
		int points = BeeSprite.getPoints();
		
		if (place == 1) {
			value = points % 10;
		} else if (place == 10) {
			value = (points - (points % 10)) / 10;
		}
		
		return value;
		
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