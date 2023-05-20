import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Zombie {
    private int x;
    private int y;
    private int speed;
    private int direction;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
        speed = 2;
        direction = new Random().nextInt(4);
    }

    public void update() {
        if (direction == 0 && x > 0) {
            x -= speed;
        }
        if (direction == 1 && x < ZombieShooter.WIDTH - 20) {
            x += speed;
        }
        if (direction == 2 && y > 0) {
            y -= speed;
        }
        if (direction == 3 && y < ZombieShooter.HEIGHT - 40) {
            y += speed;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
