package ex2.comidinhas;

import ex2.Portion;
import ex2.State;
import ex2.Temperature;

public class Tuna implements Portion{
    
    private Temperature temperature;
    private State state;
    private String type;

    public Tuna() {

        this.temperature = Temperature.COLD;
        this.state = State.Solid;
        this.type = "Tuna";
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
        return "Tuna: Temperature " + this.temperature + ", State " + this.state;
    }
}
