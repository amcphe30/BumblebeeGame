import java.util.ArrayList;

public class Highscores {
	
	private static ArrayList<String> names = null;
	private static ArrayList<Integer> scores = null;
	private final static int MAXSCORES = 5;
	private static boolean visible = false;
	
	public static void initializeArrays() {
		
		if (names == null) {
			names = new ArrayList<String>();
			scores = new ArrayList<Integer>();
			for (int i = 0; i < MAXSCORES; i++) {
				names.add("");
				scores.add(0);
			}
		}
	}
	
	public static void addNewHighscore(String name, int score) {
		
		initializeArrays();		
		
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
		String name = getName(i);
		name = String.format("%-10s", name);
		String score = String.valueOf(getScore(i));
		score = String.format("%3s", score);
		
		String highscore = name + " " + String.valueOf(score);
		return highscore;
	}
	
	public ArrayList<String> getNames() {
		initializeArrays();
		return names;		
	}
	
	public ArrayList<Integer> getScores() {
		initializeArrays();
		return scores;
	}
	
	public static String getName(int x) {
		initializeArrays();
		return names.get(x);		
	}
	
	public static int getScore(int x) {
		initializeArrays();
		return scores.get(x);
	}
	
	public static void setVisible(boolean b) {
		visible = b;
	}
	
	public static boolean getVisible() {
		return visible;
	}
	
}
