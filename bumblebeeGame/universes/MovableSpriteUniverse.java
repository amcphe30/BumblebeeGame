import java.util.ArrayList;

public class MovableSpriteUniverse implements Universe {

	private boolean complete = false;
	private boolean gameOver = false;
	private Background background = null;	
	private DisplayableSprite player1 = null;
	private DisplayableSprite wasp = null;
	private DisplayableSprite flower = null;
	private DisplayableSprite cloud_a = null;
	private DisplayableSprite cloud_b = null;
	private DisplayableSprite game_overTitle = null;
	private DisplayableSprite highscoreTitle = null;
	private DisplayableSprite new_highscoreTitle = null;
	private DisplayableSprite press_rTitle = null;
	private DisplayableSprite start_gameTitle = null;
	private ArrayList<DisplayableSprite> sprites = new ArrayList<DisplayableSprite>();
	private long elapsedTime = 0;
	private String status = "";

	private final double VELOCITY = 200;	
	
//	//require a separate list for sprites to be removed to avoid a concurence exception
	private ArrayList<DisplayableSprite> disposalList = new ArrayList<DisplayableSprite>();

	
	public MovableSpriteUniverse () {
	
	this.setXCenter(0);
	this.setYCenter(0);
	background = new MappedBackground();
	player1 = new BeeSprite();
	wasp = new WaspSprite(0, 1.5);
	flower = new FlowerSprite();
	cloud_a = new CloudSprite(1, -200, -100);
	cloud_b = new CloudSprite(2, 300, -150);
	game_overTitle = new GameOverTitleSprite(-325, -150);
	highscoreTitle = new HighScoreTitleSprite(0, 0, 50, 50);
	new_highscoreTitle = new NewHighScoreTitleSprite(0, 0, 50, 50);
	press_rTitle = new PressRTitleSprite( 0, 0, 50, 50);
	start_gameTitle = new StartGameTitleSprite(-325, -100);
	sprites.add(player1);
	sprites.add(wasp);
	sprites.add(flower);
	sprites.add(game_overTitle);
	sprites.add(highscoreTitle);
	sprites.add(new_highscoreTitle);
	sprites.add(press_rTitle);
	sprites.add(start_gameTitle);
	

	}
	
	
	public double getScale() {
		return 1;
	}

	public double getXCenter() {
		return 0;
	}

	public double getYCenter() {
		return 0;
	}
	
	public void setXCenter(double xCenter) {
	}

	public void setYCenter(double yCenter) {
	}
	
	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
	}

	public Background getBackground() {
		return background;
	}

	public DisplayableSprite getPlayer1() {
		return player1;
	}
	
	public DisplayableSprite getWasp() {
		return wasp;
	}
	
	public DisplayableSprite getFlower() {
		return flower;
	}

	public ArrayList<DisplayableSprite> getSprites() {
		return sprites;
	}
		
	public boolean centerOnPlayer() {
		return false;
	}	
	
	public boolean gameOver() {
		return gameOver;
	}

	
	public void update(KeyboardInput keyboard, long actual_delta_time) {

		double velocityX = 0;
		double velocityY = 0;
		
		//LEFT	
		if (keyboard.keyDown(37)) {
			velocityX = -VELOCITY;
		}
		//UP
		if (keyboard.keyDown(38)) {
			velocityY = -VELOCITY;			
		}
		// RIGHT
		if (keyboard.keyDown(39)) {
			velocityX += VELOCITY;
		}
		// DOWN
		if (keyboard.keyDown(40)) {
			velocityY += VELOCITY;			
		}
		// R
		if (keyboard.keyDown(82)) {
			BeeSprite.setRetry(true);
		}
		
		for (int i = 0; i < sprites.size(); i++) {
			DisplayableSprite sprite = sprites.get(i);
			
			if (sprite instanceof MovableSprite) {
				MovableSprite movable = (MovableSprite)sprite;
				movable.moveX(velocityX);
				movable.moveY(velocityY);
			}
			
			sprite.update(this, keyboard, actual_delta_time);
    	}    	

	}
	
	public String toString() {
		return this.status;
	}

}
