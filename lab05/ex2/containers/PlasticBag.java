package ex2.containers;
import ex2.Portion;
import ex2.State;
import ex2.Temperature;

public class PlasticBag extends Container{
    
    private Temperature temperature;
    private State state;

    public PlasticBag(Portion portion) {

        this.temperature = Temperature.COLD;
        this.state = State.Liquid;
        this.type = "PlasticBag";
        this.portion = portion;
    }

    public Temperature getTemperature() {
        return this.temperature;
    }

    public State getState() {
        return this.state;
    }

}
