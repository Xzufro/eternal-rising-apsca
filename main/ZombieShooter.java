import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ZombieShooter extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    public static final String TITLE = "Zombie Shooter";

    private Thread thread;
    private boolean running;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    private Player player;

    public ZombieShooter() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();

        // Create the player object
        player = new Player(WIDTH / 2 - 10, HEIGHT / 2 - 10);

        // Add the event listeners
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void run() {
        running = true;

        long start, elapsed, wait;

        while (running) {
            start = System.nanoTime();

            update();
            repaint();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            if (wait < 0) {
                wait = 5;
            }

            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        player.update();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, WIDTH, HEIGHT);

        player.render(g);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            player.setLeft(true);
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            player.setRight(true);
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            player.setUp(true);
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            player.setDown(true);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            player.setLeft(false);
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            player.setRight(false);
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            player.setUp(false);
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            player.setDown(false);
        }
    }

    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public void mouseClicked(MouseEvent e) {
        // Not used
    }

    public void mousePressed(MouseEvent e) {
        player.setShooting(true);
    }

    public void mouseReleased(MouseEvent e) {
        player.setShooting(false);
    }

    public void mouseEntered(MouseEvent e) {
        // Not used
    }

    public void mouseExited(MouseEvent e) {
        // Not used
    }

    public void mouseDragged(MouseEvent e) {
        // Not used
    }

    public void mouseMoved(MouseEvent e) {
        // Not used
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(TITLE);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new ZombieShooter());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
