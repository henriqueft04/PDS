public class Disponivel implements LivroState {
    public void regista(Livro livro) {
        printError();
    }

    public void requesita(Livro livro) {
        livro.setState(new Emprestado());
    }

    public void devolve(Livro livro) {
        printError();
    }

    public void reserva(Livro livro) {
        livro.setState(new Reservado());
    }

    public void cancelaReserva(Livro livro) {
        printError();
    }

    @Override
    public String toString() {
        return "Disponivel";
    }

    private void printError() {
        System.err.println("Operação não disponível");
    }
}
