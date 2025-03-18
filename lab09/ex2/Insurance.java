package lab09.ex2;

import java.util.Set;
import java.util.HashSet;

public class Insurance {
    public static Set<Person> insuredPeople = new HashSet<>();

    public static boolean regist(Person p) {
        if (insuredPeople.contains(p)) return false;
        insuredPeople.add(p);
        return true;
    }

    public static String _toString() {
        String res = "Insured people:\n";
        for (Person p : insuredPeople) {
            res += "\t" + p.getName() + " " + p.getWage() + "\n";
        }
        return res;
    }
}
