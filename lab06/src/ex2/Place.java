package ex2;

public class Place {
    private final String name;
    private final String city;
    private final String country;

    public Place(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Place(String city, String country) {
        this.name = null;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        if (name == null) return city + ", " + country;
        return name + ", " + city + ", " + country;
    }
}
