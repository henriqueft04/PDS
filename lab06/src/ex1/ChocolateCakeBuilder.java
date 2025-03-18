package ex1;

public class ChocolateCakeBuilder implements CakeBuilder {
    private Cake cake;

    @Override
    public void createCake() {
        cake = new Cake("Soft chocolate");  
        cake.setShape(Shape.Circle); 
        cake.addTopLayer(Cream.Whipped_Cream);   
        cake.addTopping(Topping.Fruit);  // Set a default topping
    }

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
        return;
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
    public Cake getCake() {
        return cake;
    }

}
