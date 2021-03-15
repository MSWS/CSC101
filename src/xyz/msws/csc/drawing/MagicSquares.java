package xyz.msws.csc.drawing;

import java.awt.*;
import java.io.IOException;

/**
 * Isaac Boaz
 */
public class MagicSquares {
    private final int width = 500;
    private final int height = 500;
    private int[][] boxes;
    private int magic;
    private Graphics g;

    public static void main(String[] args) {
        for (int i = 35; i < 100; i++) {
            new MagicSquares(i);
        }
    }

    /**
     * A magic 4x4 square where all columns and rows add up to 34. Sub-squares also add up to 34.
     */
    public MagicSquares(int magic) {
        DrawingPanel panel = new DrawingPanel(500, 500);
        this.g = panel.getGraphics();
        this.magic = magic;
        generate();
        drawTitle();
        drawBoxes();
        drawNumbers();
        try {
            panel.save("MagicSquare" + magic + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSquareMagic(int[][] data) {
        // Check each column
        if (data.length == 0 || data.length != data[0].length) // data is not a square
            return false;

        int yTotal = -1, xTotal = -1;
        for (int x = 0; x < data.length; x++) {
            int cTotal = 0;
            for (int y = 0; y < data[x].length; y++) {
                cTotal += data[x][y];
            }

            if (yTotal == -1)
                yTotal = cTotal;
            if (cTotal != yTotal) {
                System.out.printf("Column %d has a total of %d when %d was expected\n", x, cTotal, yTotal);
                return false;
            }
        }

        // Check each row
        for (int y = 0; y < data[0].length; y++) {
            int rTotal = 0;
            for (int[] datum : data) {
                rTotal += datum[y];
            }

            if (xTotal == -1) {
                xTotal = rTotal;
                if (xTotal != yTotal) {
                    System.out.printf("Row total (%d) is not same as column total (%d)\n", xTotal, yTotal);
                    return false;
                }
            }
            if (rTotal != xTotal) {
                System.out.printf("Row %d has a total of %d when %d was expected\n", y, rTotal, xTotal);
                return false;
            }
        }

        int left = 0, right = 0;

        for (int i = 0; i < data.length; i++) {
            left += data[i][i];
            right += data[data.length - 1 - i][i];
        }

        if (left != right || left != xTotal) {
            System.out.printf("Left Diagonal (%d) and Right Diagonal (%d) do not match %d \n", left, right, xTotal);
            return false;
        }

        return true;
    }

    public void generate() {
        if (magic < 34)
            throw new IllegalArgumentException("MagicValue must be greater than 34");
        boxes = new int[][]{{8, 11, 14, 1}, {13, 2, 7, 12}, {3, 16, 9, 6}, {10, 5, 4, 15}};
        magic -= 34;
        int quotient = magic / 4;
        int remainder = magic % 4;

        for (int[] x : boxes) {
            for (int y = 0; y < x.length; y++) {
                x[y] += quotient + ((x[y] >= 13 && x[y] <= 16) ? remainder : 0);
            }
        }
    }

    /**
     * Draws the title centered and at height / 10
     */
    public void drawTitle() {
        drawCentered("CSC 142 Magic Square", width / 2, height / 10);
    }

    /**
     * Draws empty boxes
     */
    public void drawBoxes() {
        int pw = width / (boxes.length + 2), ph = height / (boxes[0].length + 2);
        for (int x = 0; x < boxes.length; x++) {
            for (int y = 0; y < boxes[x].length; y++) {
                int x1 = (x + 1) * pw, y1 = (y + 1) * ph;
                g.drawRect(x1, y1, pw, ph);

                System.out.printf("%d, %d %d, %d\n", x1, y1, x1 + pw, y1 + pw);
            }
        }
    }

    /**
     * Fills in hard-coded numbers
     */
    public void drawNumbers() {
        int pw = width / (boxes.length + 2), ph = height / (boxes[0].length + 2);
        for (int x = 0; x < boxes.length; x++) {
            for (int y = 0; y < boxes[x].length; y++) {
                drawCentered(boxes[x][y] + "", (x + 2) * pw - pw / 2, (y + 2) * ph - ph / 2);
            }
        }
    }

    /**
     * Draws the specified string horizontally centered
     *
     * @param str String to draw
     * @param x   X coord to draw @
     * @param y   Y coord to draw @
     */
    private void drawCentered(String str, int x, int y) {
        FontMetrics metrics = g.getFontMetrics();
        g.drawString(str, x - (metrics.stringWidth(str) / 2), y);
    }


}
