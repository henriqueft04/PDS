package ex1;

public class Automovel extends Veiculo {
    private String nQuadro;

    private int capacidade;

    Automovel(String matricula, String marca, String modelo, int potencia, String quadro, int capacidade) {
        super(matricula, marca, modelo, potencia);
        setnQuadro(quadro);
        setCapacidade(capacidade);
    }


    protected void setnQuadro(String nQuadro) {
        this.nQuadro = nQuadro;
    }

    public String getnQuadro() {
        return nQuadro;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
