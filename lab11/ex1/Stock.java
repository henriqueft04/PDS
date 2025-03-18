package lab11.ex1;
// import thread
import java.lang.Thread;

public class Stock implements Estado {


    @Override
    public void beginLeilao(Produto produto) {
        System.out.println("Produto " + produto.getDescricao() + " posto em leilão");
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    produto.getEstado().terminaLeilao(produto);
                } catch (InterruptedException e) {
                    System.out.println("Erro na thread");
                }
            }
        });
        
        thread.start();
        produto.setEstado(new Leilao());
        produto.notifyObservers();
    }

    @Override
    public void terminaLeilao(Produto produto) {
        System.err.println("Produto " + produto.getDescricao() + " não está em leilão");
    }
    
    @Override
    public void restock(Produto produto) {
        System.err.println("Produto " + produto.getDescricao() + " já está em stock");
    }

    @Override
    public void sell(Produto produto) {
        System.err.println("Produto " + produto.getDescricao() + " não está em leilão");
    }

    @Override
    public void bid(Produto produto, double value) {
        System.err.println("Produto " + produto.getDescricao() + " não está em leilão");
    }

}
