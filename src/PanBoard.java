
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class PanBoard extends JPanel implements ActionListener {

    static boolean drawn = false;
    Rectangle rB, rP; // rectangles for the 3 sprites.
    private Player p;
    Sprite s;
    //Jump j;
    private Timer timer;
    private Image background;
    static String sName;
    Label JLabel;
    int nChange = 1, nX, nY;
    String sFile;
    BufferedImage biSpriteSheet, biSprite;

    public PanBoard() {
        sFile = "Walk.png";
        nX = 0;
        nY = 3;
        p = new Player();
        s = new Sprite();
        //j = new Jump();
        s.loadSprite(sFile);
        addKeyListener(new Movement());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("Castle2.jpg");
        background = i1.getImage();
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        p.move();
        biSprite = s.getSprite(nX, nY);
        repaint();
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        //g2d.drawImage(s.getSprite(nX, nY), p.getX(), p.getY(), null);
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
            nY = 1;
            nX++;
        }else if (code == KeyEvent.VK_D) {
            nY = 3;
            nX++;
        } else if (code == KeyEvent.VK_W) {
            //nY = 0;
            nX++;
        } else if (code == KeyEvent.VK_S) {
            //nY = 2;
            nX++;
        }
        if (nX == 8) {
            nX = 0;
        }
        }
    }
}