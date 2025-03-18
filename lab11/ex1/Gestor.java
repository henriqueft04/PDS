package lab11.ex1;

public class Gestor implements Observer {
    
    private String nome;
    
    public Gestor(String nome){
        this.nome = nome;
    }
    
    @Override
    public void update(Produto produto) {
        System.out.println("Gestor " + this.nome + " foi notificado que o produto " + produto.getDescricao() + " está disponível");
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public void addObserver(Produto produto){
        produto.addObserver(this);
    }

}
