package Drop_the_Beat15;

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
    private Image blueFlareImage;
    private Image judgeImage;
    private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();


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
            if (note.getY() > 620) {
                judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
            }
            if (!note.isProceeded()) {
                noteList.remove(i);
                i--;
            } else {
                note.screenDraw(g);
            }
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
        g.drawImage(blueFlareImage,320, 370, null);
        g.drawImage(judgeImage,460, 420, null);
        g.drawImage(keyPadSImage, 228, 580, null);
        g.drawImage(keyPadDImage, 332, 580, null);
        g.drawImage(keyPadFImage, 436, 580, null);
        g.drawImage(keyPadSpace1Image, 540, 580, null);
        g.drawImage(keyPadSpace2Image, 640, 580, null);
        g.drawImage(keyPadJImage, 744, 580, null);
        g.drawImage(keyPadKImage, 848, 580, null);
        g.drawImage(keyPadLImage, 952, 580, null);



    }

    public void pressS() {
        judge("S");
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }


    public void pressD() {
        judge("D");
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }


    public void pressF() {
        judge("F");
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }


    public void pressSpace() {
        judge("Space");
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumBig1.mp3", false).start();
    }
    public void releaseSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
        keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }


    public void pressJ() {
        judge("J");
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }


    public void pressK() {
        judge("K");
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }


    public void pressL() {
        judge("L");
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }




    @Override
    public void run() {
        dropNotes(this.titleName);

    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes(String titleName) {
        Beat[] beats = null;
        if(titleName.equals("Light - Walen") && difficulty.equals("Easy")) {
            int startTime = 4460 - Main.REACH_TIME * 1000;
            int gap = 120;
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
                    new Beat(startTime + gap * 135, "L"),
                    new Beat(startTime + gap * 138, "L"),
                    new Beat(startTime + gap * 141, "L"),
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
                    new Beat(startTime + gap * 172, "L"),
                    new Beat(startTime + gap * 175, "L"),
                    new Beat(startTime + gap * 178, "L"),
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
                    new Beat(startTime + gap * 209, "L"),
                    new Beat(startTime + gap * 212, "L"),
                    new Beat(startTime + gap * 215, "L"),
                    new Beat(startTime + gap * 218, "K"),
                    new Beat(startTime + gap * 219, "J"),
                    new Beat(startTime + gap * 220, "F"),
                    new Beat(startTime + gap * 221, "D"),

                    new Beat(startTime + gap * 226, "Space"),
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

                    new Beat(startTime + gap * 265, "Space"),
                    new Beat(startTime + gap * 273, "S"),
                    new Beat(startTime + gap * 274, "D"),
                    new Beat(startTime + gap * 276, "F"),
                    new Beat(startTime + gap * 278, "J"),
                    new Beat(startTime + gap * 280, "K"),
                    new Beat(startTime + gap * 287, "L"),
                    new Beat(startTime + gap * 290, "L"),
                    new Beat(startTime + gap * 293, "L"),
                    new Beat(startTime + gap * 296, "K"),
                    new Beat(startTime + gap * 297, "J"),
                    new Beat(startTime + gap * 298, "F"),
                    new Beat(startTime + gap * 299, "D"),

                    new Beat(startTime + gap * 304, "Space"),
                    new Beat(startTime + gap * 312, "S"),
                    new Beat(startTime + gap * 313, "D"),
                    new Beat(startTime + gap * 315, "F"),
                    new Beat(startTime + gap * 317, "J"),
                    new Beat(startTime + gap * 319, "K"),
                    new Beat(startTime + gap * 326, "L"),
                    new Beat(startTime + gap * 329, "L"),
                    new Beat(startTime + gap * 332, "L"),
                    new Beat(startTime + gap * 335, "K"),
                    new Beat(startTime + gap * 336, "J"),
                    new Beat(startTime + gap * 337, "F"),
                    new Beat(startTime + gap * 338, "D"),

                    new Beat(startTime + gap * 341, "Space"),
                    new Beat(startTime + gap * 349, "S"),
                    new Beat(startTime + gap * 350, "D"),
                    new Beat(startTime + gap * 352, "F"),
                    new Beat(startTime + gap * 354, "J"),
                    new Beat(startTime + gap * 356, "K"),
                    new Beat(startTime + gap * 363, "L"),
                    new Beat(startTime + gap * 366, "L"),
                    new Beat(startTime + gap * 369, "L"),
                    new Beat(startTime + gap * 372, "K"),
                    new Beat(startTime + gap * 373, "J"),
                    new Beat(startTime + gap * 374, "F"),
                    new Beat(startTime + gap * 375, "D"),

                    new Beat(startTime + gap * 379, "Space"),
                    new Beat(startTime + gap * 387, "S"),
                    new Beat(startTime + gap * 388, "D"),
                    new Beat(startTime + gap * 390, "F"),
                    new Beat(startTime + gap * 392, "J"),
                    new Beat(startTime + gap * 394, "K"),
                    new Beat(startTime + gap * 401, "L"),
                    new Beat(startTime + gap * 404, "L"),
                    new Beat(startTime + gap * 407, "L"),
                    new Beat(startTime + gap * 410, "K"),
                    new Beat(startTime + gap * 411, "J"),
                    new Beat(startTime + gap * 412, "F"),
                    new Beat(startTime + gap * 413, "D"),

                    new Beat(startTime + gap * 415, "Space"),
                    new Beat(startTime + gap * 423, "S"),
                    new Beat(startTime + gap * 424, "D"),
                    new Beat(startTime + gap * 426, "F"),
                    new Beat(startTime + gap * 428, "J"),
                    new Beat(startTime + gap * 430, "K"),
                    new Beat(startTime + gap * 437, "L"),
                    new Beat(startTime + gap * 440, "L"),
                    new Beat(startTime + gap * 443, "L"),
                    new Beat(startTime + gap * 446, "K"),
                    new Beat(startTime + gap * 447, "J"),
                    new Beat(startTime + gap * 448, "F"),
                    new Beat(startTime + gap * 449, "D"),

                    new Beat(startTime + gap * 453, "Space"),
                    new Beat(startTime + gap * 461, "S"),
                    new Beat(startTime + gap * 462, "D"),
                    new Beat(startTime + gap * 464, "F"),
                    new Beat(startTime + gap * 466, "J"),
                    new Beat(startTime + gap * 468, "K"),
                    new Beat(startTime + gap * 474, "L"),
                    new Beat(startTime + gap * 477, "L"),
                    new Beat(startTime + gap * 480, "L"),
                    new Beat(startTime + gap * 482, "K"),
                    new Beat(startTime + gap * 483, "J"),
                    new Beat(startTime + gap * 484, "F"),
                    new Beat(startTime + gap * 485, "D"),

                    new Beat(startTime + gap * 489, "Space"),
                    new Beat(startTime + gap * 497, "S"),
                    new Beat(startTime + gap * 498, "D"),
                    new Beat(startTime + gap * 500, "F"),
                    new Beat(startTime + gap * 502, "J"),
                    new Beat(startTime + gap * 504, "K"),
                    new Beat(startTime + gap * 510, "L"),
                    new Beat(startTime + gap * 513, "L"),
                    new Beat(startTime + gap * 516, "L"),
                    new Beat(startTime + gap * 518, "K"),
                    new Beat(startTime + gap * 519, "J"),
                    new Beat(startTime + gap * 520, "F"),
                    new Beat(startTime + gap * 521, "D"),

                    new Beat(startTime + gap * 526, "Space"),
                    new Beat(startTime + gap * 534, "S"),
                    new Beat(startTime + gap * 535, "D"),
                    new Beat(startTime + gap * 537, "F"),
                    new Beat(startTime + gap * 539, "J"),
                    new Beat(startTime + gap * 541, "K"),
                    new Beat(startTime + gap * 547, "L"),
                    new Beat(startTime + gap * 550, "L"),
                    new Beat(startTime + gap * 553, "L"),
                    new Beat(startTime + gap * 555, "K"),
                    new Beat(startTime + gap * 556, "J"),
                    new Beat(startTime + gap * 557, "F"),
                    new Beat(startTime + gap * 558, "D"),

                    new Beat(startTime + gap * 560, "S"),
                    new Beat(startTime + gap * 565, "S"),
                    new Beat(startTime + gap * 570, "S"),
                    new Beat(startTime + gap * 575, "S"),
                    new Beat(startTime + gap * 580, "S"),
                    new Beat(startTime + gap * 585, "S"),
                    new Beat(startTime + gap * 590, "S"),
                    new Beat(startTime + gap * 595, "S"),

                    new Beat(startTime + gap * 600, "L"),
                    new Beat(startTime + gap * 605, "L"),
                    new Beat(startTime + gap * 610, "L"),
                    new Beat(startTime + gap * 615, "L"),
                    new Beat(startTime + gap * 620, "L"),
                    new Beat(startTime + gap * 625, "L"),
                    new Beat(startTime + gap * 630, "L"),
                    new Beat(startTime + gap * 635, "L"),

                    new Beat(startTime + gap * 645, "D"),
                    new Beat(startTime + gap * 645, "K"),
                    new Beat(startTime + gap * 654, "D"),
                    new Beat(startTime + gap * 654, "K"),
                    new Beat(startTime + gap * 663, "D"),
                    new Beat(startTime + gap * 663, "K"),
                    new Beat(startTime + gap * 673, "D"),
                    new Beat(startTime + gap * 673, "K"),
                    new Beat(startTime + gap * 683, "D"),
                    new Beat(startTime + gap * 683, "K"),
                    new Beat(startTime + gap * 693, "D"),
                    new Beat(startTime + gap * 693, "K"),
                    new Beat(startTime + gap * 703, "D"),
                    new Beat(startTime + gap * 703, "K"),
                    new Beat(startTime + gap * 713, "D"),
                    new Beat(startTime + gap * 713, "K"),

                    new Beat(startTime + gap * 717, "Space"),
                    new Beat(startTime + gap * 725, "S"),
                    new Beat(startTime + gap * 726, "D"),
                    new Beat(startTime + gap * 728, "F"),
                    new Beat(startTime + gap * 730, "J"),
                    new Beat(startTime + gap * 732, "K"),
                    new Beat(startTime + gap * 738, "L"),
                    new Beat(startTime + gap * 741, "L"),
                    new Beat(startTime + gap * 744, "L"),
                    new Beat(startTime + gap * 746, "K"),
                    new Beat(startTime + gap * 747, "J"),
                    new Beat(startTime + gap * 748, "F"),
                    new Beat(startTime + gap * 749, "D"),

                    new Beat(startTime + gap * 753, "Space"),
                    new Beat(startTime + gap * 760, "S"),
                    new Beat(startTime + gap * 761, "D"),
                    new Beat(startTime + gap * 763, "F"),
                    new Beat(startTime + gap * 765, "J"),
                    new Beat(startTime + gap * 767, "K"),
                    new Beat(startTime + gap * 773, "L"),
                    new Beat(startTime + gap * 776, "L"),
                    new Beat(startTime + gap * 779, "L"),
                    new Beat(startTime + gap * 782, "K"),
                    new Beat(startTime + gap * 784, "J"),
                    new Beat(startTime + gap * 785, "F"),
                    new Beat(startTime + gap * 786, "D"),

                    new Beat(startTime + gap * 790, "Space"),
                    new Beat(startTime + gap * 797, "S"),
                    new Beat(startTime + gap * 798, "D"),
                    new Beat(startTime + gap * 800, "F"),
                    new Beat(startTime + gap * 802, "J"),
                    new Beat(startTime + gap * 804, "K"),
                    new Beat(startTime + gap * 810, "L"),
                    new Beat(startTime + gap * 813, "L"),
                    new Beat(startTime + gap * 816, "L"),
                    new Beat(startTime + gap * 819, "K"),
                    new Beat(startTime + gap * 821, "J"),
                    new Beat(startTime + gap * 822, "F"),
                    new Beat(startTime + gap * 823, "D"),

                    new Beat(startTime + gap * 829, "Space"),
                    new Beat(startTime + gap * 836, "S"),
                    new Beat(startTime + gap * 837, "D"),
                    new Beat(startTime + gap * 839, "F"),
                    new Beat(startTime + gap * 841, "J"),
                    new Beat(startTime + gap * 843, "K"),
                    new Beat(startTime + gap * 849, "L"),
                    new Beat(startTime + gap * 852, "L"),
                    new Beat(startTime + gap * 855, "L"),
                    new Beat(startTime + gap * 858, "K"),
                    new Beat(startTime + gap * 860, "J"),
                    new Beat(startTime + gap * 861, "F"),
                    new Beat(startTime + gap * 862, "D"),

                    new Beat(startTime + gap * 868, "Space"),
                    new Beat(startTime + gap * 875, "S"),
                    new Beat(startTime + gap * 876, "D"),
                    new Beat(startTime + gap * 878, "F"),
                    new Beat(startTime + gap * 880, "J"),
                    new Beat(startTime + gap * 882, "K"),
                    new Beat(startTime + gap * 888, "L"),
                    new Beat(startTime + gap * 891, "L"),
                    new Beat(startTime + gap * 894, "L"),
                    new Beat(startTime + gap * 897, "K"),
                    new Beat(startTime + gap * 899, "J"),
                    new Beat(startTime + gap * 900, "F"),
                    new Beat(startTime + gap * 901, "D"),

                    new Beat(startTime + gap * 907, "Space"),
                    new Beat(startTime + gap * 913, "S"),
                    new Beat(startTime + gap * 915, "D"),
                    new Beat(startTime + gap * 917, "F"),
                    new Beat(startTime + gap * 919, "J"),
                    new Beat(startTime + gap * 921, "K"),
                    new Beat(startTime + gap * 927, "L"),
                    new Beat(startTime + gap * 930, "L"),
                    new Beat(startTime + gap * 933, "L"),
                    new Beat(startTime + gap * 936, "K"),
                    new Beat(startTime + gap * 938, "J"),
                    new Beat(startTime + gap * 939, "F"),
                    new Beat(startTime + gap * 940, "D"),

                    new Beat(startTime + gap * 944, "Space"),
                    new Beat(startTime + gap * 951, "S"),
                    new Beat(startTime + gap * 953, "D"),
                    new Beat(startTime + gap * 955, "F"),
                    new Beat(startTime + gap * 957, "J"),
                    new Beat(startTime + gap * 959, "K"),
                    new Beat(startTime + gap * 965, "L"),
                    new Beat(startTime + gap * 968, "L"),
                    new Beat(startTime + gap * 971, "L"),
                    new Beat(startTime + gap * 974, "K"),
                    new Beat(startTime + gap * 976, "J"),
                    new Beat(startTime + gap * 977, "F"),
                    new Beat(startTime + gap * 978, "D"),

                    new Beat(startTime + gap * 982, "Space"),
                    new Beat(startTime + gap * 988, "S"),
                    new Beat(startTime + gap * 990, "D"),
                    new Beat(startTime + gap * 992, "F"),
                    new Beat(startTime + gap * 994, "J"),
                    new Beat(startTime + gap * 996, "K"),
                    new Beat(startTime + gap * 1002, "L"),
                    new Beat(startTime + gap * 1005, "L"),
                    new Beat(startTime + gap * 1008, "L"),
                    new Beat(startTime + gap * 1011, "K"),
                    new Beat(startTime + gap * 1013, "J"),
                    new Beat(startTime + gap * 1014, "F"),
                    new Beat(startTime + gap * 1015, "D"),

                    new Beat(startTime + gap * 1019, "Space"),
                    new Beat(startTime + gap * 1026, "S"),
                    new Beat(startTime + gap * 1028, "D"),
                    new Beat(startTime + gap * 1030, "F"),
                    new Beat(startTime + gap * 1032, "J"),
                    new Beat(startTime + gap * 1034, "K"),
                    new Beat(startTime + gap * 1040, "L"),
                    new Beat(startTime + gap * 1043, "L"),
                    new Beat(startTime + gap * 1046, "L"),
                    new Beat(startTime + gap * 1049, "K"),
                    new Beat(startTime + gap * 1051, "J"),
                    new Beat(startTime + gap * 1052, "F"),
                    new Beat(startTime + gap * 1053, "D"),

                    new Beat(startTime + gap * 1057, "Space"),
                    new Beat(startTime + gap * 1064, "S"),
                    new Beat(startTime + gap * 1066, "D"),
                    new Beat(startTime + gap * 1068, "F"),
                    new Beat(startTime + gap * 1070, "J"),
                    new Beat(startTime + gap * 1072, "K"),
                    new Beat(startTime + gap * 1078, "L"),
                    new Beat(startTime + gap * 1081, "L"),
                    new Beat(startTime + gap * 1084, "L"),
                    new Beat(startTime + gap * 1087, "K"),
                    new Beat(startTime + gap * 1089, "J"),
                    new Beat(startTime + gap * 1090, "F"),
                    new Beat(startTime + gap * 1091, "D"),

                    new Beat(startTime + gap * 1095, "Space"),
                    new Beat(startTime + gap * 1102, "S"),
                    new Beat(startTime + gap * 1104, "D"),
                    new Beat(startTime + gap * 1106, "F"),
                    new Beat(startTime + gap * 1108, "J"),
                    new Beat(startTime + gap * 1110, "K"),
                    new Beat(startTime + gap * 1116, "L"),
                    new Beat(startTime + gap * 1119, "L"),
                    new Beat(startTime + gap * 1122, "L"),
                    new Beat(startTime + gap * 1125, "K"),
                    new Beat(startTime + gap * 1127, "J"),
                    new Beat(startTime + gap * 1128, "F"),
                    new Beat(startTime + gap * 1129, "D"),

                    new Beat(startTime + gap * 1133, "Space"),
                    new Beat(startTime + gap * 1140, "S"),
                    new Beat(startTime + gap * 1142, "D"),
                    new Beat(startTime + gap * 1144, "F"),
                    new Beat(startTime + gap * 1146, "J"),
                    new Beat(startTime + gap * 1148, "K"),
                    new Beat(startTime + gap * 1154, "L"),
                    new Beat(startTime + gap * 1157, "L"),
                    new Beat(startTime + gap * 1160, "L"),
                    new Beat(startTime + gap * 1163, "K"),
                    new Beat(startTime + gap * 1165, "J"),
                    new Beat(startTime + gap * 1166, "F"),
                    new Beat(startTime + gap * 1167, "D"),
            };

        } else if (titleName.equals("Light - Walen") && difficulty.equals("Hard")) {
            int startTime = 1000;
            beats = new Beat[] {
                    new Beat(startTime, "Space"),
            };

        } else if (titleName.equals("Cuba - ASHUTOSH") && difficulty.equals("Easy")) {
            int startTime = 1000;
            beats = new Beat[] {
                    new Beat(startTime, "Space"),
            };

        } else if (titleName.equals("Cuba - ASHUTOSH") && difficulty.equals("Hard")) {
            int startTime = 1000;
            beats = new Beat[] {
                    new Beat(startTime, "Space"),
            };
            
        } else if (titleName.equals("Beautiful Liar - Markvard & AgusAlvarez") && difficulty.equals("Easy")) {
            int startTime = 1000;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
            };

        } else if (titleName.equals("Beautiful Liar - Markvard & AgusAlvarez") && difficulty.equals("Hard")) {
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

//    노트 판정 함수
    public void judge(String input) {
        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            if (input.equals(note.getNoteType())) {
                judgeEvent(note.judge());
                break;
            }
        }
    }

//    각 노트가 judgementLine에 걸렸을 때 순간에 따른 피드백
    public void judgeEvent(String judge) {
        if (!judge.equals("None")) {
            blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
        }
        if(judge.equals("Miss")) {

            judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();

        } else if (judge.equals("Late")) {

            judgeImage = new ImageIcon(Main.class.getResource("../images/late.png")).getImage();

        } else if (judge.equals("Good")) {

            judgeImage = new ImageIcon(Main.class.getResource("../images/good.png")).getImage();

        } else if (judge.equals("Great")) {

            judgeImage = new ImageIcon(Main.class.getResource("../images/great.png")).getImage();

        } else if (judge.equals("Perfect")) {

            judgeImage = new ImageIcon(Main.class.getResource("../images/perfect.png")).getImage();

        } else if (judge.equals("Early")) {

            judgeImage = new ImageIcon(Main.class.getResource("../images/early.png")).getImage();
        }
    }

}
