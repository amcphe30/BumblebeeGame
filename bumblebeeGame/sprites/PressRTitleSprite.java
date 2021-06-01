import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PressRTitleSprite implements DisplayableSprite{
	
	private Image image = null;
	private double centerX;
	private double centerY;
	private static boolean visible = false;
	
	public PressRTitleSprite(double centerX, double centerY) {
		
		this.centerX = centerX;
		this.centerY = centerY;

		try {				
			image = ImageIO.read(new File("res/titles/press_r.png"));
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}	
		
	}


	public Image getImage() {
		return image;
	}

	public boolean getVisible() {
		return visible;
	}
	
	public static void setVisible(boolean b) {
		visible = b;
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