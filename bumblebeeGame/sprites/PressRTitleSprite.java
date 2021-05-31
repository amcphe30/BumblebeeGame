import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PressRTitleSprite implements DisplayableSprite{
	
	private Image image = null;
	private double centerX;
	private double centerY;
	private double width;
	private double height;
	private static boolean visible = false;
	
	public PressRTitleSprite(double centerX, double centerY, double width, double height) {
		
		this.centerX = centerX;
		this.centerY = centerY;
		this.width = width;
		this.height = height;

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
		return image.getHeight(null) / 3;
	}

	public double getWidth() {
		return image.getWidth(null) / 3;
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