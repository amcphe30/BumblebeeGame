import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializer 
{
	public static void serializeNames(ArrayList<String> names, String fileName) throws FileNotFoundException, IOException, Exception
	{
		ObjectOutputStream ouputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		ouputStream.writeObject(names);
		ouputStream.close();
	}
	
	public static void serializeScores(ArrayList<Integer> scores, String fileName) throws FileNotFoundException, IOException, Exception
	{
		ObjectOutputStream ouputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		ouputStream.writeObject(scores);
		ouputStream.close();
	}
		
	public static ArrayList<String> deserializeNames(String fileName) throws IOException, ClassNotFoundException, Exception
	{	
		ArrayList<String> names = null;
		 FileInputStream inputStream = new FileInputStream(fileName);
		 ObjectInputStream reader = new ObjectInputStream(inputStream);

		 names = (ArrayList<String>) reader.readObject();
		
		return names;
	}
	
	public static ArrayList<Integer> deserializeScores(String fileName) throws IOException, ClassNotFoundException, Exception
	{	
		ArrayList<Integer> scores = null;
		 FileInputStream inputStream = new FileInputStream(fileName);
		 ObjectInputStream reader = new ObjectInputStream(inputStream);

		 scores = (ArrayList<Integer>) reader.readObject();
		
		return scores;
	}
}
