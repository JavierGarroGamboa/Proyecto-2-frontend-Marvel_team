package una.ac.cr.Modelo;


/**
 * Appointment Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Vector;

/**
 * Entity Appointment
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment {

    // Using logger for project
    final Logger logger = LogManager.getLogger(Appointment.class);

   // @JsonProperty("id_appointment")
    private int idAppointment;

   // @JsonProperty("id_doctorOffice")
   private DoctorOffice doctorOffice;

   // @JsonProperty("id_doctor")
   private Doctor doctor;

   // @JsonProperty("id_patient")
    private Patient patient;

    //@JsonProperty("date")
    private String date;

    //@JsonProperty("service")
    private Vector<String> service = new Vector<>();

   // @JsonProperty("totalCost")
    private float cost;

    //@JsonProperty("confirm")
    private boolean confirm;

    /**
     * Constructor sin par�metros
     */
    public Appointment() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param idAppointment
     * @param doctorOffice
     * @param doctor
     * @param patient
     * @param date
     * @param service
     * @param cost
     * @param confirm
     */
    public Appointment(int idAppointment, DoctorOffice doctorOffice, Doctor doctor, Patient patient, String date, Vector<String> service, float cost, boolean confirm) {
        this.idAppointment = idAppointment;
        this.doctorOffice = doctorOffice;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.service = service;
        this.cost = cost;
        this.confirm = confirm;
    }

    /**
     * @return el id de la cita
     */
    public int getIdAppointment() {
        return idAppointment;
    }

    /**
     * @param idAppointment define el id de la cita
     */
    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    /**
     * @return la relaci�n con el consultorio
     */
    public DoctorOffice getDoctorOffice() {
        return doctorOffice;
    }

    /**
     * @param doctorOffice define la relaci�n con el consultorio
     */
    public void setDoctorOffice(DoctorOffice doctorOffice) {
        this.doctorOffice = doctorOffice;
    }

    /**
     * @return la relaci�n con el doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor define la relaci�n con el doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * @return la relaci�n con el doctor
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient define la relaci�n con el paciente
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return la fecha de la cita
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date define la fecha disponible de la cita
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return los servicios del API
     */
    public Vector<String> getService() {
        return service;
    }

    /**
     * @param service define los servicios del API
     */
    public void setService(Vector<String> service) {
        this.service = service;
    }

    /**
     * @return el costo de la cita
     */
    public float getCost() {
        return cost;
    }

    /**
     * @param cost define el costo de la cita
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * @return la confirmaci�n de la cita
     */
    public boolean getConfirm() {
        return confirm;
    }

    /**
     * @param confirm define si la cita esta confirmada o no
     */
    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "idAppointment=" + idAppointment +
                ", doctorOffice=" + doctorOffice +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", date=" + date +
                ", service=" + service +
                ", cost='" + cost +
                ", confirm='" + confirm +
                '}';
    }
}