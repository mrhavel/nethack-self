package de.nethack;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 * Humans kill Players kill Humans kill Players kill
 *
 */
public class Player extends Human {

    private JPanel upperRef;
    private JFrame frm;

    public Player(int x, int y, JPanel panel, JFrame frm) {
        super(x, y);
        this.upperRef = panel;
        this.frm = frm;
    }

    /**
     * Falls wir einen Spieler haben, vewergt er sich hier
     */
    public void playerMove() {

        frm.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w':
                        y -= FAKTOR;
                        break;
                    case 's':
                        y += FAKTOR;
                        break;
                    case 'a':
                        x -= FAKTOR;
                        break;
                    case 'd':
                        x += FAKTOR;
                        break;
                }

                upperRef.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

}
