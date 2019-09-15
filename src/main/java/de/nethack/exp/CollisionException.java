package de.nethack.exp;

import de.nethack.beans.Human;

public class CollisionException extends Exception {

    private Human attacker;
    private Human defend;

    public CollisionException(Human attacker, Human defender) {
        this.attacker = attacker;
        this.defend = defender;
    }

    public Human getAttacker() {
        return attacker;
    }

    public void setAttacker(Human attacker) {
        this.attacker = attacker;
    }

    public Human getDefend() {
        return defend;
    }

    public void setDefend(Human defend) {
        this.defend = defend;
    }
}
