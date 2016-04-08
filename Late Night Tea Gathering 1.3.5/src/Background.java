//http://www.kilobolt.com/day-5-background-and-sprites/unit-2-day-5-background-and-sprites
////import java.awt.event.KeyEvent;

public class Background {

    private int nbgX, nbgY, nspeedX;

    public Background(int x, int y) {
        nbgX = x;
        nbgY = y;
        nspeedX = 765;
    }
// Test code for Scrolling background with Character movement    
//    public void keyPressed(KeyEvent w) {
//        int code = w.getKeyCode();
//        if (code == KeyEvent.VK_A) {
//            nbgX += nspeedX;
//        } else if (code == KeyEvent.VK_D) {
//            nbgX -= nspeedX;
//        }
//    }

    public void update() {
        nbgX -= nspeedX;

        if (nbgX <= -700) {
            nbgX += 1400;
        }
    }

    public int getBgX() {
        return nbgX;
    }

    public int getBgY() {
        return nbgY;
    }

    public int getSpeedX() {
        return nspeedX;
    }

    public void setBgX(int nbgX) {
        this.nbgX = nbgX;
    }

    public void setBgY(int nbgY) {
        this.nbgY = nbgY;
    }

    public void setSpeedX(int nspeedX) {
        this.nspeedX = nspeedX;
    }
}