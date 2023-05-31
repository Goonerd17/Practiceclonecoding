package Drop_the_Beat7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.*;

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


    private Image background = new ImageIcon(Main.class.getResource("../images/introbackground(Title).png")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);
    private JButton leftButton = new JButton(leftButtonBasicImage);
    private JButton rightButton = new JButton(rightButtonBasicImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;

    ArrayList<Track> trackList = new ArrayList<Track>();

    private Image titleImage;
    private Image selectedImage;
    private Music selectedMusic;
    private int nowSelected = 0;

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

        Music intromusic = new Music("intromusic.mp3", true);
        intromusic.start();

        trackList.add(new Track("Beautiful Liar Title Image.png", "Beautiful Liar Start Image.png", "Beautiful Liar Image.png", "Beautiful Liar Selected.mp3", "Beautiful Liar -Markvard & AgusAlvarez.mp3"));
        trackList.add(new Track("Cuba Title Image.png", "Cuba Start Image.png", "Cuba Image.png", "Cuba Selected.mp3", "Cuba - ASHUTOSH.mp3"));
        trackList.add(new Track("Light Title Image.png", "Light Start Image.png", "Light Image.png", "Light Selected.mp3", "Light - Walen.mp3"));


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
                intromusic.close();
                selectTrack(0);
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
                selectLeft();
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
                selectRight();
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

    public void selectTrack(int nowSelected) {
        if(selectedMusic != null)
            selectedMusic.close();
        titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft() {
        if(nowSelected == 0)
            nowSelected = trackList.size() - 1;
        else
            nowSelected--;
        selectTrack(nowSelected);
    }

    public void selectRight() {
        if(nowSelected == trackList.size() - 1)
            nowSelected = 0;
        else
            nowSelected++;
        selectTrack(nowSelected);
    }
}