package Drop_the_Beat15;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (DropTheBeat.game == null) {
            return;
        }

        if(e.getKeyCode() == KeyEvent.VK_S) {
            DropTheBeat.game.pressS();

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            DropTheBeat.game.pressD();
            
        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            DropTheBeat.game.pressF();
            
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            DropTheBeat.game.pressSpace();
            
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            DropTheBeat.game.pressJ();
            
        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            DropTheBeat.game.pressK();
            
        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            DropTheBeat.game.pressL();
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (DropTheBeat.game == null) {
            return;
        }

        if(e.getKeyCode() == KeyEvent.VK_S) {
            DropTheBeat.game.releaseS();

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            DropTheBeat.game.releaseD();

        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            DropTheBeat.game.releaseF();

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            DropTheBeat.game.releaseSpace();

        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            DropTheBeat.game.releaseJ();

        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            DropTheBeat.game.releaseK();

        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            DropTheBeat.game.releaseL();

        }

    }

}
