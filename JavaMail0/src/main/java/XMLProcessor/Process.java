package XMLProcessor;



import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Process {

    public static Object xmlToBean(String xmlPath,Class<?> load) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new File(xmlPath));
        return object;
    }

    public static void beanToXml(Object object, String xmlPath, Class<?> load) throws JAXBException, IOException {
        try(FileWriter writer = new FileWriter(xmlPath)) {
            JAXBContext context = JAXBContext.newInstance(load);
            Marshaller marshal = context.createMarshaller();
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // 隐去报文头的生成, Marshaller.JAXB_FRAGMENT默认为false
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshal.marshal(object, System.out);
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            marshal.marshal(object, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Row> getRowList(String filePath) throws JAXBException, IOException {
        String xmlPath =  filePath;
        Object object = xmlToBean(xmlPath, Rowdata.class);
        Rowdata root = (Rowdata)object;
        List<Row> rowList = root.getList();

        return rowList;
    }

    public static void main(String[] args) {
        Row row = new Row("2333333");
        Rowdata rowdata = new Rowdata(Stream.of(row).collect(Collectors.toList()));
        try {
            beanToXml(rowdata, "/Users/leo/rowdata.xml", Rowdata.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
