package xyz.msws.csc.drawing;

import java.awt.*;

public class Triangle {
    public static void main(String[] args) {
        final int width = 600, height = 600;
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();

        g.drawLine(0, 0, width, 0);
        g.setColor(Color.RED);
        for (int y = 20; y < width; y += 20) {
            g.drawLine(y / 2, y, width - y / 2, y);
        }

        g.setColor(Color.BLACK);
        g.drawLine(0, 0, width / 2, height);
        g.drawLine(width, 0, width / 2, height);

        g.drawString("Isaac Boaz", 50, 550);
    }
}
