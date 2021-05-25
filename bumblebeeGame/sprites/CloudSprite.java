import java.awt.Image; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CloudSprite implements DisplayableSprite {
	
	private static Image image = null;
	private static Image cloud_a = null;
	private static Image cloud_b = null;
	private double centerX = 0;
	private double centerY = 0;
	private double width = 300;
	private double height = 300;
	private boolean visible = true;
	private int cloud = 1;
	
	public CloudSprite(int cloud, double centerX, double centerY) {
		
		if (image == null) {
			try {
				cloud_a = ImageIO.read(new File("res/cloud-1.png"));
				cloud_b = ImageIO.read(new File("res/cloud-2.png"));
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		
		this.cloud = cloud;
		this.centerX = centerX;
		this.centerY = centerY;
		
	}
	
	public Image getImage() {	
		
		if (cloud == 1) {
			image = cloud_a;
		} else {
			image = cloud_b;
		}
		
		return image;
	}

	public boolean getVisible() {
		return visible;
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
