package fetcher.util;

import fetcher.entity.IssueContainer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

import static fetcher.common.Constants.XML_FILE_PATH;

public class XmlFileUtil implements FileUtil {

    private final IssueContainer issues;
    private final JAXBContext context;

    public XmlFileUtil(IssueContainer issues) throws JAXBException {
        this.issues = issues;
        this.context = JAXBContext.newInstance(IssueContainer.class);
    }

    @Override
    public void save() throws JAXBException {
        Marshaller marshaller = this.context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(issues, new File(XML_FILE_PATH));
    }
}
