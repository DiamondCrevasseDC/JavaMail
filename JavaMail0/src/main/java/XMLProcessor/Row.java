package XMLProcessor;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Row {

    @XmlElement
    private String PK_ORG;

    @XmlElement
    private String EMAIL;

    @XmlElement
    private String ICAM_EMAIL;

    @XmlElement
    private String RSM_EMAIL;

    @XmlElement
    private String NAME;

    @XmlElement
    private String PK_PSNDOC;

    @XmlElement
    private String CUSERID;

    @XmlElement
    private String USER_NAME;

    @XmlElement
    private String ROLE_NAME;

    @XmlElement
    private String ORGCODE;

    public String getPK_ORG() {
        return PK_ORG;
    }

    public void setPK_ORG(String PK_ORG) {
        this.PK_ORG = PK_ORG;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getICAM_EMAIL() {
        return ICAM_EMAIL;
    }

    public void setICAM_EMAIL(String ICAM_EMAIL) {
        this.ICAM_EMAIL = ICAM_EMAIL;
    }

    public String getRSM_EMAIL() {
        return RSM_EMAIL;
    }

    public void setRSM_EMAIL(String RSM_EMAIL) {
        this.RSM_EMAIL = RSM_EMAIL;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPK_PSNDOC() {
        return PK_PSNDOC;
    }

    public void setPK_PSNDOC(String PK_PSNDOC) {
        this.PK_PSNDOC = PK_PSNDOC;
    }

    public String getCUSERID() {
        return CUSERID;
    }

    public void setCUSERID(String CUSERID) {
        this.CUSERID = CUSERID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
    }

    public String getORGCODE() {
        return ORGCODE;
    }

    public void setORGCODE(String ORGCODE) {
        this.ORGCODE = ORGCODE;
    }

    public Row(){

    }

    public Row(String PK_ORG, String EMAIL, String ICAM_EMAIL, String RSM_EMAIL, String NAME, String PK_PSNDOC, String CUSERID, String USER_NAME, String ROLE_NAME, String ORGCODE) {
        this.PK_ORG = PK_ORG;
        this.EMAIL = EMAIL;
        this.ICAM_EMAIL = ICAM_EMAIL;
        this.RSM_EMAIL = RSM_EMAIL;
        this.NAME = NAME;
        this.PK_PSNDOC = PK_PSNDOC;
        this.CUSERID = CUSERID;
        this.USER_NAME = USER_NAME;
        this.ROLE_NAME = ROLE_NAME;
        this.ORGCODE = ORGCODE;
    }
}
