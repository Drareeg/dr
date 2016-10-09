package file.read;

import error.MyException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Drareeg on 09.10.16.
 */
public class FileRef {

    private Path path;

    public FileRef(Path path) {
        this.path = path;
    }

    public InputStream inputStream() {
        try {
            return Files.newInputStream(path);
        } catch (IOException e) {
            throw new MyException(e, "FileRef inlezen mislukt.");
        }
    }
}
