package xyz.msws.csc.wk10;

import java.awt.*;

public class Line {
    private Point a, b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getP1() {
        return a;
    }

    public Point getP2() {
        return b;
    }

    public String toString() {
        return String.format("[(%d, %d), (%d, %d)]", a.x, a.y, b.x, b.y);
    }
}