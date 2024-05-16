package rover;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener {
    private static final int FRAME_WIDTH = 350;
    private static final int FRAME_HEIGHT = 330;
    private static final String FRAME_TITLE = "Title";
    private static final int BUTTON_WIDTH = 160;
    private static final int BUTTON_HEIGHT = 50;

    private JButton upButton;
    private JButton downButton;
    private JButton leftButton;
    private JButton rightButton;
    private JButton speedSubmitButton;
    private JPanel panel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel centerPanel;
    private JPanel speedPanel;
    private JTextField speedField;
    private JLabel speedErrorLabel;

    public MyFrame() {
        initUI();
        setVisible(true);
    }

    private void initUI() {
        setTitle(FRAME_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        createTopPanel();
        createBottomPanel();
        createLeftPanel();
        createRightPanel();
        createCenterPanel();

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(rightPanel, BorderLayout.EAST);
        panel.add(centerPanel, BorderLayout.CENTER);

        add(panel);
    }

    private void createTopPanel() {
        topPanel = new JPanel();
        upButton = new JButton("Up");
        upButton.addActionListener(this);
        upButton.setFocusable(false);
        upButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        
        upButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            } 
            @Override
            public void mouseEntered(MouseEvent e) {
                
            } 
            @Override
            public void mouseExited(MouseEvent e) {
                
            } 
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.moveForward();
                    } catch (Exception ex) {}
                }
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
            } 
        });

        topPanel.add(upButton);
    }

    private void createBottomPanel() {
        bottomPanel = new JPanel();
        downButton = new JButton("Down");
        downButton.addActionListener(this);
        downButton.setFocusable(false);
        downButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        bottomPanel.add(downButton);
    }

    public void createLeftPanel() {
        leftPanel = new JPanel();
        leftButton = new JButton("<");
        leftButton.addActionListener(this);
        leftButton.setFocusable(true);
        leftButton.setPreferredSize(new Dimension(BUTTON_HEIGHT, BUTTON_WIDTH)); // swapped to make button appear
                                                                                 // vertical

        leftPanel.add(leftButton);
    }

    public void createRightPanel() {
        rightPanel = new JPanel();
        rightButton = new JButton(">");
        rightButton.addActionListener(this);
        rightButton.setFocusable(false);
        rightButton.setPreferredSize(new Dimension(BUTTON_HEIGHT, BUTTON_WIDTH));

        rightPanel.add(rightButton);
    }

    private void createCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());

        speedPanel = new JPanel();
        speedPanel.setLayout(new BoxLayout(speedPanel, BoxLayout.Y_AXIS));

        JLabel speedLabel = new JLabel("Speed: ");
        speedField = new JTextField(10);
        speedErrorLabel = new JLabel();

        speedField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        int speed = Integer.parseInt(speedField.getText());
                        speedField.setText("");
                        speedErrorLabel.setText("");
                    } catch (NumberFormatException ex) {
                        speedErrorLabel.setText("Invalid speed or speed too big");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        centerPanel.add(speedLabel);
        centerPanel.add(speedField);
        centerPanel.add(speedErrorLabel);

        speedSubmitButton = new JButton("Submit");
        speedSubmitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int speed = Integer.parseInt(speedField.getText());
                    speedField.setText("");
                    speedErrorLabel.setText("");
                } catch (NumberFormatException ex) {
                    speedErrorLabel.setText("Invalid speed or speed too big");
                }
            }
        });
        speedSubmitButton.setPreferredSize(new Dimension(75, 26));

        speedPanel.add(speedSubmitButton);
        centerPanel.add(speedPanel);
    }

    private void validateSpeed() {
        try {
            int speed = Integer.parseInt(speedField.getText());
            speedField.setText("");
        } catch (NumberFormatException ex) {
            speedErrorLabel.setText("Invalid speed");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == upButton) {
            
        } else if (source == downButton) {
            
        } else if (source == leftButton) {
            
        } else if (source == rightButton) {
            
        }
    }
}
