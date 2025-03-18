package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AdvancedPrinter implements AdvancedPrinterInterface {

    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ExecutorService.html
    class PrinterService implements Runnable {
        private final LinkedBlockingQueue<PrintJob> printQueue;
        private final ExecutorService pool;
     
        // este serviço simula a fila de impressão e a impressão de um documento de cada vez
        public PrinterService() {
                printQueue = new LinkedBlockingQueue<>();
                pool = Executors.newFixedThreadPool(1);
        }
     
        public void run() { // run the service
            try {
                for (;;) {
                    PrintJob j = printQueue.take();
                    pool.submit(j).get();
                }
            } catch (java.util.concurrent.RejectedExecutionException ex) {
                System.out.println("Job rejected by spool: service shutting down?");
            } catch (ExecutionException e) {
                System.out.println("Error");
                e.printStackTrace();
            } catch (InterruptedException ex) {
            this.shutdownAndAwaitTermination();
            }
        }

        public int newPrintJob(Document doc) {
            // Create PrintJob
            PrintJob job = new PrintJob(doc);
            // Add to queue
            printQueue.add(job);
            return job.getId();
        }

        public boolean cancelJob(int job) {
            // Get all jobs
            List<PrintJob> jobs = new ArrayList<>(printQueue);
            for (PrintJob j : jobs) {
                if (j.getId() == job) {
                    printQueue.remove(j);
                    return true;
                }
            }
            return false;
        }
    
        void shutdownAndAwaitTermination() {
            pool.shutdown(); // Disable new tasks from being submitted
            try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Spool did not terminate.");
            }
            } catch (InterruptedException ie) {
                // (Re-)Cancel if current thread also interrupted
                pool.shutdownNow();
                printQueue.clear();
                // Preserve interrupt status
                Thread.currentThread().interrupt();
            }
        }

        public LinkedBlockingQueue<PrintJob> getPrintQueue() {
            return printQueue;
        }

    }

    private PrinterService spool;

    public AdvancedPrinter() {
        this.spool = new PrinterService();
        new Thread(this.spool).start();
    }

    public int print(Document doc) {
        System.out.println("Spooling 1 documents");
        return this.spool.newPrintJob(doc);
    }

    public List<Integer> print(List<Document> docs) {
        System.out.println("Spooling " + docs.size() + " documents");
        List<Integer> jobs = new ArrayList<>();
        for (Document doc : docs) {
            jobs.add(this.spool.newPrintJob(doc));
        }
        return jobs;
    }

    public void showQueuedJobs() {
        if (this.spool.getPrintQueue().isEmpty()) {
            System.out.println("No spooled jobs.");
            return;
        }

        System.out.println("Spooled jobs:");
        for (PrintJob job : this.spool.getPrintQueue()) {
            System.out.println("  * Job " + job.getId() + ": \"" + job.getDocument().getResume() + "\"");
        }

        System.out.println();
    }

    public boolean cancelJob(int jobId) {
        Document doc;
        for (PrintJob job : this.spool.getPrintQueue()) {
            if (job.getId() == jobId) {
                doc = job.getDocument();
                if (this.spool.cancelJob(jobId)) {
                    System.out.println("Cancelled Job " + jobId + ": " + doc.getFilename());
                    return true;
                }
            }
        }

        return false;
    }

    public void cancelAll() {
        // Shutdown the spool
        this.spool.shutdownAndAwaitTermination();

        this.spool.getPrintQueue().clear();
    }

}
