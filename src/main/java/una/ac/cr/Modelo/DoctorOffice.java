package una.ac.cr.Modelo;

/**
 * MedicalOffice Model
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
 * Entity MedicalOffice
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorOffice {
    // Using logger for project
    final Logger logger = LogManager.getLogger(DoctorOffice.class);

    private int idOffice;

    @JsonProperty("name")
    private String name;

    @JsonProperty("schedule")
    private String schedule;

    private List<AddressDoctorOffice> addressDoctorOffice = new ArrayList<>();

    private List<TelephoneDoctorOffice> telephoneDoctorOffice = new ArrayList<>();

    private List<Appointment> appointmentDoctorOffice = new ArrayList<>();

    /**
     * Constructor sin par�metros
     */
    public DoctorOffice() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param idOffice
     * @param name
     * @param schedule
     * @param addressDoctorOffice
     * @param telephoneDoctorOffice
     */
    public DoctorOffice(int idOffice, String name, String schedule, List<AddressDoctorOffice> addressDoctorOffice, List<TelephoneDoctorOffice> telephoneDoctorOffice) {
        this.idOffice = idOffice;
        this.name = name;
        this.schedule = schedule;
        this.addressDoctorOffice = addressDoctorOffice;
        this.telephoneDoctorOffice = telephoneDoctorOffice;
    }

    /**
     * @return el id del consultorio
     */
    public int getIdOffice() {
        return idOffice;
    }

    /**
     * @param idOffice define el id del consultorio
     */
    public void setIdOffice(int idOffice) {
        this.idOffice = idOffice;
    }

    /**
     * @return el nombre del consultorio
     */
    public String getName() {
        return name;
    }

    /**
     * @param name define el nombre del consultorio
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return el horario del consultorio
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * @param schedule define el horario del consultorio
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * @return la direcci�n del consultorio
     */
    public List<AddressDoctorOffice> getAddressDoctorOffice() {
        return addressDoctorOffice;
    }

    /**
     * @param addressDoctorOffice define la direcci�n del consultorio
     */
    public void setAddressDoctorOffice(List<AddressDoctorOffice> addressDoctorOffice) {
        this.addressDoctorOffice = addressDoctorOffice;
    }

    /**
     * @return el tel�fono del consultorio
     */
    public List<TelephoneDoctorOffice> getTelephoneDoctorOffice() {
        return telephoneDoctorOffice;
    }

    /**
     * @param telephoneDoctorOffice define el tel�fono del consultorio
     */
    public void setTelephoneDoctorOffice(List<TelephoneDoctorOffice> telephoneDoctorOffice) {
        this.telephoneDoctorOffice = telephoneDoctorOffice;
    }

    public List<Appointment> getAppointmentDoctorOffice() {
        return appointmentDoctorOffice;
    }

    public void setAppointmentDoctorOffice(List<Appointment> appointmentDoctorOffice) {
        this.appointmentDoctorOffice = appointmentDoctorOffice;
    }

    @Override
    public String toString() {
        return "DoctorOffice{" +
                "idOffice=" + idOffice +
                ", name='" + name +
                ", schedule='" + schedule +
                ", addressDoctorOffice=" + addressDoctorOffice +
                ", telephoneDoctorOffice=" + telephoneDoctorOffice +
                '}';
    }
}
