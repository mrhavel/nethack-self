package de.nethack.ui;

import de.nethack.World;
import de.nethack.beans.Human;
import de.nethack.exp.CollisionException;

import java.awt.*;
import java.util.Random;

/**
 *
 */
public class PaintedWorld implements Drawable {

    @Override
    public void draw(World wrld, Graphics g) throws CollisionException {

        for (Human h : wrld.getHumans()) {
            h.refresh();

            h.moveTo(
                    new Random().nextInt(wrld.getScreenX() - 1),
                    new Random().nextInt(wrld.getScreenY() - 1)
            );

            for (Human hu : wrld.getHumans()) {
                if (hu.equals(h))
                    continue;

                if (h.collide(hu.asPoint())) {
                    throw new CollisionException(h, hu);
                }
            }
            g.drawString(h.getIcon(), h.getX(), h.getY());
        }
    }
}
