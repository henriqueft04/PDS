package ex3;

public abstract class Produto {

    private String nome;
    private double peso;
    static int identation = 0;

    public Produto(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public int getIdentation() {
        return identation;
    }

    static protected void addIdentation() {
        identation++;
    }

    static protected void removeIdentation() {
        identation--;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < Produto.identation; i++) {
            result += "   ";
        }
        return result;
    }

    public void draw() {
        System.out.println(this.toString());
    }
}
