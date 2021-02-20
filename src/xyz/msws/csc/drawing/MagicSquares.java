package xyz.msws.csc.drawing;

import java.awt.*;

/**
 * Isaac Boaz
 */
public class MagicSquares {
    private int width = 500, height = 500;
    private int boxes = 6;
    private Graphics g;

    public static void main(String[] args) {
        new MagicSquares();
    }

    /**
     * A magic 4x4 square where all columns and rows add up to 34. Sub-squares also add up to 34.
     */
    public MagicSquares() {
        DrawingPanel panel = new DrawingPanel(500, 500);
        this.g = panel.getGraphics();
        drawTitle();
        drawBoxes();
        drawNumbers();
    }

    /**
     * Draws the title centered and at height / 10
     */
    private void drawTitle() {
        drawCentered("CSC 142 Magic Square", width / 2, height / 10);
    }

    /**
     * Draws empty boxes, note that there is a bug with {@link DrawingPanel}, and that this code is not incorrect
     */
    private void drawBoxes() {
        for (int x = width / boxes; x <= width / boxes * (boxes - 2); x += width / boxes) {
            for (int y = height / boxes; y <= height / boxes * (boxes - 2); y += height / boxes) {
                // This code should run perfectly, for some reason DrawingPanel is graphically inaccurate
                g.drawRect(x, y, x + width / boxes, y + height / boxes);
            }
        }
    }

    /**
     * Fills in hard-coded numbers
     */
    private void drawNumbers() {
        int numbers[][] = new int[][]{{8, 11, 14, 1}, {13, 2, 7, 12}, {3, 16, 9, 6}, {10, 5, 4, 15}};

        for (int x = 0; x < numbers.length; x++) {
            int px = width / boxes / 2 + (width / boxes * (x + 1));
            for (int y = 0; y < numbers[x].length; y++) {
                int py = height / boxes / 2 + (height / boxes * (y + 1));
                drawCentered(numbers[x][y] + "", px, py);
            }
        }
    }

    /**
     * Draws the specified string horizontally centered
     * @param str String to draw
     * @param x X coord to draw @
     * @param y Y coord to draw @
     */
    private void drawCentered(String str, int x, int y) {
        FontMetrics metrics = g.getFontMetrics();
        g.drawString(str, x - (metrics.stringWidth(str) / 2), y);
    }

}
