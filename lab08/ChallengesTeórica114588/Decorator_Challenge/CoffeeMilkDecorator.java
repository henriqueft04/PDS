public class CoffeeMilkDecorator extends CoffeeDecorator{
    public CoffeeMilkDecorator(Coffee coffee){
        super(coffee);
    }

    public void drink(){
        coffee.drink();
    }

    public void decorate(){
        coffee.decorate("milk");
    }
}
