import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background0 implements Background {

    private Image image;
    private int backgroundWidth = AnimationFrame.SCREEN_WIDTH;
    private int backgroundHeight = AnimationFrame.SCREEN_HEIGHT;

    public Background0() {
    	try {
    		this.image = ImageIO.read(new File("res/background-3.png.png"));   		
    	}
    	catch (IOException e) {
    		System.out.println(e.toString());
    	}		
    }
	
	public Tile getTile(int col, int row) {
		//row is an index of tiles, with 0 being the at the origin
		//col is an index of tiles, with 0 being the at the origin
		int x = (col * backgroundWidth);
		int y = (row * backgroundHeight);
		Tile newTile = null;
		
		newTile = new Tile(image, x, y, backgroundWidth, backgroundHeight, false);

		return newTile;
	}
	
	public int getCol(int x) {
		//which col is x sitting at?
		int col = 0;
		int output;
		if (backgroundWidth != 0) {
			col = (x / backgroundWidth);
			if (x < 0) {
				output =  col - 1;
			}
			else {
				output = col;
			}
		}
		else {
			output = 0;
		}
		//output = x / backgroundWidth;
		return output;
	}
	
	public int getRow(int y) {
		//which row is y sitting at?
		int row = 0;
		int output;
		
		if (backgroundHeight != 0) {
			row = (y / backgroundHeight);
			if (y < 0) {
				output = row - 1;
			}
			else {
				output = row;
			}
		}
		else {
			output = 0;
		}
		output = -2;
		return output;
		
		
	}
	
}


