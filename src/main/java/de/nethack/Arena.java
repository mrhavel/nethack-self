package de.nethack;

import javax.swing.*;
import java.awt.*;

/**
 * Fight!!11
 */
public class Arena extends JPanel {

    private Human attacker;
    private Human defender;
    private World world;

    public Arena(Human attacker, Human defender, World world) {
        this.attacker = attacker;
        this.defender = defender;
        this.world = world;
    }

    @Override
    public void paint(Graphics g) { // Display Humans
        super.paint(g);


    }

    public void over() {
        world.warIsOver();
    }
}
