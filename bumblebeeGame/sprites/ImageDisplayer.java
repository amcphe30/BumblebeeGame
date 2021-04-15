import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDisplayer implements DisplayableSprite {
	
	private Image image = null;
	private String filePath = null;
	private double centerX = 0;
	private double centerY = 0;
	private double width = 50;
	private double height = 50;
	
	public ImageDisplayer(String filePath, double x, double y, double width, double height) {
		
		this.filePath = filePath;
		this.centerX = x;
		this.centerY = y;
		this.width = width;
		this.height = height;
			
	}
	
	public Image getImage() {
		
		try {				
			String path = String.format("res/misc/%s.png", filePath);
			image = ImageIO.read(new File(path));
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
		
		return image;
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

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		
	}

}
