package lab11.ex1;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "1", 10);
        Produto p2 = new Produto(2, " 2", 20);
        Cliente c1 = new Cliente("1");
        Cliente c2 = new Cliente("2");
        Cliente c3 = new Cliente("3");
        Gestor g1 = new Gestor("1");
        Gestor g2 = new Gestor(" 2");
        p1.addObserver(c1);
        p1.addObserver(c2);
        p1.addObserver(c3);
        p1.addObserver(g1);
        p1.addObserver(g2);
        p2.addObserver(c1);
        p2.addObserver(c2);
        p1.startLeilao();
        p2.startLeilao();
        p1.bid(5);
        p2.bid(10);
        p2.startLeilao();

    }
}
