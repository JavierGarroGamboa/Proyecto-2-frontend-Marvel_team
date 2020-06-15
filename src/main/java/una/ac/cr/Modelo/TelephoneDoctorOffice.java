package una.ac.cr.Modelo;

//import javax.persistence.*;

/**
 * Telephone Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity Telephone
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class TelephoneDoctorOffice {
    // Using logger for project
    final Logger logger = LogManager.getLogger(Patient.class);
    //@JsonProperty("id_telephone")
    private int idTelephone;

    //@JsonProperty("id_doctorOffice")
    private int idDoctorOffice;

    //@JsonProperty("telephone")
    private String telephone;

    //@JsonProperty("typeTelephone")
    private String typeTelephone;

    /**
     * Constructor sin par�metros
     */
    public TelephoneDoctorOffice() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param idTelephone
     * @param idDoctorOffice
     * @param telephone
     * @param typeTelephone
     */
    public TelephoneDoctorOffice(int idTelephone, int idDoctorOffice, String telephone, String typeTelephone) {
        this.idTelephone = idTelephone;
        this.idDoctorOffice = idDoctorOffice;
        this.telephone = telephone;
        this.typeTelephone = typeTelephone;
    }

    /**
     * @return el id del tel�fono
     */
    public int getIdTelephone() {
        return idTelephone;
    }

    /**
     * @param idTelephone define el id del tel�fono
     */
    public void setIdTelephone(int idTelephone) {
        this.idTelephone = idTelephone;
    }

    /**
     * @return el id de la relaci�n con el consultorio
     */
    public int getIdDoctorOffice() {
        return idDoctorOffice;
    }

    /**
     * @param idDoctorOffice define el id de la relaci�n con el consultorio
     */
    public void setIdDoctorOffice(int idDoctorOffice) {
        this.idDoctorOffice = idDoctorOffice;
    }

    /**
     * @return el numero de tel�fono del consultorio
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone define el numero de tel�fono del consultorio
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return el tipo de tel�fono
     */
    public String getTypeTelephone() {
        return typeTelephone;
    }

    /**
     * @param typeTelephone define el tipo de tel�fono
     */
    public void setTypeTelephone(String typeTelephone) {
        this.typeTelephone = typeTelephone;
    }

    @Override
    public String toString() {
        return "TelephoneDoctorOffice{" +
                "idTelephone=" + idTelephone +
                ", idDoctorOffice=" + idDoctorOffice +
                ", telephone='" + telephone +
                ", typeTelephone='" + typeTelephone +
                '}';
    }
}
