package Drop_the_Beat3;

import javax.swing.*;
import java.awt.*;

public class DropTheBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private Image introBackground;
    public DropTheBeat () {
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        introBackground = new ImageIcon(Main.class.getResource("../images/introbackground(Title).jpg")).getImage();

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
        g.drawImage(introBackground, 0, 0, null);
        this.repaint();
    }
}