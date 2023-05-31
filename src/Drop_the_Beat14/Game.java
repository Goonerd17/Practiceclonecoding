package Drop_the_Beat14;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread {

    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList= new ArrayList<Note>();

    public Game(String titleName, String difficulty, String musicTitle) {
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle =musicTitle;
        gameMusic = new Music(this.musicTitle, false);

    }

    public void screenDraw(Graphics2D g) {
        g.drawImage (noteRouteSImage,228, 30, null);
        g.drawImage (noteRouteDImage,332, 30, null);
        g.drawImage (noteRouteFImage,436, 30, null);
        g.drawImage (noteRouteSpace1Image,540, 30, null);
        g.drawImage (noteRouteSpace2Image,640, 30, null);
        g.drawImage (noteRouteJImage,744, 30, null);
        g.drawImage (noteRouteKImage,848, 30, null);
        g.drawImage (noteRouteLImage,952, 30, null);
        g.drawImage (noteRouteLineImage,224, 30, null);
        g.drawImage (noteRouteLineImage,328, 30, null);
        g.drawImage (noteRouteLineImage,432, 30, null);
        g.drawImage (noteRouteLineImage,536, 30, null);
        g.drawImage (noteRouteLineImage,740, 30, null);
        g.drawImage (noteRouteLineImage,844, 30, null);
        g.drawImage (noteRouteLineImage,948, 30, null);
        g.drawImage (noteRouteLineImage,1052, 30, null);
        g.drawImage (gameInfoImage,0, 660, null);
        g.drawImage (judgementLineImage,0, 580, null);

        for(int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            note.screenDraw(g);
        }

        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty, 1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S", 270, 620);
        g.drawString("D", 374, 620);
        g.drawString("F", 478, 620);
        g.drawString("Space Bar", 580, 620);
        g.drawString("J", 784, 620);
        g.drawString("K", 889, 620);
        g.drawString("L", 993, 620);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 800, 702);


    }

    public void pressS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }


    public void pressD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }


    public void pressF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }


    public void pressSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
    }
    public void releaseSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        new Music("drumBig1.mp3", false).start();
    }


    public void pressJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }


    public void pressK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }


    public void pressL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }




    @Override
    public void run() {
        dropNotes();

    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes() {
        Beat[] beats = null;
        if(titleName.equals("Light - Walen")) {
            int startTime = 4460 - Main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[] {
                    new Beat(startTime, "S"),
                    new Beat(startTime + gap * 5, "S"),
                    new Beat(startTime + gap * 10, "S"),
                    new Beat(startTime + gap * 15, "S"),
                    new Beat(startTime + gap * 20, "S"),
                    new Beat(startTime + gap * 25, "S"),
                    new Beat(startTime + gap * 30, "S"),
                    new Beat(startTime + gap * 35, "S"),

                    new Beat(startTime + gap * 44, "D"),
                    new Beat(startTime + gap * 44, "K"),
                    new Beat(startTime + gap * 53, "D"),
                    new Beat(startTime + gap * 53, "K"),
                    new Beat(startTime + gap * 62, "D"),
                    new Beat(startTime + gap * 62, "K"),
                    new Beat(startTime + gap * 71, "D"),
                    new Beat(startTime + gap * 71, "K"),
                    new Beat(startTime + gap * 80, "D"),
                    new Beat(startTime + gap * 80, "K"),
                    new Beat(startTime + gap * 90, "D"),
                    new Beat(startTime + gap * 90, "K"),
                    new Beat(startTime + gap * 100, "D"),
                    new Beat(startTime + gap * 100, "K"),
                    new Beat(startTime + gap * 110, "D"),
                    new Beat(startTime + gap * 110, "K"),

                    new Beat(startTime + gap * 114, "Space"),
                    new Beat(startTime + gap * 122, "S"),
                    new Beat(startTime + gap * 123, "D"),
                    new Beat(startTime + gap * 125, "F"),
                    new Beat(startTime + gap * 126, "J"),
                    new Beat(startTime + gap * 128, "K"),
                    new Beat(startTime + gap * 135, "S"),
                    new Beat(startTime + gap * 138, "S"),
                    new Beat(startTime + gap * 141, "S"),
                    new Beat(startTime + gap * 144, "K"),
                    new Beat(startTime + gap * 145, "J"),
                    new Beat(startTime + gap * 146, "F"),
                    new Beat(startTime + gap * 147, "D"),

                    new Beat(startTime + gap * 150, "Space"),
                    new Beat(startTime + gap * 158, "S"),
                    new Beat(startTime + gap * 159, "D"),
                    new Beat(startTime + gap * 161, "F"),
                    new Beat(startTime + gap * 163, "J"),
                    new Beat(startTime + gap * 165, "K"),
                    new Beat(startTime + gap * 172, "S"),
                    new Beat(startTime + gap * 175, "S"),
                    new Beat(startTime + gap * 178, "S"),
                    new Beat(startTime + gap * 181, "K"),
                    new Beat(startTime + gap * 182, "J"),
                    new Beat(startTime + gap * 183, "F"),
                    new Beat(startTime + gap * 184, "D"),

                    new Beat(startTime + gap * 187, "Space"),
                    new Beat(startTime + gap * 195, "S"),
                    new Beat(startTime + gap * 196, "D"),
                    new Beat(startTime + gap * 198, "F"),
                    new Beat(startTime + gap * 200, "J"),
                    new Beat(startTime + gap * 202, "K"),
                    new Beat(startTime + gap * 209, "S"),
                    new Beat(startTime + gap * 212, "S"),
                    new Beat(startTime + gap * 215, "S"),
                    new Beat(startTime + gap * 218, "K"),
                    new Beat(startTime + gap * 219, "J"),
                    new Beat(startTime + gap * 220, "F"),
                    new Beat(startTime + gap * 221, "D"),

                    new Beat(startTime + gap * 226, "Space"),
                    new Beat(startTime + gap * 227, "L"),
                    new Beat(startTime + gap * 228, "L"),
                    new Beat(startTime + gap * 229, "L"),
                    new Beat(startTime + gap * 230, "L"),
                    new Beat(startTime + gap * 234, "S"),
                    new Beat(startTime + gap * 235, "D"),
                    new Beat(startTime + gap * 237, "F"),
                    new Beat(startTime + gap * 239, "J"),
                    new Beat(startTime + gap * 241, "K"),
                    new Beat(startTime + gap * 248, "L"),
                    new Beat(startTime + gap * 251, "L"),
                    new Beat(startTime + gap * 254, "L"),
                    new Beat(startTime + gap * 257, "K"),
                    new Beat(startTime + gap * 258, "J"),
                    new Beat(startTime + gap * 259, "F"),
                    new Beat(startTime + gap * 260, "D"),









            };
        } else if (titleName.equals("Cuba - ASHUTOSH")) {
            int startTime = 1000;
            beats = new Beat[] {
                    new Beat(startTime, "Space"),
            };
            
        } else if (titleName.equals("Beautiful Liar - Markvard & AgusAlvarez")) {
            int startTime = 1000;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
            };
        }

        int i = 0;
        gameMusic.start();
        while (i < beats.length && !isInterrupted()) {
            boolean dropped = false;
            if (beats[i].getTime() <= gameMusic.getTime()) {
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
            if (!dropped){
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
