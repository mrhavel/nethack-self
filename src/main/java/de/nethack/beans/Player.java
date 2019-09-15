package de.nethack.beans;

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
 */
public class Player extends Human {

    public Player(int x, int y, JPanel panel, JFrame frm) {
        super(x, y);
        Human me = this;
        frm.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // NOP
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w':
                        me.y -= FAKTOR;
                        break;
                    case 's':
                        me.y += FAKTOR;
                        break;
                    case 'a':
                        me.x -= FAKTOR;
                        break;
                    case 'd':
                        me.x += FAKTOR;
                        break;
                }
                panel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // NOP
            }
        });
    }
}
