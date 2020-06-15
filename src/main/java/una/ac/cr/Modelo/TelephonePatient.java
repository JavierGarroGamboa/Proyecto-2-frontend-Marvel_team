package una.ac.cr.Modelo;

//import javax.persistence.*;

/**
 * Telephone Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity Telephone
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class TelephonePatient {
    // Using logger for project
    final Logger logger = LogManager.getLogger(Patient.class);

    //@JsonProperty("id_telephone")
    private int idTelephone;

    @JsonProperty("id_patient")
    private int idPatient;

    @JsonProperty("telephone")
    private String telephone;

    @JsonProperty("typeTelephone")
    private String typeTelephone;

    /**
     * Constructor sin par�metros
     */
    public TelephonePatient() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param idTelephone
     * @param idPatient
     * @param telephone
     * @param typeTelephone
     */
    public TelephonePatient(int idTelephone, int idPatient, String telephone, String typeTelephone) {
        this.idTelephone = idTelephone;
        this.idPatient = idPatient;
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
     * @return el id de la relaci�n con el paciente
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * @param idPatient define el id de la relaci�n con el paciente
     */
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    /**
     * @return el numero de tel�fono del paciente
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone define el numero de tel�fono del paciente
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
        return "TelephonePatient{" +
                "idTelephone=" + idTelephone +
                ", idPatient=" + idPatient +
                ", telephone='" + telephone +
                ", typeTelephone='" + typeTelephone +
                '}';
    }
}
