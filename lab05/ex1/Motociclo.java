package ex1;

enum Tipo {
    DESPORTIVO,
    ESTRADA
}

public class Motociclo extends Veiculo {
    private Tipo tipo;

    Motociclo(String matricula, String marca, String modelo, int potencia, Tipo tipo) {
        super(matricula, marca, modelo, potencia);
        setTipo(tipo);
    }

    public void setTipo(Tipo tipo) {
        if (tipo == null) return;
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
