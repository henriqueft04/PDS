class CoffeeSugarDecorator extends CoffeeDecorator {
    public CoffeeSugarDecorator(Coffee coffee){
        super(coffee);
    }

    public void drink(){
        coffee.drink();
    }

    public void decorate(){
        coffee.decorate("sugar");
    }
}
