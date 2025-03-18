package lab09.ex2;

import java.util.Set;
import java.util.HashSet;

public class Parking {
    public static Set<Person> allowedPeople = new HashSet<>();

    public static boolean allow(Person p) {
        if (allowedPeople.contains(p)) return false;
        allowedPeople.add(p);
        return true;
    }

    public static String _toString() {
        String res = "Allowed people:\n";
        for (Person p : allowedPeople) {
            res += "\t" + p.getName() + " " + p.getWage() + "\n";
        }
        return res;
    }
}
