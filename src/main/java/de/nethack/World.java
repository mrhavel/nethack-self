package de.nethack;

import de.nethack.beans.Human;
import de.nethack.exp.CollisionException;
import de.nethack.ui.Arena;
import de.nethack.ui.Drawable;
import de.nethack.ui.PaintedWorld;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class World
        extends JPanel {

    private JFrame frm = new JFrame();

    private long time = 150;
    private int screenX = 640;
    private int screenY = 480;

    private Drawable currentDrawable = new PaintedWorld();

    private Timer t = new Timer();

    private JPanel currentPanel;

    private HumanUtil util = new HumanUtil();
    private List<Human> humans = new ArrayList<>();

    public World() {
        // Nur eine Demo Menge von Humans
        for (int i = 0; i != 20; i++) {
            getHumans().add(util.createNew(getScreenX(), getScreenY()));
        }
        frm.setSize(getScreenX(), getScreenY());
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);
        frm.getContentPane().add(this);
        currentPanel = this;
        logic();
    }

    public static void main(String[] arg) {
        new World();
    }

    /**
     * Spielwelt
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        try {
            currentDrawable.draw(this, g);
        } catch (CollisionException exp) {
            currentDrawable = new Arena(exp.getAttacker(), exp.getDefend(), this);
        }
    }

    private void logic() {
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    currentPanel.repaint();
                } catch (Exception e) {
                    System.out.println("WHOOPS " + e.getMessage());
                }
            }
        }, time, 15);
    }

    /**
     * Call nach der Arena
     */
    public void warIsOver() {
        currentDrawable = new PaintedWorld();
    }

    public List<Human> getHumans() {
        return humans;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }
}
