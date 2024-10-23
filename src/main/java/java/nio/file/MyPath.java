package java.nio.file;

import java.io.File;

public class MyPath implements Path {
    private String path;

    public MyPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }

    @Override
    public Path getFileName() {
        int lastSeparator = path.lastIndexOf(File.separator);
        if (lastSeparator == -1) {
            return new MyPath(path);
        }
        return new MyPath(path.substring(lastSeparator + 1));
    }

    @Override
    public Path getParent() {
        int lastSeparator = path.lastIndexOf(File.separator);
        if (lastSeparator == -1) {
            return null;
        }
        return new MyPath(path.substring(0, lastSeparator));
    }

    // You can implement additional methods as necessary
}