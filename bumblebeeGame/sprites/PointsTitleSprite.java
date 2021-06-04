import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PointsTitleSprite implements DisplayableSprite{
	
	private Image image = null;
	private double centerX = AnimationFrame.SCREEN_WIDTH / 2 - 150;
	private double centerY = AnimationFrame.SCREEN_HEIGHT / -2 + 40;
	
	public PointsTitleSprite() {

		try {				
			image = ImageIO.read(new File("res/titles/points.png"));
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}	
		
	}


	public Image getImage() {
		return image;
	}

	public boolean getVisible() {
		return true;
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
		return image.getHeight(null) / 8;
	}

	public double getWidth() {
		return image.getWidth(null) / 8;
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