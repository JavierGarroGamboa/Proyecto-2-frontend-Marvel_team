package una.ac.cr.Modelo;


/**
 * Doctor Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity Doctor
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Doctor {
    // Using logger for project
    final Logger logger = LogManager.getLogger(Doctor.class);

    //@JsonProperty("id_doctor")
    private int idDoctor;

    @JsonProperty("name")
    private String name;

    //@JsonProperty("type_doctor")
    private String typeDoctor;

    @JsonProperty("premium")
    private boolean premium;

    private List<Appointment> appointmentDoctor = new ArrayList<>();


    /**
     * Constructor sin par�metros
     */
    public Doctor() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param idDoctor
     * @param name
     * @param typeDoctor
     * @param premium
     */
    public Doctor(int idDoctor, String name, String typeDoctor, boolean premium) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.typeDoctor = typeDoctor;
        this.premium = premium;
    }

    /**
     * @return el id del doctor
     */
    public int getIdDoctor() {
        return idDoctor;
    }

    /**
     * @param idDoctor define el id del doctor
     */
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    /**
     * @return el nombre del doctor
     */
    public String getName() {
        return name;
    }

    /**
     * @param name define el nombre del nuevo doctor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return el tipo de doctor
     */
    public String getTypeDoctor() {
        return typeDoctor;
    }

    /**
     * @param typeDoctor define el tipo de doctor
     */
    public void setTypeDoctor(String typeDoctor) {
        this.typeDoctor = typeDoctor;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public List<Appointment> getAppointmentDoctor() {
        return appointmentDoctor;
    }

    public void setAppointmentDoctor(List<Appointment> appointmentDoctor) {
        this.appointmentDoctor = appointmentDoctor;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", name='" + name +
                ", typeDoctor='" + typeDoctor +
                ", premium=" + premium +
                '}';
    }
}
