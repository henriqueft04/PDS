package lab09.ex2;

import java.util.Set;
import java.util.HashSet;

public class SocialSecurity {
    public static Set<Person> contributors = new HashSet<>();

    public static boolean regist(Person p) {
        if (contributors.contains(p)) return false;
        contributors.add(p);
        return true;
    }

    public static String _toString() {
        String res = "Contributors:\n";
        for (Person p : contributors) {
            res += "\t" + p.getName() + " " + p.getWage() + "\n";
        }
        return res;
    }
}
