package ex1;

public class CakeMaster {

    private CakeBuilder builder;
    private String msg;
    
    public void setCakeBuilder(CakeBuilder builder) {
        this.builder = builder;
    }

    public void createCake(String msg){
        this.msg = msg;
        builder.createCake();
        builder.addMessage(msg);
        builder.addCakeLayer();
    }

    public void createCake(Shape shape, int numCakeLayers, String msg){
        this.msg = msg;
        builder.createCake();
        builder.setCakeShape(shape);
        for(int i = 0; i < numCakeLayers; i++){
            builder.addCakeLayer();
        }
        builder.addMessage(msg);
    }

    public void createCake(int numCakeLayers, String msg){
        this.msg = msg;
        builder.createCake();
        for(int i = 0; i < numCakeLayers; i++){
            builder.addCakeLayer();
        }
        builder.addMessage(msg);
    }

    public Cake getCake(){
        return builder.getCake();
    }
}
