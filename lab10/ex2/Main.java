package ex2;

public class Main {
    
    public static void main(String[] args) {
    
        FoodItem veggie = new FoodItem(FoodType.BURGER, "veggie burger", 19);
        FoodItem carbonara = new FoodItem(FoodType.PASTA, "Pasta Carbonara", 14);
        FoodItem plainPizza =  new FoodItem(FoodType.PIZZA, "PLAIN pizza, no toppings!", 7);
        FoodItem nigir = new FoodItem(FoodType.SUSHI, "sushi nigiri and sashimi", 14);
        FoodItem salad = new FoodItem(FoodType.SALAD, "salad with tuna", 14);
        FoodItem dessert = new FoodItem(FoodType.DESSERT, "chocolate cake strawberry ice cream and waffles dessert", 17);

        new ClientOrder(veggie);
        new ClientOrder(carbonara);
        new ClientOrder(plainPizza);
        new ClientOrder(nigir);
        new ClientOrder(salad);
        new ClientOrder(dessert);
    }
}
