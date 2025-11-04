import java.awt.*;
import java.awt.event.*;

public class MyShapes24RP05321 extends Frame implements WindowListener, ActionListener {
    Button closeBtn;

    public MyShapes24RP05321() {
        super("MyShapes24RP05321"); // Title concatenated with reg.number
        setSize(500, 350);
        setLayout(null);
        addWindowListener(this);

        // "My shapes" label
        Label lbl = new Label("My shapes");
        lbl.setFont(new Font("SansSerif", Font.BOLD, 20));
        lbl.setBounds(35, 50, 200, 40);
        add(lbl);

        // "Close" button (simulating the X at top-right)
        closeBtn = new Button("X");
        closeBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        closeBtn.setBackground(Color.black);
        closeBtn.setForeground(Color.white);
        closeBtn.setBounds(400, 50, 40, 40);
        closeBtn.addActionListener(this);
        add(closeBtn);
    }

    public void paint(Graphics g) {
        // Draw big smiley face (circle)
        g.setColor(Color.black);
        g.drawOval(150, 120, 200, 200);

        // Draw eyes
        g.fillOval(195, 180, 30, 30); // Left eye
        g.fillOval(270, 180, 30, 30); // Right eye

        // Draw smile
        g.drawArc(200, 230, 100, 50, 0, -180);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeBtn) {
            System.exit(0);
        }
    }

    // WindowListener methods
    public void windowClosing(WindowEvent e) { System.exit(0); }
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        MyShapes24RP05321 win = new MyShapes24RP05321();
        win.setVisible(true);
    }
}
