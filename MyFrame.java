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
        upButton = new JButton("Forward");
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
                try {
                    Rover.moveForward();
                } catch (Exception ex) {}
                speedErrorLabel.setText("Moving Forwards");
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
                speedErrorLabel.setText("Stopped");
            } 
        });

        topPanel.add(upButton);
    }

    private void createBottomPanel() {
        bottomPanel = new JPanel();
        downButton = new JButton("Backward");
        downButton.setFocusable(false);
        downButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        
        downButton.addMouseListener(new MouseListener() {
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
                try {
                    Rover.moveBackward();
                } catch (Exception ex) {}
                speedErrorLabel.setText("Moving Backwards");
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
                speedErrorLabel.setText("Stopped");
            }
        });
        
        bottomPanel.add(downButton);
    }

    public void createLeftPanel() {
        leftPanel = new JPanel();
        leftButton = new JButton("<");
        leftButton.setFocusable(true);
        leftButton.setPreferredSize(new Dimension(BUTTON_HEIGHT, BUTTON_WIDTH)); // swapped to make button appear
                                                                                 // vertical
        leftButton.addMouseListener(new MouseListener() {
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
                try {
                    Rover.moveLeft();
                } catch (Exception ex) {}
                speedErrorLabel.setText("Turning Left");
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
                speedErrorLabel.setText("Stopped");
            }
        });
                                                                                 
        leftPanel.add(leftButton);
    }

    public void createRightPanel() {
        rightPanel = new JPanel();
        rightButton = new JButton(">");
        rightButton.setFocusable(false);
        rightButton.setPreferredSize(new Dimension(BUTTON_HEIGHT, BUTTON_WIDTH));

        rightButton.addMouseListener(new MouseListener() {
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
                try {
                    Rover.moveRight();
                } catch (Exception ex) {}
                speedErrorLabel.setText("Turning Right");
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
                speedErrorLabel.setText("Stopped");
            }
        });
        
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
                        Rover.setSpeed(Integer.parseInt(speedField.getText()));
                        speedField.setText("");
                        speedErrorLabel.setText("");
                    } catch (Exception ex) {
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
                    Rover.setSpeed(Integer.parseInt(speedField.getText()));
                    speedField.setText("");
                    speedErrorLabel.setText("");
                } catch (Exception ex) {
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
    }
}
