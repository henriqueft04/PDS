package lab12.ex1;
import java.util.List;
import java.util.Comparator;

public class InsertionSort extends SortingAlgorithm{
    
    public InsertionSort(SortingFilter sortingFilter, SortingOrder sortingOrder, List<Smartphone> smartphones) {
        super(sortingFilter, sortingOrder, smartphones);
    }

    
    public static <T> void insertionSort(List<T> list, Comparator<? super T> comparator) {
        
        long startTime = System.nanoTime();

        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        long endTime = System.nanoTime();
        System.out.println("---------------- Insertion sort time: " + (endTime - startTime) + " ns ----------------");
    }

    @Override
    public void sort() {
        switch (super.getSortingFilter() + " " + super.getSortingOrder()){
            case "RAM ASCENDING":
                insertionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getMemory));
                break;
            case "RAM DESCENDING":
                insertionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getMemory).reversed());
                break;
            case "PRICE ASCENDING":
                insertionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getPrice));
                break;
            case "PRICE DESCENDING":
                insertionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getPrice).reversed());
                break;
            case "DESCRIPTION ASCENDING":
                insertionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getDescription));
                break;
            case "DESCRIPTION DESCENDING":
                insertionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getDescription).reversed());
                break;
        }
    }
}