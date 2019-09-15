package de.nethack.beans;

import java.awt.*;

/**
 * Erst mal ein hirnloser Spieler
 */
public class Human {

    protected String icon = "✌";
    protected int x;
    protected int y;

    private String name;
    protected final int FAKTOR = 1;

    private int target_x;
    private int target_y;

    public Human(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(int x, int y) {
        if (target_y == 0 && target_x == 0) {
            this.target_x = x;
            this.target_y = y;
        }
    }

    public void refresh() {
        if (this.target_x == x && this.target_y == y) {
            this.target_x = 0;
            this.target_y = 0;
        }

        if (this.x - target_x > 0) {
            x -= FAKTOR;
        } else if (this.x - target_x < 0) {
            x += FAKTOR;
        }

        if (this.y - target_y > 0) {
            y -= FAKTOR;
        } else if (this.y - target_y < 0) {
            y += FAKTOR;
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Point asPoint() {
        return new Point(x, y);
    }

    /**
     * Kollisionsüberprüfung
     *
     * @param p - Punkt eines Hindernisses
     * @return
     */
    public boolean collide(Point p) {
        boolean col = asPoint().equals(p);
        return col;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
