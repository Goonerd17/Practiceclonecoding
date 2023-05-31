package Drop_the_Beat6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DropTheBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/ExitButtonBasic.png"));
    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/ExitButtonEntered.png"));
    private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
    private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
    private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
    private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
    private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));

    private Image titleImage = new ImageIcon(Main.class.getResource("../images/Beautiful Liar Title Image.png")).getImage();
    private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Beautiful Liar Start Image.png")).getImage();
    private Image background = new ImageIcon(Main.class.getResource("../images/introbackground(Title).jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);
    private JButton leftButton = new JButton(leftButtonBasicImage);
    private JButton rightButton = new JButton(rightButtonBasicImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;

    public DropTheBeat () {
        setUndecorated(true);
        setTitle("Drop the Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        exitButton.setBounds(1245, 0, 40, 35);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music ButtonEnteredMusic = new Music("ButtonEnteredMusic.mp3", false);
                ButtonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music ButtonEnteredMusic = new Music("ButtonPressedMusic.mp3", false);
                ButtonEnteredMusic.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(exitButton);

        startButton.setBounds(800, 200, 400, 160);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music ButtonEnteredMusic = new Music("ButtonEnteredMusic.mp3", false);
                ButtonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music ButtonEnteredMusic = new Music("ButtonPressedMusic.mp3", false);
                ButtonEnteredMusic.start();
                startButton.setVisible(false);
                quitButton.setVisible(false);
                leftButton.setVisible(true);
                rightButton.setVisible(true);
                background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
                isMainScreen = true;
            }
        });
        add(startButton);

        quitButton.setBounds(800, 400, 400, 160);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music ButtonEnteredMusic = new Music("ButtonEnteredMusic.mp3", false);
                ButtonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music ButtonEnteredMusic = new Music("ButtonPressedMusic.mp3", false);
                ButtonEnteredMusic.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(quitButton);

        leftButton.setVisible(false);
        leftButton.setBounds(140, 310, 80, 80);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leftButton.setIcon(leftButtonEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music ButtonEnteredMusic = new Music("ButtonEnteredMusic.mp3", false);
                ButtonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftButtonBasicImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music ButtonEnteredMusic = new Music("ButtonPressedMusic.mp3", false);
                ButtonEnteredMusic.start();
                //왼쪽 버튼 이벤트
            }
        });
        add(leftButton);

        rightButton.setVisible(false);
        rightButton.setBounds(1080, 310, 80, 80);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rightButton.setIcon(rightButtonEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music ButtonEnteredMusic = new Music("ButtonEnteredMusic.mp3", false);
                ButtonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightButtonBasicImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music ButtonEnteredMusic = new Music("ButtonPressedMusic.mp3", false);
                ButtonEnteredMusic.start();
                //오른쪽 버튼 이벤트
            }
        });
        add(rightButton);


        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);



        Music intromusic = new Music("intromusic.mp3", true);
        intromusic.start();

    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        if(isMainScreen) {
            g.drawImage (selectedImage,250, 50, null);
            g.drawImage (titleImage, 350, 60, null);
        }

        paintComponents(g);
        this.repaint();
    }
}