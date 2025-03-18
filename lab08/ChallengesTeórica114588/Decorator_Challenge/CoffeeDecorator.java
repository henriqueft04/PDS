class CoffeeDecorator implements CoffeeInterface{
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    public void drink(){
        coffee.drink();
    }

    public void decorate(String decoration){
        coffee.decorate(decoration);
    }
}