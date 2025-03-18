package ex2;

public class ClientOrder {
    
    String order;
    FoodItem item;

    public ClientOrder(FoodItem item) {
        this.item = item;
        System.out.println("Can I please get a %s?".formatted(item.getName()));
        
        ChefMiddleware chef = ChefMiddleware.link(
            new SushiChef(),
            new PastaChef(),
            new BurgerChef(),
            new PizzaChef(),
            new DessertChef()
        );

        chef.handleOrder(item);
    }


}
