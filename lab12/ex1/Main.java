package lab12.ex1;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Smartphone> smartphone_list = new ArrayList<>();
        Smartphone[] smartphones = {
            new Smartphone(4, 1000, "Smartphone 1"),
            new Smartphone(8, 1500, "Smartphone 2"),
            new Smartphone(6, 1200, "Smartphone 3"),
            new Smartphone(2, 800, "Smartphone 4"),
            new Smartphone(12, 2000, "Smartphone 5")
        };

        for (Smartphone smartphone : smartphones) {
            smartphone_list.add(smartphone);
        }

        SortingAlgorithm sortingAlgorithm = new SelectionSortAlgorithm(SortingFilter.RAM, SortingOrder.ASCENDING, smartphone_list);
        sortingAlgorithm.sort();
        sortingAlgorithm.printSmartphones();
        
        sortingAlgorithm.setAlgorithm(new BubbleSort(SortingFilter.PRICE, SortingOrder.DESCENDING, smartphone_list));
        sortingAlgorithm.getAlgorithm().sort();
        sortingAlgorithm.getAlgorithm().printSmartphones();

        sortingAlgorithm.setAlgorithm(new InsertionSort(SortingFilter.RAM, SortingOrder.ASCENDING, smartphone_list));
        sortingAlgorithm.getAlgorithm().sort();
        sortingAlgorithm.getAlgorithm().printSmartphones();

    }
}