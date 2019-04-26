package XMLProcessor;



import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Process {

    public static Object xmlToBean(String xmlPath,Class<?> load) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new File(xmlPath));
        return object;
    }

    public static List<Row> getRowList(String filePath) throws JAXBException, IOException {
        String xmlPath =  filePath;
        Object object = xmlToBean(xmlPath, Rowdata.class);
        Rowdata root = (Rowdata)object;
        List<Row> rowList = root.getList();

        return rowList;
    }

    public static void main(String[] args){
        List<Row> rowList = null;
        try {
            rowList = getRowList("D:\\EMAIL.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
