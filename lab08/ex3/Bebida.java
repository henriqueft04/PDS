package ex3;

public class Bebida extends Produto {

    public Bebida(String nome, double peso) {
        super(nome, peso);
    }

    public String toString() {
        return super.toString() + "Bebida '" + getNome() + "' - Weight :" + getPeso() + "\n";
    }

}
