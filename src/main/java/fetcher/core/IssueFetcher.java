package fetcher.core;

import fetcher.extractor.Extractor;
import fetcher.extractor.IssueExtractor;
import fetcher.common.FileType;
import fetcher.http.HttpManager;
import fetcher.io.InputReader;
import fetcher.io.InputReaderImpl;
import fetcher.model.Issue;
import fetcher.model.IssueContainer;
import fetcher.util.FileUtil;
import fetcher.util.JsonFileUtil;
import fetcher.util.XmlFileUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.http.HttpResponse;

import static fetcher.common.Constants.*;
import static fetcher.common.Attribute.ISSUES;

public class IssueFetcher implements Fetcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(IssueFetcher.class);

    private final HttpManager httpManager;
    private HttpResponse<String> response;
    private final Extractor<IssueContainer, Issue> extractor;
    private FileUtil fileUtil;
    private final InputReader reader;

    public IssueFetcher() {
        this.httpManager = new HttpManager();
        this.extractor = new IssueExtractor();
        this.reader = new InputReaderImpl();
    }

    @Override
    public void run() {

        try {
            this.response = this.httpManager.sendHttpRequest();
        } catch (IOException | InterruptedException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }

        if (response.statusCode() != 200) {
            LOGGER.error(FAILED_RESPONSE + response.statusCode());
            return;
        }

        JSONArray fetchedIssues = new JSONObject(this.response.body()).getJSONArray(ISSUES.label);

        IssueContainer issues = this.extractor.fillContainer(fetchedIssues);

        FileType fileType = this.readFileType();

        switch (fileType) {
            case JSON:
                this.fileUtil = new JsonFileUtil(issues);
                break;
            case XML:
                try {
                    this.fileUtil = new XmlFileUtil(issues);
                } catch (JAXBException e) {
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                }
                break;
            default:
                LOGGER.error(FILETYPE_INVALID);
                break;
        }

        try {
            this.fileUtil.save();
        } catch (IOException | JAXBException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private FileType readFileType() {
        FileType fileType = FileType.OTHER;
        System.out.println("Enter a file type (xml/json): ");

        while (fileType == FileType.OTHER) {

            String input = this.reader.readLine().toUpperCase();

            if (input.equals(FileType.JSON.toString())
                || input.equals(FileType.XML.toString())) {
                fileType = FileType.valueOf(input);
            } else {
                System.out.println("Allowed file types are xml/json. Try again: ");
            }
        }

        return fileType;
    }
}
