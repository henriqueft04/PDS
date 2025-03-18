package ex1;

public class Taxi extends Automovel {
    public String nLicenca;

    public Taxi(String matricula, String marca, String modelo, int potencia, String quadro, int capacidade, String nLicenca) {
        super(matricula, marca, modelo, potencia, quadro, capacidade);
        setnLicenca(nLicenca);
    }

    public String getnLicenca() {
        return nLicenca;
    }

    public void setnLicenca(String nLicenca) {
        this.nLicenca = nLicenca;
    }
}
