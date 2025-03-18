package lab11.ex1;

public class Leilao implements Estado{
    
        @Override
        public void beginLeilao(Produto produto) {
            System.err.println("Produto " + produto.getDescricao() + " já está em leilão");
        }

        public void bid(Produto produto, double value) {
            System.out.println("Produto " + produto.getDescricao() + " licitado por " + value);
            produto.bid(value);
            produto.notifyObservers();
        }
    
        
        @Override
        public void terminaLeilao(Produto produto) {
            if (produto.getBid() == true) {
                System.out.println("Produto " + produto.getDescricao() + " terminou o leilão");
                this.sell(produto);
            } else {
                System.out.println("Produto " + produto.getDescricao() + " terminou o leilão sem licitações");
                this.restock(produto);
            }
            
            return;
        }
    
        @Override
        public void restock(Produto produto) {
            System.out.println("Produto " + produto.getDescricao() + " voltou para o stock");
            produto.setEstado(new Stock());
            produto.notifyObservers();
        }
    
        @Override
        public void sell(Produto produto) {
            System.out.println("Produto " + produto.getDescricao() + " vendido");
            listaVendas.add(produto);
            produto.notifyObservers();
            produto.setEstado(new Stock());
        }

        
}
