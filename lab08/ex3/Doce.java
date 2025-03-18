package ex3;

public class Doce extends Produto {

    public Doce(String nome, double peso) {
        super(nome, peso);
    }

    public String toString() {
        return super.toString() + "Doce '" + getNome() + "' - Weight :" + getPeso() + "\n";
    }
}
