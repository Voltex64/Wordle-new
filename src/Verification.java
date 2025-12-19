// Just like the real game, there are certain things the player cannot input, and this method is used to make sure those rules are followed
public class Verification extends UI {
    static String feedback = "";

    // Changes text output to a specific color by using ANSI color codes, used to signify a letters status in the players guess
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String reset = "\u001B[0m"; //resets color
    public static boolean checkValidity() {
        try //First Checks to see if the player entered a number instead of a word
        {
            int x = Integer.parseInt(guessedWord);
            feedback = "Error, non letter characters detected.";
            return false;

        } catch (NumberFormatException e) {
            if (guessedWord.contains(" ")) {
                feedback = "No spaces";
                return false;
            }
            if (guessedWord.length() < 5) {
                feedback = "Not enough letters";
                return false;
            }
            if (guessedWord.length() > 5) {
                feedback = "Too many letters";
                return false;
            }
            if (!wordList.contains(guessedWord.toUpperCase())) {
                feedback = "Not in word list";
                return false;
            }
            if (!guessList.isEmpty() && guessList.contains(guessedWord.toUpperCase())) {
                feedback = "Already guessed";
                return false;
            }
        }
        return true;
    }

    public static String checkAndPaintGuess() {
        char[] brokenGuess = (guessedWord.toUpperCase()).toCharArray();
        char[] brokenAns = wordAns.toCharArray();
        String returnedWord = "";

        for (int x = 0; x <= 4; x++) {
            if (brokenGuess[x] == brokenAns[x])
                returnedWord = returnedWord + green + brokenGuess[x] + reset;// changes letter to green meaning then letter is correct and in the right spot
            else if (wordAns.indexOf(brokenGuess[x]) != -1)
                returnedWord = returnedWord + yellow + brokenGuess[x] + reset;// changes letter to yellow meaning then letter is correct but in the wrong spot
            else
                returnedWord = returnedWord + brokenGuess[x] + reset;
            ;// no color applied means the letter is not in the word
        }

        return returnedWord;
    }

    public static String returnFeedback() {
        return feedback;
    }
}
