package una.ac.cr.Modelo;


/**
 * Address Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Entity Address
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDoctorOffice {

    // Using logger for project
    final Logger logger = LogManager.getLogger(AddressDoctorOffice.class);

    //@JsonProperty("id_address")
    private int idAddress;

   // @JsonProperty("id_doctorOffice")
    private int idDoctorOffice;

   // @JsonProperty("address")
    private String address;

    /**
     * Constructor sin par�metros
     */
    public AddressDoctorOffice() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param idAddress
     * @param address
     */
    public AddressDoctorOffice(int idAddress, int idDoctorOffice, String address) {
        this.idAddress = idAddress;
        this.idDoctorOffice = idDoctorOffice;
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
     * @return el id de la relaci�n con el paciente consultorio
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
     * @return la direcci�n del consultorio
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address define la direcci�n del consultorio
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressPatient{" +
                "idAddress=" + idAddress +
                ", idDoctorOffice=" + idDoctorOffice +
                ", address='" + address +
                '}';
    }
}



