package una.ac.cr.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Services Model
 *
 * @author JavierGarro, JosuaEsquivel
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Services {
    // Using logger for project
    final Logger logger = LogManager.getLogger(Services.class);


    @JsonProperty("_id")
    private $id id;

    @JsonProperty("servicio")
    private String services;

    @JsonProperty("costo-porcentual")
    private float cost;

    @JsonProperty("codigo-medico")
    private String doctorCode;

    /**
     * Constructor sin parámetros
     */
    public Services() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con parámetros
     *
     * @param id
     * @param services
     * @param cost
     * @param doctorCode
     */
    public Services($id id, String services, float cost, String doctorCode) {
        this.id = id;
        this.services = services;
        this.cost = cost;
        this.doctorCode = doctorCode;
    }

    /**
     * @return el id del tipo de medico
     */
    public $id getId() {
        return id;
    }

    /**
     * @param id define el id del medico
     */
    public void setId($id id) {
        this.id = id;
    }

    /**
     * @return el tipo de medico
     */
    public String getServices() {
        return services;
    }

    /**
     * @param services define el tipo de medico
     */
    public void setServices(String services) {
        this.services = services;
    }

    /**
     * @return el costo por servicio
     */
    public float getCost() {
        return cost;
    }

    /**
     * @param cost define el costo por el servicio
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * @return el código del doctor
     */
    public String getDoctorCode() {
        return doctorCode;
    }

    /**
     * @param doctorCode define el código del doctor
     */
    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    @Override
    public String toString() {
        return "Services{" +
                ", id=" + id +
                ", services='" + services +
                ", cost=" + cost +
                ", doctorCode='" + doctorCode +
                '}';
    }
}
