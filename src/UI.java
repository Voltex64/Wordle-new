import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UI extends JFrame {
    private JTextField inputTextField;
    private JButton enterButton;
    private JTextArea wordTextArea;
    private JTextField feedbackTextField;
    private JPanel wordlePanel;
    private JLabel wordleLabel;

    static String wordAns;
    static ArrayList<String> wordList;

    static ArrayList<String> guessList = new ArrayList<>();


    static String guessedWord;

    UI() {
        this.setContentPane(wordlePanel);
        this.setTitle("Wordle");
        this.setBounds(600, 200, 342, 300);
        this.setVisible(true);
        setUpEnterButton();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
       Words.makeList();
       wordList= Words.getWordList();
       wordAns= Words.getWordAns();
       setLookAndFeel();
        UI ui = new UI();
    }

    void setUpEnterButton() {
        this.enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessedWord = inputTextField.getText();
                if (Verification.checkValidity()) {
                    guessList.add(guessedWord.toUpperCase());
                    wordTextArea.append(Verification.checkAndPaintGuess() + "\n");
                } else {
                    feedbackTextField.setText(Verification.returnFeedback());
                }

            }
        });
    }

    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
