package ex3;

import java.util.Collection;

abstract public class Command<T> {
    protected Collection<T> target;
    protected T element;

    public Command(Collection<T> target, T element) {
        this.target = target;
        this.element = element;
    }

    abstract public boolean execute();
    abstract public boolean undo();
}
