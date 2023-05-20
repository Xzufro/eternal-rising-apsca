import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Player implements KeyListener, MouseListener, MouseMotionListener {
    private int x;
    private int y;
    private int speed;
    private int mouseX;
    private int mouseY;
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private boolean shooting;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        speed = 5;
        mouseX = x;
        mouseY = y;
        left = false;
        right = false;
        up = false;
        down = false;
        shooting = false;
    }

    public void update() {
        move();
        shoot();
    }

    private void move() {
        if (left && x > 0) {
            x -= speed;
        }
        if (right && x < ZombieShooter.WIDTH - 20) {
            x += speed;
        }
        if (up && y > 0) {
            y -= speed;
        }
        if (down && y < ZombieShooter.HEIGHT - 40) {
            y += speed;
        }
    }

    private void shoot() {
        if (shooting) {
            // Perform shooting logic here
            System.out.println("Shooting at: (" + mouseX + ", " + mouseY + ")");
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 20, 20);
        g.setColor(Color.GREEN);
        g.drawLine(x + 10, y + 10, mouseX, mouseY);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            right = true;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            right = false;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            down = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        shooting = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shooting = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void setLeft(boolean b) {
        this.left = b;
    }

    public void setUp(boolean b) {
        this.up = b;
    }

    public void setDown(boolean b) {
        this.down = b;
    }

    public void setShooting(boolean b) {
        this.shooting = b;
    }

    public void setMouseX(int x2) {
        this.mouseX = x2;
    }

    public void setRight(boolean b) {
        this.right = b;
    }

}
