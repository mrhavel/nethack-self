package de.nethack;

import javax.swing.*;
import java.awt.*;

public class Arena extends JPanel {

    private Human attacker;
    private Human defender;

    public Arena(Human attacker, Human defender) {
        this.attacker = attacker;
        this.defender = defender;
    }


    @Override
    public void paint(Graphics g) { // Display Humans
        super.paint(g);
    }

}
