public class Livro {
    private LivroState state;

    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        state = new Inventario();
        this.titulo = titulo;
        this.autor = autor;
    }

    public void regista() {
        state.regista(this);
    }

    public void requesita() {
        state.requesita(this);
    }

    public void devolve() {
        state.devolve(this);
    }

    public void reserva() {
        state.reserva(this);
    }

    public void cancelaReserva() {
        state.cancelaReserva(this);
    }

    public void setState(LivroState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return titulo + "\t" + autor + "\t[" + state.toString() + "]";
    }
}
