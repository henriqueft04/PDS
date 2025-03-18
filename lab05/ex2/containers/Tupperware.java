package ex2.containers;
import ex2.State;
import ex2.Temperature;
import ex2.Portion;

public class Tupperware extends Container{

    private Temperature temperature;
    private State state;

    public Tupperware(Temperature temperature, Portion portion) {

        this.temperature = temperature;
        this.state = State.Solid;
        this.type = "Tupperware";
        this.portion = portion;
    }

    public Temperature getTemperature() {
        return this.temperature;
    }

    public State getState() {
        return this.state;
    }

}
