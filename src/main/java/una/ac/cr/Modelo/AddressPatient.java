package una.ac.cr.Modelo;


/**
 * Address Model
 *
 * @author JavierGarro, JosuaEsquivel
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity Address
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressPatient {

    // Using logger for project
    final Logger logger = LogManager.getLogger(AddressPatient.class);

    //@JsonProperty("id_address")
    private int idAddress;

    @JsonProperty("id_patient")
    private int idPatient;

    @JsonProperty("address")
    private String address;

    /**
     * Constructor sin par�metros
     */
    public AddressPatient() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param idAddress
     * @param address
     */
    public AddressPatient(int idAddress, int idPatient, String address) {
        this.idAddress = idAddress;
        this.idPatient = idPatient;
        this.address = address;
    }

    /**
     * @return el id de la direcci�n
     */
    public int getIdAddress() {
        return idAddress;
    }

    /**
     * @param idAddress define el id de la direcci�n
     */
    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
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
     * @return la direcci�n del paciente
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address define la direcci�n del paciente
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressPatient{" +
                "idAddress=" + idAddress +
                ", idPatient=" + idPatient +
                ", address='" + address +
                '}';
    }
}



