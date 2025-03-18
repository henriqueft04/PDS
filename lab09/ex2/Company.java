package lab09.ex2;

import java.util.Set;
import java.util.HashSet;

public class Company {
    private String name;
    private Set<Person> workers = new HashSet<>();
    private Set<Card> workerCards = new HashSet<>();

    public Company(String companyName) {
        name = companyName;
    }

    public String getName() {
        return name;
    }

    public boolean addWorker(Person p) {
        if (workers.contains(p)) return false;
        workers.add(p);
        return true;
    }

    public boolean addWorkerCard(Card c) {
        if (workerCards.contains(c)) return false;
        workerCards.add(c);
        return true;
    }

    public void admitEmployee(Person p) {
        this.addWorker(p);
        SocialSecurity.regist(p);
        Insurance.regist(p);
        this.addWorkerCard(new Card(p));
        Parking.allow(p);
    }

    @Override
    public String toString() {
        String res = "Company " + name + "\n";
        res += "Workers:\n";
        for (Person p : workers) {
            res += "\t" + p.getName() + " " + p.getWage() + "\n";
        }
        return res;
    }
}
