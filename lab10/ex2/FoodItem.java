package ex2;

public class FoodItem {
    
    FoodType type;
    String name;
    int timeToCook;

    public FoodItem(FoodType type, String name, int timeToCook) {
        this.type = type;
        this.name = name;
        this.timeToCook = timeToCook;
    }

    public FoodType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getTimeToCook() {
        return timeToCook;
    }

    @Override
    public String toString() {
        return name;
    }
}
