package ex2.containers;

import ex2.Portion;
import ex2.Temperature;
import ex2.comidinhas.FruitJuice;

public class Container {
    
    protected String type;
    protected Portion portion;

    public static Container create(Portion portion){
        Container container = null;
        switch (portion.getType()){
            case "Tuna" -> container = new PlasticBag(portion);
            case "Pork" -> container = new Tupperware(Temperature.WARM, portion);
            case "Milk" -> container = new TermicBottle(Temperature.WARM, portion);
            case "FruitJuice" -> container = new PlasticBottle(portion);
            default -> System.err.println("Invalid food or temperature");
        }
        return container;
    }

    public String getType() {
        return this.type;
    }

    public String toString(){
        if (!portion.getType().equals("FruitJuice"))
            return this.getType() + " with portion = " + portion.toString();
        else{
            return this.getType() + " with portion = " + portion.toString();
        }

    }

}
