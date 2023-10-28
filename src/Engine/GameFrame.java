package Engine;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        this.setSize(Game.WIDTH, Game.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
