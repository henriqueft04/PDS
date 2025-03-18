package lab12.ex1;

import java.util.List;

public abstract class SortingAlgorithm {
    private SortingFilter sortingFilter;
    private SortingOrder sortingOrder;
    private List<Smartphone> smartphones;
    private SortingAlgorithm algorithm;


    public SortingAlgorithm(SortingFilter sortingFilter, SortingOrder sortingOrder, List<Smartphone> smartphones) {
        this.sortingFilter = sortingFilter;
        this.sortingOrder = sortingOrder;
        this.smartphones = smartphones;
        this.algorithm = null;
    }

    public void setAlgorithm(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public SortingAlgorithm getAlgorithm() {
        return algorithm;
    }

    public SortingFilter getSortingFilter() {
        return sortingFilter;
    }

    public SortingOrder getSortingOrder() {
        return sortingOrder;
    }

    public List<Smartphone> getSmartphones() {
        return smartphones;
    }

    public abstract void sort();

    public void printSmartphones() {
        System.out.println("Smartphones sorted by " + sortingFilter + " in " + sortingOrder + " order:");
        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone);
        }
        System.out.println("---------------------------------------------------------------");
    }
}