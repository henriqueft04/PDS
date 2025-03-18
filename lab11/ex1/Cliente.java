package lab11.ex1;

public class Cliente implements Observer{
    
    private String nome;
    
    public Cliente(String nome){
        this.nome = nome;
    }
    
    @Override
    public void update(Produto produto) {
        System.out.println("Cliente " + this.nome + " foi notificado que o produto " + produto.getDescricao() + " sofreu alteraçõs no estado");
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public void licitar( Produto produto, double valor){
        produto.getEstado().bid(produto, valor);
    }
}
