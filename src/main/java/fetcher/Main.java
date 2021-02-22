package fetcher;

import fetcher.core.Fetcher;
import fetcher.core.IssueFetcher;

public class Main {
    public static void main(String[] args) {
        Fetcher fetcher = new IssueFetcher();
        fetcher.run();
    }
}
