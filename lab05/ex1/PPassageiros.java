package ex1;

public class PPassageiros extends Pesados {
    private int maxPassageiros;

    public PPassageiros(String matricula, String marca, String modelo, int potencia, int peso, String quadro, int maxPassageiros) {
        super(matricula, marca, modelo, potencia, quadro, peso);
        setMaxPassageiros(maxPassageiros);
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }
}
