package ex2;
import ex2.comidinhas.*;

public class PortionFactory {
   
    public static Portion create(String food, Temperature temperature){
        Portion portion = null;
        switch (food+temperature.name()){
            case "MeatCOLD" -> portion = new Tuna();
            case "MeatWARM" -> portion = new Pork();
            case "BeverageWARM" -> portion = new Milk();
            case "BeverageCOLD" -> portion = new FruitJuice("Orange");
            default -> System.err.println("Invalid food or temperature");
        }
        return portion;
    }
}
