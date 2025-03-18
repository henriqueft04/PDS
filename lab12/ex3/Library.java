import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Library {
    private static List<Livro> books = new ArrayList<Livro>();
    public static void main(String[] args) {
        books.add(new Livro("Java Anti-Stress", "Omodionah"));
        books.add(new Livro("A Guerra dos Padrões", "Jorge Omel"));
        books.add(new Livro("A procura da Luz", "Khumatkli"));

        Scanner sc = new Scanner(System.in);
        int book = 0;
        int option = 0;

        while (true) {
            printBooks();

            String input = sc.nextLine();
            String[] _input = input.split(",");
            book = Integer.parseInt(_input[0]);
            option = Integer.parseInt(_input[1]);
            

            switch (option) {
                case 1:
                    books.get(book - 1).regista();
                    break;
                case 2:
                    books.get(book - 1).requesita();
                    break;
                case 3:
                    books.get(book - 1).devolve();
                    break;
                case 4:
                    books.get(book - 1).reserva();
                    break;
                case 5:
                    books.get(book - 1).cancelaReserva();
                    break;
                default:
                    System.err.println("Opção inválida");
            }
            System.out.println();
        }


    }

    public static void printBooks() {
        int i = 1;
        System.out.println("*** Biblioteca ***");
        for (Livro book : books) {
            System.out.println("" + i + "\t" + book);
            i++;
        }

        System.out.print(">> <livro> <operação: (1)regista; (2)requesita; (3)devolve; (4)reserva; (5)cancela>\n\n>> ");
    }
}
