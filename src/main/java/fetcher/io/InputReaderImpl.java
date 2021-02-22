package fetcher.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {
    private final BufferedReader reader;

    public InputReaderImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String result = null;
        try {
            result = this.reader.readLine().trim();
        } catch (IOException e) {
        }
        return result;
    }
}
