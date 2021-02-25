package fetcher.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IssueTest {

    private static final String XML_FILE_PATH = "src/test/resources/files/xml/issues.xml";
    private static final String JSON_FILE_PATH = "src/test/resources/files/json/issues.json";
    private Gson gson;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private Issue issue;

    @BeforeEach
    public void setUp() throws JAXBException {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        JAXBContext context = JAXBContext.newInstance(Issue.class);
        this.marshaller = context.createMarshaller();
        this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        this.unmarshaller = context.createUnmarshaller();

        this.issue = new Issue();
        issue.setSummary("testSummary");
        issue.setKey("testKey");
        issue.setUrl("http://test");
        issue.setIssueType("testIssueType");
        issue.setPriority("testPriority");
        issue.setDescription("testDescription");
        issue.setReporter("testReporter");
        issue.setCreatedDate("testDate");

        Comment comment = new Comment("testComment", "testAuthor");
        List<Comment> comments = List.of(comment);
        issue.setComments(comments);
    }

    @Test
    public void test_xml_is_persisted_to_file() throws JAXBException {
        File file = new File(XML_FILE_PATH);
        this.marshaller.marshal(this.issue, file);
        assert(file.length() > 0);
    }

    @Test
    public void test_persisted_xml_is_correct() throws JAXBException {
        File file = new File(XML_FILE_PATH);
        this.marshaller.marshal(this.issue, file);
        Issue unmarshalled = (Issue) unmarshaller.unmarshal(new File(XML_FILE_PATH));
        assertEquals(unmarshalled, this.issue);
    }

    @Test
    public void test_json_is_persisted_to_file() throws IOException {
        File file = new File(JSON_FILE_PATH);
        Writer writer = Files.newBufferedWriter(Paths.get(JSON_FILE_PATH));
        this.gson.toJson(this.issue, writer);
        writer.close();
        assert(file.length() > 0);
        this.gson.fromJson(new FileReader(JSON_FILE_PATH), Issue.class);

    }

    @Test
    public void test_persisted_json_is_correct() throws IOException {
        Writer writer = Files.newBufferedWriter(Paths.get(JSON_FILE_PATH));
        this.gson.toJson(this.issue, writer);
        writer.close();
        Issue deserialized = this.gson.fromJson(new FileReader(JSON_FILE_PATH), Issue.class);
        assertEquals(deserialized, this.issue);
    }
}