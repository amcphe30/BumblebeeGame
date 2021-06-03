import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CloudSprite implements DisplayableSprite{
	
	private Image image = null;
	private double centerX = -500;
	private double centerY = -100;
	
	public CloudSprite(double centerX, double centerY) {

		this.centerX = centerX;
		this.centerY = centerY;
		
		try {				
			image = ImageIO.read(new File("res/clouds.png"));
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
		return centerX - (getWidth());
	}

	public double getMaxX() {
		return centerX + (getWidth());
	}

	public double getMinY() {
		return centerY - (getHeight());
	}

	public double getMaxY() {
		return centerY + (getHeight());
	}

	public double getHeight() {
		return image.getHeight(null);
	}

	public double getWidth() {
		return image.getWidth(null);
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
		
		centerX += 0.5;
		
		if (centerX > 2000) {
			centerX = -500;
		}
		
	}

}