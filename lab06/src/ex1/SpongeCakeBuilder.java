package ex1;

public class SpongeCakeBuilder implements CakeBuilder {
    private Cake cake;
    
    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }
    
    @Override
    public void addCakeLayer() {
        cake.addCakeLayer();
    }
    
    @Override
    public void addCreamLayer() {
        cake.addCreamLayer(Cream.Red_Berries);
    }
    
    @Override
    public void addTopLayer() {
        cake.addTopLayer(Cream.Whipped_Cream);
    }
    
    @Override
    public void addTopping() {
        cake.addTopping(Topping.Fruit);
    }
    
    @Override
    public void addMessage(String m) {
        cake.addMessage(m);
    }
    
    @Override
    public void createCake() {
        cake = new Cake("Sponge");
        cake.setShape(Shape.Circle);
        cake.addTopLayer(Cream.Whipped_Cream);
        cake.addTopping(Topping.Fruit);

    }

    @Override
    public Cake getCake() {
        return cake;
    }
}