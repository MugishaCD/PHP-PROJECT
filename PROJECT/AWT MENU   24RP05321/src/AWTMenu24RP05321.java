import java.awt.*;
import java.awt.event.*;

public class AWTMenu24RP05321 extends Frame implements ActionListener {
    private Panel mainContent;
    private Button pagesBtn, editBtn, helpBtn;
    private PopupMenu pagesMenu;
    private MenuItem loginItem, studentItem;
    private Label headerLabel;

    public AWTMenu24RP05321() {
        setTitle("AWT MENU Practice");
        setSize(600, 400);
        setLayout(null);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Top bar
        Panel topBar = new Panel();
        topBar.setBackground(Color.WHITE);
        topBar.setBounds(0, 30, 600, 40);
        topBar.setLayout(null);
        add(topBar);

        // Window title
        Label titleLabel = new Label("AWT MENU Practice");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(20, 7, 240, 28);
        topBar.add(titleLabel);

        // Fake Close Button
        Button closeBtn = new Button("X");
        closeBtn.setBackground(Color.BLACK);
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setFont(new Font("Arial", Font.BOLD, 20));
        closeBtn.setBounds(525, 7, 45, 28);
        topBar.add(closeBtn);

        // Menu bar
        Panel menuBar = new Panel();
        menuBar.setBackground(new Color(96, 104, 82));
        menuBar.setBounds(0, 70, 600, 35);
        menuBar.setLayout(null);
        add(menuBar);

        // "Pages" menu
        pagesBtn = new Button("Pages");
        pagesBtn.setFont(new Font("Arial", Font.BOLD, 16));
        pagesBtn.setBackground(new Color(96, 104, 82));
        pagesBtn.setForeground(Color.WHITE);
        pagesBtn.setBounds(24, 2, 80, 32);
        pagesBtn.addActionListener(e -> pagesMenu.show(pagesBtn, 0, pagesBtn.getHeight()));
        menuBar.add(pagesBtn);

        // "Edit" menu
        editBtn = new Button("Edit");
        editBtn.setFont(new Font("Arial", Font.BOLD, 16));
        editBtn.setBackground(new Color(96, 104, 82));
        editBtn.setForeground(Color.WHITE);
        editBtn.setBounds(124, 2, 80, 32);
        menuBar.add(editBtn);

        // "Help" menu
        helpBtn = new Button("Help");
        helpBtn.setFont(new Font("Arial", Font.BOLD, 16));
        helpBtn.setBackground(new Color(96, 104, 82));
        helpBtn.setForeground(Color.WHITE);
        helpBtn.setBounds(224, 2, 80, 32);
        menuBar.add(helpBtn);

        // Popup menu for "Pages"
        pagesMenu = new PopupMenu();
        loginItem = new MenuItem("login");
        loginItem.setFont(new Font("Arial", Font.BOLD, 16));
        loginItem.addActionListener(this);
        pagesMenu.add(loginItem);

        studentItem = new MenuItem("student");
        studentItem.setFont(new Font("Arial", Font.BOLD, 16));
        studentItem.addActionListener(this);
        pagesMenu.add(studentItem);

        add(pagesMenu);

        // Blue header below menu
        headerLabel = new Label("SIMPLE JAVA AWT LAYOUT", Label.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBackground(new Color(16, 44, 85));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(0, 105, 600, 45);
        add(headerLabel);

        // Main content panel (for switching login/student)
        mainContent = new Panel();
        mainContent.setLayout(null);
        mainContent.setBounds(50, 150, 500, 190);
        add(mainContent);

        showLoginPage();

        setVisible(true);
    }

    private void showLoginPage() {
        mainContent.removeAll();

        mainContent.setBackground(new Color(222, 228, 224));
        Label loginPageLabel = new Label("LOGIN PAGE");
        loginPageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        loginPageLabel.setBounds(194, 15, 130, 28);
        mainContent.add(loginPageLabel);

        // Username
        Label userLabel = new Label("Username");
        userLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userLabel.setBounds(110, 65, 80, 20);
        mainContent.add(userLabel);

        TextField usernameField = new TextField();
        usernameField.setBounds(210, 65, 120, 25);
        mainContent.add(usernameField);

        // Password
        Label passLabel = new Label("Password");
        passLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passLabel.setBounds(110, 100, 80, 20);
        mainContent.add(passLabel);

        TextField passwordField = new TextField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(210, 100, 120, 25);
        mainContent.add(passwordField);

        // Login button
        Button loginButton = new Button("LOGIN");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBackground(new Color(16, 44, 85));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(210, 135, 120, 32);
        mainContent.add(loginButton);

        mainContent.repaint();
    }

    private void showStudentPage() {
        mainContent.removeAll();
        mainContent.setBackground(new Color(222, 228, 224));
        Label studentLabel = new Label("STUDENT PAGE");
        studentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        studentLabel.setBounds(175, 80, 160, 28);
        mainContent.add(studentLabel);
        mainContent.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginItem) {
            showLoginPage();
        } else if (e.getSource() == studentItem) {
            showStudentPage();
        }
    }

    public static void main(String[] args) {
        new AWTMenu24RP05321();
    }
}
