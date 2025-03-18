package lab12.ex1;

import java.util.Comparator;
import java.util.List;

public class SelectionSortAlgorithm extends SortingAlgorithm{
    public SelectionSortAlgorithm(SortingFilter sortingFilter, SortingOrder sortingOrder, List<Smartphone> smartphones) {
        super(sortingFilter, sortingOrder, smartphones);
    }

    // Custom sorting method using selection sort algorithm
    public static <T> void selectionSort(List<T> list, Comparator<? super T> comparator) {
        
        long startTime = System.nanoTime();
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }

        long endTime = System.nanoTime();
        System.out.println("---------------- Selection sort time: " + (endTime - startTime) + " ns ----------------");
    }

    @Override
    public void sort() {
        switch (super.getSortingFilter() + " " + super.getSortingOrder()){
            case "RAM ASCENDING":
                selectionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getMemory));
                break;
            case "RAM DESCENDING":
                selectionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getMemory).reversed());
                break;
            case "PRICE ASCENDING":
                selectionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getPrice));
                break;
            case "PRICE DESCENDING":
                selectionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getPrice).reversed());
                break;
            case "DESCRIPTION ASCENDING":
                selectionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getDescription));
                break;
            case "DESCRIPTION DESCENDING":
                selectionSort(super.getSmartphones(), Comparator.comparing(Smartphone::getDescription).reversed());
                break;
        }
    }
}

