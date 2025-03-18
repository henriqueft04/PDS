package ex1;

public class Cake {
   
    private String name;
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers; 
    private Cream midLayerCream; 
    private Cream topLayerCream; 
    private Topping topping; 
    private String message;

    public Cake(String name) {
        this.name = name;
        this.shape = Shape.Circle;
        this.cakeLayer = "";
        this.numCakeLayers = 0;
        this.midLayerCream = null;
        this.topLayerCream = null;
        this.message = "";
        this.topping = null;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public int getNumCakeLayers() {
        return this.numCakeLayers;
    }

    public void addCakeLayer() {
        this.numCakeLayers++;
    }

    public void addCreamLayer(Cream cream) {
        if (this.midLayerCream == null) {
            this.midLayerCream = cream;
        } else {
            this.topLayerCream = cream;
        }
    }

    public void addTopLayer(Cream cream) {
        this.topLayerCream = cream;
    }

    public Cream getTopLayerCream() {
        return this.topLayerCream;
    }

    public void addTopping(Topping topping) {
        this.topping = topping;
    }

    public Topping getTopping() {
        return this.topping;
    }

    public void addMessage(String m) {
        this.message = m;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        String msg = this.name + " cake with " + this.numCakeLayers + " layers";

        if (this.midLayerCream != null) {
            msg += " and " + this.midLayerCream + " cream";
        }

        msg += ", topped with ";

        if (this.topLayerCream != null) {
            msg += this.topLayerCream + " cream";
        }
        if (this.topping != null) {
            msg += " and " + this.topping;
        }

        msg += ". Message says: \"" + this.message + "\".";

        return msg;
    }
    

}
