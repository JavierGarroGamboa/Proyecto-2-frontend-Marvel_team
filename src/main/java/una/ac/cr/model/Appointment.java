package una.ac.cr.model;



/**
 * APPOINTMENT Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


/**
 * Entity APPOINTMENT
 */

public class Appointment {



    private int id_appointment;
    private String doctorOffice;
    private String doctor;
    private String patient;
    private String date;
    private String service;

    /**
     *
     */
    public Appointment() {
    }

    /**
     *
     * @param id_appointment
     * @param doctorOffice
     * @param doctor
     * @param patient
     * @param date
     * @param service
     */
    public Appointment(int id_appointment, String doctorOffice, String doctor, String patient, String date, String service) {
        this.id_appointment = id_appointment;
        this.doctorOffice = doctorOffice;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.service = service;
    }

    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }

    public String getDoctorOffice() {
        return doctorOffice;
    }

    public void setDoctorOffice(String doctorOffice) {
        this.doctorOffice = doctorOffice;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "APPOINTMENT{" +
                "id_appointment=" + id_appointment +
                ", doctorOffice='" + doctorOffice +
                ", doctor='" + doctor +
                ", patient='" + patient +
                ", date='" + date +
                ", service='" + service +
                '}';
    }
}