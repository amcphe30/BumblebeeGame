import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TitleSprite implements DisplayableSprite{
	
	private Image image = null;
	private double centerX;
	private double centerY;
	private double width;
	private double height;
	private boolean visible;
	
	public TitleSprite(String filename, double centerX, double centerY, double width, double height) {
		
		this.centerX = centerX;
		this.centerY = centerY;
		this.width = width;
		this.height = height;

		try {				
			String path = String.format("res/titles/%s.png", filename);
			image = ImageIO.read(new File(path));
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
	
	public void setVisible(boolean visible) {
		this.visible = visible;
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

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		
	}

}
