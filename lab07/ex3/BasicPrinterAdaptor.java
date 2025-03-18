package ex3;
import java.util.ArrayList;
import java.util.List;

public class BasicPrinterAdaptor implements AdvancedPrinterInterface{
    
    private BasicPrinter basicPrinter;
    private List<Document> docs;
    private List<PrintJob> jobs;

    public BasicPrinterAdaptor(BasicPrinter basicPrinter) {
        this.basicPrinter = basicPrinter;
        this.docs = new ArrayList<>();
        this.jobs = new ArrayList<>();
    }

    @Override
    public int print(Document doc) {
        //passar o doc para array de strings
        if (basicPrinter.hasInk() && basicPrinter.hasPaper()) {
            String[] content = doc.readDocument();
            if (content != null) {
                if (basicPrinter.print(content)) {
                    PrintJob job = new PrintJob(doc);
                    jobs.add(job);
                    return 1;
                }
            }
        }
        else if (!basicPrinter.hasInk()){
            //System.out.println("Please refill printer's ink.");
            return -1;
        }
        else if (!basicPrinter.hasPaper()){
            //System.out.println("Please refill printer's paper.");
            return -1;
        }

        return -1;
    }

    @Override
    public void showQueuedJobs() {
        for (PrintJob job : jobs) {
            System.out.println("  * Job " + job.getId() + ": \"" + job.getDocument().getResume() + "\"");
        }
    }

    @Override
    public boolean cancelJob(int jobId) {
        
        for (PrintJob job : jobs) {
            if (job.getId() == jobId) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public void cancelAll() {
        jobs.clear();
    }

    @Override
    public List<Integer> print(List<Document> docs) {
        List<Integer> jobs = new ArrayList<>();
        for (Document doc : docs) {
            jobs.add(this.print(doc));
        }
        return jobs;
    }
}
