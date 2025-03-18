package lab09.ex2;

public class Person {
    private String name;
    private Sex sex;
    private double wage;

    public Person(String name, Sex sex, double wage) {
        this.name = name;
        this.wage = wage;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double _wage) {
        wage = _wage;
    }
}
