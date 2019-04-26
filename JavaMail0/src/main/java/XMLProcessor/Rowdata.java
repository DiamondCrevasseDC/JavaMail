package XMLProcessor;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="ROWDATA")
public class Rowdata {

    private List<Row> list;

    @XmlElement(name="ROW")
    public List<Row> getList() {
        return list;
    }

    public void setList(List<Row> list) {
        this.list = list;
    }

    public Rowdata(List<Row> list) {
        this.list = list;
    }
    public Rowdata() {
    }
}
