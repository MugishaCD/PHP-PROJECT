import java.awt.*;
import java.awt.event.*;

public class MULTI24RP05321 extends Frame {
    private TextField numberField;
    private TextArea resultArea;
    private Button displayButton;

    public MULTI24RP05321() {

        super("AWT Practice");
        setLayout(null);
        setBackground(Color.WHITE);
        setSize(600, 400);
        setLocationRelativeTo(null);


        createComponents();


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void createComponents() {
        // Title - AWT Practice


        // Input field (without label)
        numberField = new TextField();
        numberField.setBounds(50, 100, 100, 25);
        numberField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(numberField);

        // Display button below the input with black background and white text
        displayButton = new Button("DISPLAY");
        displayButton.setBounds(50, 140, 80, 30);
        displayButton.setFont(new Font("Arial", Font.BOLD, 12));
        displayButton.setBackground(Color.BLACK);
        displayButton.setForeground(Color.WHITE);
        add(displayButton);

        // Result area label
        Label resultLabel = new Label("Multiplication Table:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setBounds(400, 100, 150, 25);
        add(resultLabel);

        // Result text area - on the right side
        resultArea = new TextArea("", 10, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
        resultArea.setBounds(400, 130, 150, 200);
        resultArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        resultArea.setEditable(false);
        resultArea.setBackground(Color.WHITE);
        add(resultArea);

        // Add action listener to the button
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayMultiplicationTable();
            }
        });

        // Add Enter key support
        numberField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    displayMultiplicationTable();
                }
            }
        });
    }

    private void displayMultiplicationTable() {
        String inputText = numberField.getText().trim();

        if (inputText.isEmpty()) {
            resultArea.setText("Please enter a number!");
            return;
        }

        try {
            int number = Integer.parseInt(inputText);
            StringBuilder table = new StringBuilder();

            // Create multiplication table
            for (int i = 1; i <= 10; i++) {
                int result = number * i;
                table.append(number).append(" x ").append(i).append(" = ").append(result).append("\n");
            }

            resultArea.setText(table.toString());

        } catch (NumberFormatException e) {
            resultArea.setText("Invalid input!\nPlease enter a\nvalid number.");
        }
    }

    public static void main(String[] args) {
        MULTI24RP05321 app = new MULTI24RP05321();
        app.setVisible(true);
    }
}