package lab12.ex1;

public class Smartphone {
    
    private int memory;
    private double price;
    private String description;

    public Smartphone(int memory, double price, String description) {
        this.memory = memory;
        this.price = price;
        this.description = description;
    }

    public int getMemory() {
        return memory;
    }

    public double getPrice() {
        return price;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "memory=" + memory +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
