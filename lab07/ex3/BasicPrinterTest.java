package ex3;
import java.util.ArrayList;
import java.util.List;

public class BasicPrinterTest {

    private static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Instanciando o BasicPrinter e o BasicPrinterAdaptor
        BasicPrinter basicPrinter = new BasicPrinter();
        AdvancedPrinterInterface p = new BasicPrinterAdaptor(basicPrinter);

        List<Document> docs = new ArrayList<Document>();
        docs.add(new Document("text1.txt"));
        docs.add(new Document("text2.txt"));
        docs.add(new Document("text3.txt"));

        // Imprimir o primeiro documento apenas
        System.out.println("Spooling 1 documents.");
        p.print(docs.get(0));   
        pause(2000);  // Aguarda um pouco

        // Imprimir todos os documentos e mostrar trabalhos na fila
        System.out.println("Spooling 3 documents.");
        p.print(docs);
        p.showQueuedJobs();
        pause(4000);  // Aguarda um pouco

        // Imprimir novamente todos os documentos e tentar cancelar um trabalho específico
        p.print(docs);
        p.cancelJob(6);
        System.out.println("Cancelled Job 6: \"" + docs.get(2).getResume() + "\"");
        p.showQueuedJobs();
        pause(4000);  // Aguarda um pouco

        // Imprimir todos os documentos e cancelar todos os trabalhos
        p.print(docs);
        p.cancelAll();
        System.out.println("Spooling 3 documents.");
        p.showQueuedJobs();
        pause(2000);  // Aguarda um pouco
    }
}
