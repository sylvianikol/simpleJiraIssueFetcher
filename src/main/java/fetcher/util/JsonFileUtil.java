package fetcher.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fetcher.entity.IssueContainer;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static fetcher.common.Constants.JSON_FILE_PATH;

public class JsonFileUtil implements FileUtil {

    private final Gson gson;
    private final IssueContainer issues;

    public JsonFileUtil(IssueContainer issues) {
        this.gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


        this.issues = issues;
    }

    @Override
    public void save() {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(JSON_FILE_PATH));
            this.gson.toJson(this.issues, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
