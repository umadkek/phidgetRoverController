package rover;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyFrame extends JFrame implements ActionListener {
    private static final int FRAME_WIDTH = 350;
    private static final int FRAME_HEIGHT = 330;
    private static final String FRAME_TITLE = "Phidgets Rover Controller";
    private static final int BUTTON_WIDTH = 160;
    private static final int BUTTON_HEIGHT = 50;

    private JButton upButton;
    private JButton downButton;
    private JButton leftButton;
    private JButton rightButton;
    private JButton accelerationSubmitButton;
    private JPanel panel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel centerPanel;
    private JPanel accelerationPanel;
    private JTextField accelerationField;
    private JLabel accelerationErrorLabel;

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
                accelerationErrorLabel.setText("Moving Forwards");
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
                accelerationErrorLabel.setText("Stopped");
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
                accelerationErrorLabel.setText("Moving Backwards");
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
                accelerationErrorLabel.setText("Stopped");
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
                accelerationErrorLabel.setText("Turning Left");
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
                accelerationErrorLabel.setText("Stopped");
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
                accelerationErrorLabel.setText("Turning Right");
            } 
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        Rover.stopMoving();
                    } catch (Exception ex) {}
                }
                accelerationErrorLabel.setText("Stopped");
            }
        });
        
        rightPanel.add(rightButton);
    }

    private void createCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());

        accelerationPanel = new JPanel();
        accelerationPanel.setLayout(new BoxLayout(accelerationPanel, BoxLayout.Y_AXIS));

        JLabel accelerationLabel = new JLabel("Acceleration: ");
        accelerationField = new JTextField(10);
        accelerationErrorLabel = new JLabel();

        accelerationField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        Rover.setAcceleration(Integer.parseInt(accelerationField.getText()));
                        accelerationField.setText("");
                        accelerationErrorLabel.setText("");
                    } catch (Exception ex) {
                        accelerationErrorLabel.setText("Invalid acceleration or number too big");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        centerPanel.add(accelerationLabel);
        centerPanel.add(accelerationField);
        centerPanel.add(accelerationErrorLabel);

        accelerationSubmitButton = new JButton("Submit");
        accelerationSubmitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Rover.setAcceleration(Integer.parseInt(accelerationField.getText()));
                    accelerationField.setText("");
                    accelerationErrorLabel.setText("");
                } catch (Exception ex) {
                    accelerationErrorLabel.setText("Invalid acceleration or number too big");
                }
            }
        });
        accelerationSubmitButton.setPreferredSize(new Dimension(75, 26));

        accelerationPanel.add(accelerationSubmitButton);
        centerPanel.add(accelerationPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        Object source = e.getSource();
    }
}
