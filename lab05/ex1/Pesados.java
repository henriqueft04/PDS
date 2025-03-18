package ex1;

public abstract class Pesados extends Veiculo {
    private String nQuadro;
    private int peso;

    public Pesados(String matricula, String marca, String modelo, int potencia, String quadro, int peso) {
        super(matricula, marca, modelo, potencia);
        setnQuadro(quadro);
        setPeso(peso);
    }

    public String getnQuadro() {
        return nQuadro;
    }

    public void setnQuadro(String nQuadro) {
        this.nQuadro = nQuadro;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
