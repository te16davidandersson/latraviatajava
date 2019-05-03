import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fält
 */
public class LatraviataGUI {
    private JTextArea question;
    private JButton choice1;
    private JButton choice2;
    private JTextPane title;
    private JButton startover;
    private JPanel latraviataJPanel;
    private JTextPane currency;

    private Dbconnector db;
    private int currentStory;

    /**
     * Kör programmet
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("La traviata");
        LatraviataGUI lGUI = new LatraviataGUI();
        frame.setContentPane(lGUI.latraviataJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(500, 400));
        lGUI.question.setText(lGUI.db.getStory(4));
        lGUI.updateButtons();
        frame.setVisible(true);
    }

    /**
     * Bestämmer vad knapparna ska visa för text
     * Kör updatebuttons() metoden när knapparna nedtrycks
     */
    public LatraviataGUI() {
        this.currentStory = 4;
        this.db = new Dbconnector();
        choice1.addActionListener(e -> updateButtons());
        choice2.addActionListener(e -> updateButtons());
        choice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO SELECT target FROM storylinks WHERE storyid = this.currentStory AND id = this.currentStory * 2
                updateButtons();
            }
        });
    }

    /**
     *
     * första elementet av arrayen är vänstra knappen och andra är högra knappen
     */
    public void updateButtons() {
        String[] buttonTexts = db.getButtonTexts(currentStory);

        choice1.setText(buttonTexts[0]);
        choice2.setText(buttonTexts[1]);
    }
}


//TODO ändra nuvarande storyid när du trycker på knappen. Uppdatera texten när knappen trycks