package xyz.msws.csc.drawing;

import java.awt.*;
import java.util.Random;

/**
 * Basic "physics" simulation animation of a ball
 */
public class Animation {

    private static final int width = 1000, height = 1000; // Width / Height of Canvas
    private double x, y; // Position of ball
    private double vx, vy; // Velocity of ball
    private double gravity = 9.8;
    private int radius = 100;
    private double mass = .85;
    private double drag = .0005;
    private double timeScale = .05;
    private double friction = .01;
    private double bounciness = .95;
    private Random rnd;

    private DrawingPanel panel;
    private Graphics g;

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(width, height);
        panel.setBackground(Color.BLACK);
        new Animation(panel).start();
    }

    public Animation(DrawingPanel panel) {
        this.panel = panel;
        this.g = panel.getGraphics();
    }

    /**
     * Note: this will suspend the active thread permanently, run on a separate
     * thread if you want code to be run after calling this method.
     */
    public void start() {
        rnd = new Random();
        x = width / 2 - radius / 2;
        y = width / 2 - radius / 2;
        vx = (rnd.nextDouble() - .5) * width / 2 / mass;
        vy = (rnd.nextDouble() - .5) * height / 2 / mass;

        while (true) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);
            tick();
            drawBall();
            panel.sleep(10);
        }

    }

    /**
     * Runs physics
     */
    private void tick() {
        vy += gravity;

        vx *= 1 - drag * mass;
        vy *= 1 - drag * mass;

        x += vx * timeScale;
        y += vy * timeScale;
        bounce();
    }

    /**
     * Checks if the ball is out of bounds and bounces it appropriately
     */
    private void bounce() {
        // If the ball was center-drawn then we would want to do x - radius < 0, however we do not, so
        // we appropriately account for the centering.

        if (x < 0 || x + radius > width) {
            vx = -vx * bounciness;
        }
        if (y < 0 || y + radius > height) {
            vy = -vy * bounciness;
            onFriction();
        }
        if (y + radius > height) {
            y = height - radius;
            onFriction();
        }
    }

    /**
     * Applies friction
     */
    private void onFriction() {
        vx *= 1 - friction;
    }

    /**
     * Draws the ball and a contrasting outline
     */
    private void drawBall() {
        int rc = (int) (Math.cos((x / width) * 3.0) * 255.0);
        int gc = (int) (Math.sin((y / height) * 3.0) * 255.0);
        int bc = (int) (Math.sin(((x * y) / (width + height)) / 100) * 255.0);

        rc = Math.min(Math.max(rc, 0), 255);
        gc = Math.min(Math.max(gc, 0), 255);
        bc = Math.min(Math.max(bc, 0), 255);

        g.setColor(new Color(rc, gc, bc));
        g.fillOval((int) x, (int) y, radius, radius); // Note: this "centers" the ball to the upper left, we account for this in the bounce method.

        // Draw ball outline
        g.setColor(new Color(255 - rc, 255 - gc, 255 - bc));
        g.drawOval((int) x, (int) y, radius + 1, radius + 1);
    }
}
