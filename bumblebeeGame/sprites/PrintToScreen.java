import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PrintToScreen implements DisplayableSprite {
	
	private Image image = null;
	private char character = ' ';
	private double centerX = 0;
	private double centerY = 0;
	private double width = 50;
	private double height = 50;
	private boolean visible = false;
	private boolean dispose = false;
	
	public PrintToScreen(char i, double x, double y, double width, double height) {
		
		this.character = i;
		this.centerX = x;
		this.centerY = y;
		this.width = width;
		this.height = height;
			
	}
	
	public Image getImage() {
		
		try {				
			String path = String.format("res/pixel_font/pixel_font-%02d.png", getIndex(character));
			image = ImageIO.read(new File(path));
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
		
		return image;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
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
	
	public void setDispose(boolean dispose) {
		this.dispose = dispose;
	}

	public boolean getDispose() {
		return dispose;
	}

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		
	}
	
	public static char[] createForLoop(String message) {
		char[] letters = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            letters[i] = message.charAt(i);          
        }
        return letters;
	}
	
	public int getIndex(char character) {
		int index;		
		if (character == 'a') {
			index = 0;
		} else if (character == 'b') {
			index = 1;
		} else if (character == 'c') {
			index = 2;
		} else if (character == 'd') {
			index = 3;
		} else if (character == 'e') {
			index = 4;
		} else if (character == 'f') {
			index = 5;
		} else if (character == 'g') {
			index = 6;
		} else if (character == 'h') {
			index = 7;
		} else if (character == 'i') {
			index = 8;
		} else if (character == 'j') {
			index = 9;
		} else if (character == 'k') {
			index = 10;
		} else if (character == 'l') {
			index = 11;
		} else if (character == 'm') {
			index = 12;
		} else if (character == 'n') {
			index = 13;
		} else if (character == 'o') {
			index = 14;
		} else if (character == 'p') {
			index = 15;
		} else if (character == 'q') {
			index = 16;
		} else if (character == 'r') {
			index = 17;
		} else if (character == 's') {
			index = 18;
		} else if (character == 't') {
			index = 19;
		} else if (character == 'u') {
			index = 20;
		} else if (character == 'v') {
			index = 21;
		} else if (character == 'w') {
			index = 22;
		} else if (character == 'x') {
			index = 23;
		} else if (character == 'y') {
			index = 24;
		} else if (character == 'z') {
			index = 25;
		} else if (character == '0') {
			index = 26;
		} else if (character == '1') {
			index = 27;
		} else if (character == '2') {
			index = 28;
		} else if (character == '3') {
			index = 29;
		} else if (character == '4') {
			index = 30;
		} else if (character == '5') {
			index = 31;
		} else if (character == '6') {
			index = 32;
		} else if (character == '7') {
			index = 33;
		} else if (character == '8') {
			index = 34;
		} else if (character == '9') {
			index = 35;
		} else if (character == '!') {
			index = 36;
		} else if (character == '?') {
			index = 37;
		} else if (character == '.') {
			index = 38;
		} else if (character == ',') {
			index = 39;
		} else if (character == ':') {
			index = 40;
		} else if (character == ';') {
			index = 41;
		} else if (character == '(') {
			index = 42;
		} else if (character == ')') {
			index = 43;
		} else if (character == '/') {
			index = 44;
		} else if (character == '_') {
			index = 45;
		} else if (character == '+') {
			index = 46;
		} else if (character == '-') {
			index = 47;
		} else if (character == '=') {
			index = 48;
		} else {
			index = 49;
		}		
		return index;
	}

}
