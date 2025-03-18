package ex3;

public class Conserva extends Produto {

    public Conserva(String nome, double peso) {
        super(nome, peso);
    }

    public String toString() {

        return super.toString() + "Conserva '" + getNome() + "' - Weight :" + getPeso() + "\n";
    }

}
