package ex2.containers;
import ex2.State;
import ex2.Temperature;
import ex2.Portion;

public class TermicBottle extends Container{

    private Temperature temperature;
    private State state;

    public TermicBottle(Temperature temperature, Portion portion) {

        this.temperature = temperature;
        this.state = State.Liquid;
        this.type = "TermicBottle";
        this.portion = portion;
    }

    public Temperature getTemperature() {
        return this.temperature;
    }

    public State getState() {
        return this.state;
    }
    
}
