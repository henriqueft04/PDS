public class Reservado implements LivroState {
    public void regista(Livro livro) {
        printError();
    }

    public void requesita(Livro livro) {
        printError();
    }

    public void devolve(Livro livro) {
        printError();
    }

    public void reserva(Livro livro) {
        printError();
    }

    public void cancelaReserva(Livro livro) {
        livro.setState(new Disponivel());
    }

    @Override
    public String toString() {
        return "Reservado";
    }

    private void printError() {
        System.err.println("Operação não disponível");
    }

}
