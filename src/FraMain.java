import javax.swing.JFrame;

public class FraMain extends JFrame {

    public FraMain() {
        add(new PanBoard());
        setTitle("Late Night Tea Gathering 1.2.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 618); //1370, 730 for fullscreen for laptop
        this.setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}