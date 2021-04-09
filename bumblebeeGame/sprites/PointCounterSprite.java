import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PointCounterSprite implements DisplayableSprite, MovableSprite {
	
	private static Image[] image = null;
	private static final int FRAMES = 49;
	private double centerX = 450;
	private double centerY = -330;
	private double width = 50;
	private double height = 50;
	private boolean visible = true;
	
	public PointCounterSprite() {
		
		if (image == null) {
			try {				
				image = new Image[FRAMES];
				for (int i = 0; i < FRAMES; i++) {
					String path = String.format("res/pixel_font/pixel_font-%02d.png", i);
					image[i] = ImageIO.read(new File(path));
				}
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
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
		int points = APMSprite.getPoints();
		if (points > 9) {
			points = 9;
		}
		points += 26; // first 26 is alphabet
		return image[points];
	}

	public boolean getVisible() {
		return visible;
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
