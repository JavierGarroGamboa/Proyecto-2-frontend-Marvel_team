package una.ac.cr.Modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * TypeDoctor Model
 *
 * @author JavierGarro, JosuaEsquivel
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypeDoctor {
    // Using logger for project
    final Logger logger = LogManager.getLogger(TypeDoctor.class);

    @JsonProperty("_id")
    private $id id;

    @JsonProperty("tipo")
    private String type;

    @JsonProperty("salario")
    private int salary;

    @JsonProperty("moneda")
    private String coin;

    @JsonProperty("codigo-medico")
    private String doctorCode;

    /**
     * Constructor sin par�metros
     */
    public TypeDoctor() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param id
     * @param type
     * @param salary
     * @param coin
     * @param doctorCode
     */
    public TypeDoctor($id id, String type, int salary, String coin, String doctorCode) {
        this.id = id;
        this.type = type;
        this.salary = salary;
        this.coin = coin;
        this.doctorCode = doctorCode;
    }

    /**
     * @return el id del tipo del medico
     */
    public $id getId() {
        return id;
    }

    /**
     * @param id define el id del tipo del medico
     */
    public void setId($id id) {
        this.id = id;
    }

    /**
     * @return el tipo de medico
     */
    public String getType() {
        return type;
    }

    /**
     * @param type define el tipo de medico
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return el salario del medico
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary define el salario del medico
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return la moneda en uso para el pago
     */
    public String getCoin() {
        return coin;
    }

    /**
     * @param coin definela moneda en uso para el pago
     */
    public void setCoin(String coin) {
        this.coin = coin;
    }

    /**
     * @return el c�digo del doctor
     */
    public String getDoctorCode() {
        return doctorCode;
    }

    /**
     * @param doctorCode define el c�digo del doctor
     */
    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    @Override
    public String toString() {
        return "TypeDoctor{" +
                "id=" + id +
                ", type='" + type +
                ", salary=" + salary +
                ", coin='" + coin +
                ", doctorCode='" + doctorCode +
                '}';
    }
}
