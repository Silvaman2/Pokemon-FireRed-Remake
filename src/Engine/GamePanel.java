package Engine;

import Engine.Utils.Component;
import Engine.Utils.GameObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private BufferedImage gameImage;


    public GamePanel() {
        this.setPreferredSize(new Dimension(Game.WIDTH * Game.PPU, Game.HEIGHT * Game.PPU));
    }

    public static BufferedImage getImage(String filePath) {

        try(InputStream input = GamePanel.class.getResourceAsStream("/Assets/" + filePath)) {
            assert input != null;
            return ImageIO.read(input);
        } catch (IOException ignored) {

        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gameImage, 0, 0, null);
    }

    public void updateGraphics() {
        this.gameImage = new BufferedImage(Game.WIDTH * Game.PPU, Game.HEIGHT * Game.PPU, BufferedImage.TYPE_INT_RGB);
        BufferedImage resultImage = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = resultImage.createGraphics();

        for (GameObject gameObject : Game.gameInstance.getGameObjects()) {
            for (Component component : gameObject.getComponents()) {
                component.drawUpdate(graphics);
            }
        }
        this.gameImage.createGraphics().drawImage(resultImage, 0, 0, Game.WIDTH * Game.PPU, Game.HEIGHT * Game.PPU, null);
        graphics.dispose();
    }
}
