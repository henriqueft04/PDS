package ex2.comidinhas;

import ex2.Portion;
import ex2.State;
import ex2.Temperature;

public class Pork implements Portion{
    
    private Temperature temperature;
    private State state;
    private String type;

    public Pork() {
 
        this.temperature = Temperature.WARM;
        this.state = State.Solid;
        this.type = "Pork";
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
        return "Pork: Temperature " + this.temperature + ", State " + this.state;
    }

}