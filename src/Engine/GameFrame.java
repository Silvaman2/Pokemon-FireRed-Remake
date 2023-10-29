package Engine;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(GamePanel panel) {
        this.add(panel);
        this.pack();
        this.setResizable(false);
        this.addKeyListener(Game.INPUT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
