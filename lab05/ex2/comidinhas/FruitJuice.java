package ex2.comidinhas;

import ex2.Portion;
import ex2.State;
import ex2.Temperature;

public class FruitJuice implements Portion {
    
    private State state;
    private Temperature temperature;
    private String fruitName;
    private String type;

    public FruitJuice(String fruitName) {
        this.fruitName = fruitName;
        this.temperature = Temperature.COLD;
        this.state = State.Solid;
        this.type = "FruitJuice";
    }

    public Temperature getTemperature() {
        return this.temperature;
    }

    public State getState() {
        return this.state;
    }

    public String getFruitName() {
        return this.fruitName;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "FruitJuice: " + this.fruitName + ", Temperature " + this.temperature + ", State " + this.state; 
    }

}
