package ex1;

public class AutomovelEletrico extends Automovel implements VeiculoEletrico {
    private int autonomia = 0;
    private int consumo = 0;

    AutomovelEletrico(String matricula, String marca, String modelo, int autonomia, String quadro, int potencia, int consumo, int capacidade) {
        super(matricula, marca, modelo, potencia, quadro, capacidade);
        carregar(capacidade);
        setConsumo(consumo);
    }

    public int getConsumo() {
        return this.consumo;
    }

    private void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int autonomia() {
        return this.autonomia;
    }

    public void carregar(int percentagem) {
        this.autonomia += percentagem;
    }
}
