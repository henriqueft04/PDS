package ex3;

import java.util.Stack;

public class Invoker<T> {
    private Stack<Command<T>> undoStack;

    public Invoker() {
        undoStack = new Stack<Command<T>>();
    }

    public void execute(Command<T> command) {
        if (command.execute())
            undoStack.push(command);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command<T> command = undoStack.pop();
            command.undo();
        }
    }
}
