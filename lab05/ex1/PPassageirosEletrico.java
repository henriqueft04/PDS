package ex1;

public class PPassageirosEletrico extends PPassageiros implements VeiculoEletrico {
    private int autonomia = 0;
    private int consumo = 0;

    public PPassageirosEletrico(String matricula, String marca, String modelo, int autonomia, int potencia, String quadro, int peso, int consumo, int maxPassageiros) {
        super(matricula, marca, modelo, potencia, peso, quadro, maxPassageiros);
        carregar(autonomia);
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
