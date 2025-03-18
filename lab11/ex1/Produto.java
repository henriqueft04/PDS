package lab11.ex1;
import java.util.ArrayList;
import java.util.List;

class Produto {

    private int codigo;
    private String descricao;
    private double preco_base;
    private Estado estado;
    private List<Observer> observers;
    private Boolean bid;

    public Produto(int codigo, String descricao, double preco_base) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco_base = preco_base;
        this.estado = new Stock();
        this.observers = new ArrayList<>();
        this.bid = false;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getPrecoBase() {
        return this.preco_base;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public Boolean getBid() {
        return this.bid;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }


    public void removeObserver(Cliente client) {
        this.observers.remove(client);
    }

    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this);
        }
    }

    public void bid(double value) {
        if (this.bid) {
            System.out.println("Produto " + this.descricao + " licitado por " + value);
            this.preco_base = value;
            return;
        }
        this.bid = true;
        this.preco_base = value;
    }

    public void startLeilao(){
        this.estado.beginLeilao(this);
    }
    
}