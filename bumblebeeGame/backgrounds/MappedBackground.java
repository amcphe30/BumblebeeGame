
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MappedBackground implements Background {

    protected static int TILE_WIDTH = 63;
    protected static int TILE_HEIGHT = 63;

    private Image pink;
    private Image light_pink;
    private Image orange;
    private Image light_yellow;
    private Image yellow;
    private Image green;
    private Image dark_green;
    private Image dark_blue;
    private Image blue;
    private Image light_blue;
    private int maxCols = 0;
    private int maxRows = 0;    

	private int map[][] = new int[][] { 
		{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
		{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
		{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
		{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
		{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
		{8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
		{8,8,7,7,7,7,7,8,8,8,8,8,8,8,8,8},
		{7,7,7,6,6,7,7,7,7,7,8,8,7,7,7,7},
		{7,6,6,6,6,6,6,7,7,7,7,6,6,6,6,7},
		{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
		{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
		{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
	};
    
    public MappedBackground() {
    	try {
    		this.pink = ImageIO.read(new File("res/tiles/pink_tile.png"));
    		this.light_pink = ImageIO.read(new File("res/tiles/light_pink_tile.png"));
    		this.orange = ImageIO.read(new File("res/tiles/orange_tile.png"));
    		this.light_yellow = ImageIO.read(new File("res/tiles/light_yellow_tile.png"));  
    		this.yellow = ImageIO.read(new File("res/tiles/yellow_tile.png"));
    		this.green = ImageIO.read(new File("res/tiles/green_tile.png"));
    		this.dark_green = ImageIO.read(new File("res/tiles/dark_green_tile.png"));
    		this.dark_blue = ImageIO.read(new File("res/tiles/dark_blue_tile.png"));
    		this.blue = ImageIO.read(new File("res/tiles/blue_tile.png"));
    		this.light_blue = ImageIO.read(new File("res/tiles/light_blue_tile.png"));
    	}
    	catch (IOException e) {
    		System.out.println(e.toString());
    	}
    	maxRows = map.length - 1;
    	maxCols = map[0].length - 1;
    }
	
	public Tile getTile(int col, int row) {
		
		Image image = null;
		
		if (row < 0 || row > maxRows || col < 0 || col > maxCols) {
			image = null;
		}
		else if (map[row][col] == 0) {
			image = pink;
		}
		else if (map[row][col] == 1) {
			image = light_pink;
		}
		else if (map[row][col] == 2) {
			image = orange;
		}
		else if (map[row][col] == 3) {
			image = light_yellow;			
		} 
		else if (map[row][col] == 4) {
			image = yellow;		
		} 
		else if (map[row][col] == 5) {
			image = green;		
		} 
		else if (map[row][col] == 6) {
			image = dark_green;		
		} 
		else if (map[row][col] == 7) {
			image = dark_blue;		
		} 
		else if (map[row][col] == 8) {
			image = blue;		
		} 
		else if (map[row][col] == 9) {
			image = light_blue;		
		} 
		else {
			image = null;
		}
			
		int x = (col * TILE_WIDTH) - (AnimationFrame.SCREEN_WIDTH / 2);
		int y = (row * TILE_HEIGHT) - (AnimationFrame.SCREEN_HEIGHT / 2);
		
		Tile newTile = new Tile(image, x, y, TILE_WIDTH, TILE_HEIGHT, false);
		
		return newTile;
	}
	
	public int getHorizontal(int x) {
		//which tile is x sitting at?
		return 0;
	}

	public int getCol(int x) {
		//which col is x sitting at?
		int col = 0;
		if (TILE_WIDTH != 0) {
			col = (x / TILE_WIDTH);
			if (x < 0) {
				return col - 1;
			}
			else {
				return col;
			}
		}
		else {
			return 0;
		}
	}
	
	public int getRow(int y) {
		//which row is y sitting at?
		int row = 0;
		
		if (TILE_HEIGHT != 0) {
			row = (y / TILE_HEIGHT);
			if (y < 0) {
				return row - 1;
			}
			else {
				return row;
			}
		}
		else {
			return 0;
		}
	}
	
	/*public ArrayList<DisplayableSprite> getBarriers() {
		ArrayList<DisplayableSprite> barriers = new ArrayList<DisplayableSprite>();
		for (int row = 0; row < map[0].length; row++) {
			for (int col = 0; col < map.length; col++) {
				if (map[col][row] == 0) {
					barriers.add(new BarrierSprite((row * TILE_WIDTH) - (AnimationFrame.SCREEN_WIDTH / 2), (col * TILE_HEIGHT) - (AnimationFrame.SCREEN_HEIGHT / 2), ((row + 1) * TILE_WIDTH) - (AnimationFrame.SCREEN_WIDTH / 2), ((col + 1) * TILE_HEIGHT) - (AnimationFrame.SCREEN_HEIGHT / 2), false));
				}
			}
		}
		return barriers;
	}*/
	
}
