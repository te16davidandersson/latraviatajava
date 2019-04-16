import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("La traviata");
        LatraviataGUI lGUI = new LatraviataGUI();
        frame.setContentPane(lGUI.latraviataJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(500, 400));
        lGUI.question.setText(lGUI.db.getStory(5));
        lGUI.updateButtons();
        frame.setVisible(true);
    }

    public LatraviataGUI() {
        this.currentStory = 1;
        this.db = new Dbconnector();
        choice1.addActionListener(e -> updateButtons());
    }

    /*
    första elementet av arrayen är vänstra och andra är högra
     */
    public void updateButtons() {
        String[] buttonTexts = db.getButtonTexts(currentStory);
        choice1.setText(buttonTexts[0]);
        choice2.setText(buttonTexts[1]);
    }
}


//TODO ändra nuvarande storyin när du trycker på knappen. Uppdatera texten när knappen trycks, lägg till actionlistener för choice2. (högerklicka på den i .form)