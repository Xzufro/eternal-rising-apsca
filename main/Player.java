import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Player {
    private int x;
    private int y;
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private boolean shooting;
    private BufferedImage playerSprite;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.shooting = false;
        this.playerSprite = loadPlayerSprite();
    }
    private BufferedImage loadPlayerSprite() {
        try {
            URL resource = getClass().getResource("neeble-gnorp1.png");
            return ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public void update() {
        // Update player's position and perform other logic
        // based on the direction and shooting status
        if (left) {
            x -= 5;
        }
        if (right) {
            x += 5;
        }
        if (up) {
            y -= 5;
        }
        if (down) {
            y += 5;
        }
    }

    public void render(Graphics g) {
        // Render the player on the screen
        if (playerSprite != null) {
            g.drawImage(playerSprite, x, y, null);
        }
    }
}
