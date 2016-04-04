/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gulat5020
 */
import java.awt.Component;
import javax.swing.JFrame;
public class Runner extends JFrame{
    public Runner() {
        super("Scrolling Background Demo");
        setSize(550, 250);
 
        ScrollingBackground back = new ScrollingBackground();
        ((Component)back).setFocusable(true);
        getContentPane().add(back);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new Runner();
    }
 
}
