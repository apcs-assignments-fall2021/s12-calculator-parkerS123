import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quadratic {
    JFrame frame;
    JPanel formulaPanel, buttonPanel;
    LTPanel aPanel, bPanel, cPanel, answerPanel;
    JButton clearButton, calculateButton;


    public Quadratic() {
        // Set up the frame
        frame = new JFrame("Quadratic Formula");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up and add the panels
        formulaPanel = new JPanel();
        aPanel = new LTPanel("a =", 10);
        bPanel = new LTPanel("b =", 10);
        cPanel = new LTPanel("c =", 10);
        buttonPanel = new JPanel();
        answerPanel = new LTPanel("Answer:", 10);

        frame.add(formulaPanel);
        frame.add(aPanel);
        frame.add(bPanel);
        frame.add(cPanel);
        frame.add(buttonPanel);
        frame.add(answerPanel);

        // Set up individual panels
        // formulaPanel code
        JLabel formulaLabel = new JLabel("ax^2 + bx + c = 0");
        formulaPanel.add(formulaLabel);

        // buttonPanel code
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                aPanel.setText("");
                bPanel.setText("");
                cPanel.setText("");
            }
        });

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Potentially a lot of code here
                // But just add code to call quadForm

                quadForm();
            }
        });

        buttonPanel.add(clearButton);
        buttonPanel.add(calculateButton);

        // pack and show
        frame.pack();
        frame.setVisible(true);
    }

    public void quadForm() {
        Double a = Double.parseDouble(aPanel.getText());
        Double b = Double.parseDouble(bPanel.getText());
        Double c = Double.parseDouble(cPanel.getText());

        Double sqr = Math.sqrt((b * b) - (4 * a * c));
        Double x = sqr - b;
        Double ans = x / (2 * a);

        answerPanel.setText("" + ans);
    }

    public static void main(String[] args) {
        Quadratic q = new Quadratic();
    }
}
