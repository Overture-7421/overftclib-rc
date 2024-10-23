package java.nio.file;

import java.io.File;

public class Paths {

    // Dummy implementation to mimic Paths.get()
    public static Path get(String first, String... more) {
        File file = new File(first);
        for (String part : more) {
            file = new File(file, part);
        }
        return new MyPath(file.getAbsolutePath());
    }
}
