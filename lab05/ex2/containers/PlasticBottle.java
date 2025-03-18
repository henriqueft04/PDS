package ex2.containers;
import ex2.Portion;
import ex2.State;
import ex2.Temperature;

public class PlasticBottle extends Container{
    
    private Temperature temperature;
    private State state;

    public PlasticBottle(Portion portion) {

        this.temperature = Temperature.COLD;
        this.state = State.Liquid;
        this.type = "PlasticBottle";
        this.portion = portion;

    }

    public Temperature getTemperature() {
        return this.temperature;
    }

    public State getState() {
        return this.state;
    }

}
