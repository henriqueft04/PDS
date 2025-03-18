package ex2.comidinhas;

import ex2.Portion;
import ex2.State;
import ex2.Temperature;

public class Milk implements Portion{
    
    private Temperature temperature;
    private State state;
    private String type;

    public Milk() {

        this.temperature = Temperature.WARM;
        this.state = State.Liquid;
        this.type = "Milk";
    }

    public Temperature getTemperature() {
        return this.temperature;
    }

    public State getState() {
        return this.state;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "Milk: Temperature " + this.temperature + ", State " + this.state;
    }

}
