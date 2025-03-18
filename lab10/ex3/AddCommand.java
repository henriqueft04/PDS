package ex3;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Stack;

public class AddCommand<T> extends Command<T> {

    public AddCommand(ArrayList<T> target, T element) {
        super(target, element);
    }

    public boolean execute() {
        if (target instanceof ArrayList<T>) {
            return ((ArrayList<T>) target).add(element);
        } else if (target instanceof Stack<T>) {
            return ((Stack<T>) target).add(element);
        } else {
            return false;
        }
    }

    public boolean undo() {
        if (target instanceof ArrayList<T>) {
            return ((ArrayList<T>) target).remove(element);
        } else if (target instanceof Stack<T>) {
            return ((Stack<T>) target).remove(element);
        } else {
            return false;
        }
    }
}
