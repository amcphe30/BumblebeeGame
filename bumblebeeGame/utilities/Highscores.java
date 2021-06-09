import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Highscores {
	
	private static ArrayList<String> names = null;
	private static ArrayList<Integer> scores = null;
	private final static int MAXSCORES = 5;
	private static boolean visible = false;
	
	public static void initializeArrays() {
		
		if (names == null) {
			resetHighscores();
		}
	
	}
	
	public static void resetHighscores() {
		names = new ArrayList<String>();
		scores = new ArrayList<Integer>();
		for (int i = 0; i < MAXSCORES; i++) {
			names.add("-----");
			scores.add(0);
		}
	}
	
	public static void serializeArrays() throws FileNotFoundException, IOException, Exception {

		Serializer.serializeNames(names, "res/names");
		Serializer.serializeScores(scores, "res/scores");
	}
	
	public static void deserializeArrays() throws ClassNotFoundException, IOException, Exception {
		
		initializeArrays();
		names = Serializer.deserializeNames("res/names");
		scores = Serializer.deserializeScores("res/scores");
	}
	
	public static void addNewHighscore(String name, int score) {	
		
		for (int i = 0; i < MAXSCORES; i++) {
			if (scores.get(i) < score) {
				scores.add(i, score);
				scores.remove(MAXSCORES);
				names.add(i, name);
				names.remove(MAXSCORES);
				break;
			}
		}
		
	}
	
	public static String getHighscore(int i) {
		String name = String.format("%-10s", getName(i));
		String score = String.format("%3d", getScore(i));
		
		String highscore = name + " " + score;
		return highscore;
	}
	
	public ArrayList<String> getNames() {
		return names;		
	}
	
	public ArrayList<Integer> getScores() {
		return scores;
	}
	
	public static String getName(int x) {
		return names.get(x);		
	}
	
	public static int getScore(int x) {
		return scores.get(x);
	}
	
	public static void setVisible(boolean b) {
		visible = b;
	}
	
	public static boolean getVisible() {
		return visible;
	}
	
}
