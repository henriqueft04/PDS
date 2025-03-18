package lab11.ex1;
import java.util.ArrayList;
import java.util.List;

public interface Estado {
    
    public void beginLeilao(Produto produto);
    public void terminaLeilao(Produto produto);
    public void restock (Produto produto);
    public void sell(Produto produto);
    public void bid(Produto produto, double value);

    public List<Produto> listaVendas = new ArrayList<>();
}
