package ex3;

public class PrintJob implements Runnable {
    static int nextId = 0;

    private Document doc;
    private int id;

    public PrintJob(Document doc) {
        this.doc = doc;
        this.id = PrintJob.nextId++;
    }

    public Document getDocument() {
        return doc;
    }

    public int getId() {
        return id;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Finished Job " + id + ": \"" + doc.getResume() + "\"");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
