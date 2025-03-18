package lab12.ex1;
import java.util.Comparator;
import java.util.List;

public class BubbleSort extends SortingAlgorithm{
    
    public BubbleSort(SortingFilter sortingFilter, SortingOrder sortingOrder, List<Smartphone> smartphones) {
        super(sortingFilter, sortingOrder, smartphones);
    }

    public static <T> void bubbleSort(List<T> list, Comparator<? super T> comparator) {
        // start timer
        long startTime = System.nanoTime();
        boolean swapped;
        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        // end timer
        long endTime = System.nanoTime();
        System.out.println("---------------- Bubble sort time: " + (endTime - startTime) + " ns ----------------");
    }

    @Override
    public void sort() {
        switch (super.getSortingFilter() + " " + super.getSortingOrder()){
            case "RAM ASCENDING":
                bubbleSort(super.getSmartphones(), Comparator.comparing(Smartphone::getMemory));
                break;
            case "RAM DESCENDING":
                bubbleSort(super.getSmartphones(), Comparator.comparing(Smartphone::getMemory).reversed());
                break;
            case "PRICE ASCENDING":
                bubbleSort(super.getSmartphones(), Comparator.comparing(Smartphone::getPrice));
                break;
            case "PRICE DESCENDING":
                bubbleSort(super.getSmartphones(), Comparator.comparing(Smartphone::getPrice).reversed());
                break;
            case "DESCRIPTION ASCENDING":
                bubbleSort(super.getSmartphones(), Comparator.comparing(Smartphone::getDescription));
                break;
            case "DESCRIPTION DESCENDING":
                bubbleSort(super.getSmartphones(), Comparator.comparing(Smartphone::getDescription).reversed());
                break;
        }
    }

}
