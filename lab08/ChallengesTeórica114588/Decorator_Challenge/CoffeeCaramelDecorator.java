class CoffeeCaramelDecorator extends CoffeeDecorator{
    public CoffeeCaramelDecorator(Coffee coffee){
        super(coffee);
    }

    public void drink(){
        coffee.drink();
    }

    public void decorate(){
        coffee.decorate("caramel");
    }
}