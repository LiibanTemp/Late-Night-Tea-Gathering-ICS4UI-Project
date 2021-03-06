
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Player {

    private Image img;
    private BufferedImage biSpriteSheet;
    int i, a;
    int x, y, bx, by, dx, dy, backgroundX, nYMain, nXMain, nY, nX;
    private final int SPEED = 15;
    boolean left, right, up, down;
    boolean arImage[][] = new boolean[9][4];
    ImageIcon p = new ImageIcon("sprite.png");
    int H = p.getIconHeight() / 4;
    int W = p.getIconWidth() / 9;

    public void loadSprite(String sFile) {
        try {
            biSpriteSheet = ImageIO.read(new File("sprite.png"));;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    int rows = 4;
    int cols = 9;
    BufferedImage[] sprites = new BufferedImage[rows * cols];
//BufferedImage bigImg = ImageIO.read(new File("spritesheet.png"));
    Rectangle r;

    public Player() {
        r = new Rectangle();
        x = 0;
        y = 376;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        //nY = nY2 * H;
    }

    public Rectangle getRect() {
        r.setBounds(nX, nY, W, H);
        return r;
    }

    public void move() {
        x += dx;
        y += dy;
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        img = p.getImage();
        return img;

    }

    public void keyPressed(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_A) {
//            nY = 2;
            dx = -SPEED;
        }else if (code == KeyEvent.VK_D) {
//            nY = 3;
            dx = SPEED;
        }
         if (code == KeyEvent.VK_W) {
            //dy--;
         }else{
             //dy++;
         }
    }

    public void keyReleased(KeyEvent w) {
        dy=0;
        dx = 0;

    }
}