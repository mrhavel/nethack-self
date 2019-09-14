package de.nethack;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.*;

/**
 *
 */
public class World
        extends JPanel {

    private JFrame frm = new JFrame();

    private long time = 150;
    private int screenX = 640;
    private int screenY = 480;

    private HumanUtil util = new HumanUtil();
    private List<Human> humans = new ArrayList<>();

    public World() {
        for (int i = 0; i != 20; i++) {
            humans.add(util.createNew(screenX, screenY));
        }
    }

    /**
     * Spielwelt
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Human h : humans) {
            h.refresh();

            for (Human hu : humans) {
                if (hu.equals(h))
                    continue;

                if (h.collide(hu.asPoint())) {
                    frm.getContentPane().add(new Arena(h, hu, this));
                    break;
                }
            }

            h.moveTo(
                    new Random().nextInt(screenX - 1),
                    new Random().nextInt(screenY - 1)
            );

            g.drawString(h.getIcon(), h.getX(), h.getY());
        }
    }

    /**
     * Vorbereitung des JFrames
     */
    public void gameScreen() {
        frm.setSize(screenX, screenY);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);
        frm.getContentPane().add(this);
        logic();
    }


    public void logic() {
        JPanel upperRef = this;
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                upperRef.repaint();
            }
        }, time, 15);

    }

    /**
     * Call nach der Arena
     */
    public void warIsOver() {
        frm.getContentPane().removeAll();
        frm.getContentPane().add(this);
    }


    public static void main(String[] arg) {
        World gs = new World();
        gs.gameScreen();
    }

}
