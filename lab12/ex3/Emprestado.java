public class Emprestado implements LivroState {
    public void regista(Livro livro) {
        printError();
    }

    public void requesita(Livro livro) {
        printError();
    }

    public void devolve(Livro livro) {
        livro.setState(new Disponivel());
    }

    public void reserva(Livro livro) {
        printError();
    }

    public void cancelaReserva(Livro livro) {
        printError();
    }

    @Override
    public String toString() {
        return "Emprestado";
    }

    private void printError() {
        System.err.println("Operação não disponível");
    }
}
