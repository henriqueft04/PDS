package ex3;

import java.util.ArrayList;
import java.lang.Integer;

public class Main {
    public static void main(String[] args) {
        Invoker<Integer> invoker = new Invoker<Integer>();
        
        ArrayList<Integer> list = new ArrayList<Integer>();

        AddCommand<Integer> add_1 = new AddCommand<Integer>(list, 1);
        AddCommand<Integer> add_2 = new AddCommand<Integer>(list, 2);
        AddCommand<Integer> add_3 = new AddCommand<Integer>(list, 3);

        invoker.execute(add_1);
        invoker.execute(add_2);
        invoker.execute(add_3);

        System.out.println("List size: " + list);

        RemoveCommand<Integer> remove_3 = new RemoveCommand<Integer>(list, 3);
        invoker.execute(remove_3);

        System.out.println("List size: " + list);

        invoker.undo();

        System.out.println("List size: " + list);

        invoker.undo();

        System.out.println("List size: " + list);
    }
}
