package de.nethack;

import de.nethack.beans.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class HumanUtil {

    private List<String> names;

    public HumanUtil() {
        names = new ArrayList<>();
        names.add("Dieter");
        names.add("Irmgard");
        names.add("Schorsch");
        names.add("Waldemar");
        names.add("Gisela");
        names.add("Jaqueline");
        names.add("Peter");
    }

    public String getName(int i) {
        try {
            return names.get(i);
        } catch (Exception e) {
            return "Chantalle";
        }
    }

    public Human createNew(int maxX, int maxY) {

        Human h = new Human(
                new Random().nextInt(maxX - 1),
                new Random().nextInt(maxY - 1));

        h.setName(getName(new Random().nextInt(names.size())));
        return h;
    }
}
