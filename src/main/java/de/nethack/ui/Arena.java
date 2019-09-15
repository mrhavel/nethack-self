package de.nethack.ui;

import de.nethack.World;
import de.nethack.beans.Human;

import java.awt.*;

/**
 * Fight!!11
 */
public class Arena implements Drawable {

    private Human attacker;
    private Human defender;
    private World world;

    public Arena(Human attacker, Human defender, World world) {
        this.attacker = attacker;
        this.defender = defender;
        this.world = world;
        System.out.println(attacker.getName() + " vs " + defender.getName());
    }

    @Override
    public void draw(World wld, Graphics g) {
        g.drawString(attacker.getName() + " vs. " + defender.getName(), 20, 10);

        world.warIsOver();

    }
}
