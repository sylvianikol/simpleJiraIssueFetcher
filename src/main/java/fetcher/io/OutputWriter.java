package fetcher.io;

public interface OutputWriter {
    void writeLine(String text);

    void writeLine(int n);

    void write(String text);

    void write(int n);
}
