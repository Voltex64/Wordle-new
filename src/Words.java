import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Words  {
    public static ArrayList<String> wordList = new ArrayList<>();
    public static String wordAns;

    public static void makeList() {
        try {
            File masterList = new File("words.txt");
            Scanner myReader = new Scanner(masterList);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                wordList.add(data.toUpperCase());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        pickWord();
    }

    public static void pickWord() // Picks a random word out of the entire 'words.txt' file to be used as the answer
    {
        Random gen = new Random();
        int n = gen.nextInt(2514);
        wordAns = wordList.get(n);
    }

    public static String getWordAns() {
        return wordAns;
    }

    public static ArrayList<String> getWordList() {
        return wordList;
    }
}
