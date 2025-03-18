package ex2;

public enum FoodType {
    PIZZA, BURGER, PASTA, SUSHI, DESSERT, SALAD;

    public String toString() {
        return switch (this) {
            case PIZZA -> "Pizza";
            case BURGER -> "Burger";
            case PASTA -> "Pasta";
            case SUSHI -> "Sushi";
            case DESSERT -> "Dessert";
            case SALAD -> "Salad";
        };
    }

}



