package lab11.ex1;

public class Venda implements Estado{
    
    @Override
    public void beginLeilao(Produto produto) {
        System.err.println( "Produto " + produto.getDescricao() + " já foi vendido!" );
    }

    @Override
    public void terminaLeilao(Produto produto) {
        System.err.println( "Produto " + produto.getDescricao() + " já foi vendido!" );
    }
    
    @Override
    public void restock(Produto produto) {
        System.err.println( "Produto " + produto.getDescricao() + " já foi vendido!" );
    }

    @Override
    public void sell(Produto produto) {
        System.out.println("Produto " + produto.getDescricao() + " vendido");
        listaVendas.add(produto);
    }

    @Override
    public void bid(Produto produto, double value) {
        System.err.println( "Produto " + produto.getDescricao() + " já foi vendido!" );
    }
}
