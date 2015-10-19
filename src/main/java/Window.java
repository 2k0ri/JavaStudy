import javax.swing.JFrame;
import java.awt.*;

/**
 * JFrameフレーム
 */
public class Window extends JFrame {
    Window(String title) {
        setTitle(title);
        setVisible(true);
        setSize(320, 240);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(110, 80, 100, 100);
    }
}
