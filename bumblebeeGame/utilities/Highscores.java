import java.util.ArrayList;

public class Highscores {
	
	private static String[] names = null;
	private static int[] scores = null;
	
	public static void initializeArrays() {
		
		if (names == null) {
			names = new String[5];
			scores = new int[5];
			for (int i = 0; i < 10; i++) {
				names[i] = "";
				scores[i] = 0;
			}
		}
	}
	
	public static void addNewHighscore(String name, int score) {
		
		initializeArrays();
		
		// not done, fix following to shift out lower scores, easier to do with arraylist?
		// or does the structured length of the array mean regular array is automatically better?
		
		
		for (int i = 0; i < 5; i++) {
			if (scores[i] < score) {
				scores[i] = score;
				names[i] = name;
				break;
		}
		
	}
	
	public String[] getNames() {
		initializeArrays();
		return names;		
	}
	
	public int[] getScores() {
		initializeArrays();
		return scores;
	}
	
	public String getName(int x) {
		initializeArrays();
		return names[x];		
	}
	
	public static int getScore(int x) {
		initializeArrays();
		return scores[x];
	}
	
}
