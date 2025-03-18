package ex3;

import java.util.List;
import java.util.ArrayList;

public class Caixa extends Produto{
    
    private List<Produto> produtos; 

    public Caixa(String nome, double peso) {
        super(nome, peso);
        this.produtos = new ArrayList<Produto>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void add(Produto produto) {
        this.produtos.add(produto);
    }

    public double pesoTotal() {
        double pesoTotal = super.getPeso();
        for (Produto produto : produtos) {
            pesoTotal += produto.getPeso();
        }
        return pesoTotal;
    } 

    public String toString() {
        
        String result = super.toString() + "* Caixa '" + super.getNome() + "' [ Weight : " + super.getPeso() + " ; Total: " + pesoTotal() + "]\n";
        super.addIdentation();
        for (Produto produto : produtos) {
            result += produto.toString();
        }
        super.removeIdentation();
        return result;
    }
}
