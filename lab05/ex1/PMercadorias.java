package ex1;

public class PMercadorias extends Pesados {
    private int cargaMaxima;

    public PMercadorias(String matricula, String marca, String modelo, int potencia, String quadro, int peso, int cargaMaxima) {
        super(matricula, marca, modelo, potencia, quadro, peso);
        setCargaMaxima(cargaMaxima);
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }
}
