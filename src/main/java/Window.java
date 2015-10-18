import javax.swing.JFrame;

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
}
