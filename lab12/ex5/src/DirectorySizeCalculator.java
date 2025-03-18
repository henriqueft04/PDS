package ex5.src;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.lang.Long;

public class DirectorySizeCalculator {

    public static void main(String[] args) {
        String root = null;
        boolean recursive = false;

        for (String arg : args) {
            if (arg.equals("-h")) {
                System.out.println("Usage: java DirectorySizeCalculator [-r] <directory>");
                System.exit(0);
            } else if (arg.equals("-r")) {
                recursive = true;
            } else {
                root = arg;
            }
        }

        Path rootPath = Paths.get(args[0]);

        try {
            DirectorySizeVisitor visitor = new DirectorySizeVisitor();
            
            if (recursive) {
                Files.walkFileTree(rootPath, visitor);
            } else {
                Files.newDirectoryStream(rootPath).forEach(path -> {
                    try {
                        visitor.visitFile(path, Files.readAttributes(path, BasicFileAttributes.class));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            visitor.printLogs();
            System.out.println("Total: " + (double) visitor.getTotalSize() / 1024 + " kB");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DirectorySize {
    private long totalSize = 0;

    public long getTotalSize() {
        return totalSize;
    }

    public void addSize(long size) {
        totalSize += size;
    }
}

class DirectorySizeVisitor extends SimpleFileVisitor<Path> {
    private Stack<Long> sizeStack = new Stack<>();
    private Stack<String> logs = new Stack<>();
    private boolean isroot;

    public DirectorySizeVisitor() {
        newDirectory();
        isroot = true;
    }

    private void newDirectory() {
        sizeStack.push(0L);
    }

    private Long endDirectory() {
        Long lastSize = sizeStack.pop();
        addSize(lastSize);
        return lastSize;
    }

    private void addSize(long size) {
        sizeStack.push(sizeStack.pop() + size);
    }



    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // Extract only the filename without the path
        String filename = file.getFileName().toString();
        int level = sizeStack.size() - 2;
        logs.push(String.format("%s%s: %.2f kB\n",
            "|  ".repeat(Math.max(level - 1, 0)) + (level > 0 ? "|->" : ""),
            filename,
            ((double) attrs.size()) / 1024)
        );
        addSize(attrs.size());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        // Print the error but continue the file tree walk
        System.err.println("Failed to access file: " + file.toString() + " (" + exc.getMessage() + ")");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (exc != null) {
            System.err.println("Failed to access directory: " + dir.toString() + " (" + exc.getMessage() + ")");
        }
        if (sizeStack.size() > 2) {
            String dirname = dir.getFileName().toString();
            int level = sizeStack.size() - 3;
            logs.push(String.format("%s%s: %.2f kB\n",
                "|  ".repeat(Math.max(level - 1, 0)) + (level > 0 ? "|->" : ""),
                dirname,
                ((double) getTotalSize()) / 1024)
            );
            endDirectory();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        newDirectory();
        return FileVisitResult.CONTINUE;
    }

    public long getTotalSize() {
        return sizeStack.peek();
    }

    public void printLogs() {
        while (!logs.isEmpty()) {
            System.out.print(logs.pop());
        }
    }
}
