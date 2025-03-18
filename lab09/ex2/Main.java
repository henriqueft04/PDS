package lab09.ex2;

public class Main {
    public static void main(String[] args) {
        Company c = new Company("Google");
        Person p1 = new Person("Alice", Sex.F, 3500);
        Person p2 = new Person("Bob", Sex.M, 3700);
        Person p3 = new Person("Charlie", Sex.M, 2150);
        Person p4 = new Person("David", Sex.M, 4000);
        Person p5 = new Person("Eve", Sex.F, 3000);

        c.admitEmployee(p1);
        c.admitEmployee(p2);
        c.admitEmployee(p3);
        c.admitEmployee(p4);
        c.admitEmployee(p5);

        System.out.println(c);
        System.out.println(SocialSecurity._toString());
        System.out.println(Insurance._toString());
        System.out.println(Parking._toString());

    }
}
