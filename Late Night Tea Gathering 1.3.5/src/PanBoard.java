
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class PanBoard extends JPanel implements ActionListener {

    static boolean drawn = false;
    Rectangle rB, rP;
    private Player p;
    Sprite s;
    private Timer timer;
    private Image background;
    static String sName;
    Label JLabel;
    int nChange = 1, nSpriteX, nSpriteY;
    String sFile;
    BufferedImage biSpriteSheet, biSprite;
    private static Background bg1, bg2;

    public PanBoard() {

        sFile = "Walk (2).png";
        nSpriteX = 0;
        nSpriteY = 3;
        p = new Player();
        s = new Sprite();
        bg1 = new Background(0, 0);
        bg2 = new Background(2160, 0);
        s.loadSprite(sFile);
        addKeyListener(new Movement());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("Tea2.jpg");
        background = i1.getImage();
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        p.move();
        bg1.update();
        bg2.update();
        biSprite = s.getSprite(nSpriteX, nSpriteY);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
        g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
        g2d.drawImage(biSprite, p.getX(), p.getY(), null);
    }

    private class Movement extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent w) {
            p.keyReleased(w);
        }

        @Override
        public void keyPressed(KeyEvent w) {
            p.keyPressed(w);
            int code = w.getKeyCode();
            if (code == KeyEvent.VK_A) {
                nSpriteY = 1;
                nSpriteX++;
            } else if (code == KeyEvent.VK_D) {
                nSpriteY = 3;
                nSpriteX++;
            }
            if (nSpriteX == 8) {
                nSpriteX = 0;
            }
        }
    }
    public static Background getBg1() {
        return bg1;
    }

    public static Background getBg2() {
        return bg2;
    }
}