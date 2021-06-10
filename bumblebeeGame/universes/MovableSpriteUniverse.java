import java.util.ArrayList;

public class MovableSpriteUniverse implements Universe {

	private boolean complete = false;
	private boolean gameOver = false;
	private Background background = null;	
	private DisplayableSprite player1 = null;
	private DisplayableSprite flower = null;
	private DisplayableSprite game_overTitle = null;
	private DisplayableSprite highscoreTitle = null;
	private DisplayableSprite press_rTitle = null;
	private DisplayableSprite start_gameTitle = null;
	private DisplayableSprite pointsTitle = null;
	private DisplayableSprite cloud1 = null;
	private DisplayableSprite cloud2 = null;
	private DisplayableSprite pointsOnes = null;
	private DisplayableSprite pointsTens = null;
	private ArrayList<DisplayableSprite> sprites = new ArrayList<DisplayableSprite>();
	private long elapsedTime = 0;
	private String status = "";

	private final double VELOCITY = 200;	

	//	//require a separate list for sprites to be removed to avoid a concurence exception
	private ArrayList<DisplayableSprite> disposalList = new ArrayList<DisplayableSprite>();


	public MovableSpriteUniverse () {

		try {
			//comment in and run once to reset highscore arrays
			//Highscores.resetHighscores(); Highscores.serializeArrays();
			Highscores.deserializeArrays();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setXCenter(0);
		this.setYCenter(0);
		background = new MappedBackground();
		ArrayList<DisplayableSprite> barriers = ((MappedBackground)background).getBarriers();
		((MappedBackground) background).getBarriers();
		player1 = new BeeSprite();
		flower = new FlowerSprite();
		game_overTitle = new GameOverTitleSprite(-500, -100);
		highscoreTitle = new HighScoreTitleSprite(0, -150);
		press_rTitle = new PressRTitleSprite(0, -100);
		start_gameTitle = new StartGameTitleSprite(-500, -100);
		pointsTitle = new PointsTitleSprite();
		cloud1 = new CloudSprite(-1000, -50);
		cloud2 = new CloudSprite(100, -15);
		pointsOnes = new PointsSprite(1);
		pointsTens = new PointsSprite(10);
		sprites.add(cloud1);
		sprites.add(cloud2);
		sprites.add(player1);
		sprites.add(flower);

		double speed = 1;
		int minPoints = 0;
		for (int i = 0; i < 10; i++) {
			sprites.add(new WaspSprite(speed, minPoints));
			speed += 0.2;
			minPoints += 5;
		}
		
		sprites.add(game_overTitle);
		sprites.add(highscoreTitle);
		sprites.add(press_rTitle);
		sprites.add(start_gameTitle);
		sprites.add(pointsTitle);
		sprites.add(pointsOnes);
		sprites.add(pointsTens);
		sprites.addAll(barriers);

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

		if (keyboard.keyDownOnce(27)) {
			complete = true;
		}

		for (int i = 0; i < sprites.size(); i++) {
			DisplayableSprite sprite = sprites.get(i);
			sprite.update(this, keyboard, actual_delta_time);
		}

	}

	public String toString() {
		return this.status;
	}

}
