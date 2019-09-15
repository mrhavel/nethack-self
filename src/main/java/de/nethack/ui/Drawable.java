package de.nethack.ui;

import de.nethack.World;
import de.nethack.exp.CollisionException;

import java.awt.*;

public interface Drawable {

    void draw(World wld, Graphics g) throws CollisionException;
}
