package una.ac.cr.Modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Client Model
 *
 * @author JavierGarro, JosuaEsquivel
 */


/**
 * Entity Client
 */
@JsonIgnoreProperties( ignoreUnknown  =  true )
public class Patient {
    // Using logger for project
    final Logger logger = LogManager.getLogger(Patient.class);

    private int idPatient;

    @JsonProperty( "name" )
    private String name;

    @JsonProperty( "dateBorn" )
    private Date dateBorn;

    private List<AddressPatient> addressPatient = new ArrayList<>();

    private List<TelephonePatient> telephonePatient = new ArrayList<>();

    @JsonProperty( "associatedDiseases" )
    private String associatedDiseases;

    @JsonProperty( "observations" )
    private String observations;

    private List<Appointment> appointmentPatient = new ArrayList<>();

    /**
     * Constructor sin par�metros
     */
    public Patient() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     * Constructor con par�metros
     *
     * @param idPatient
     * @param dateBorn
     * @param name
     * @param addressPatient
     * @param telephonePatient
     * @param associatedDiseases
     * @param observations
     */
    public Patient(int idPatient, Date dateBorn, String name, List<AddressPatient> addressPatient, List<TelephonePatient> telephonePatient, String associatedDiseases, String observations) {
        this.idPatient = idPatient;
        this.dateBorn = dateBorn;
        this.name = name;
        this.addressPatient = addressPatient;
        this.telephonePatient = telephonePatient;
        this.associatedDiseases = associatedDiseases;
        this.observations = observations;
    }

    /**
     * @return el id del paciente
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * @param idPatient define
     */
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    /**
     * @return la fecha de nacimiento
     */
    public Date getDateBorn() {
        return dateBorn;
    }

    /**
     * @param dateBorn define la fecha de nacimiento
     */
    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    /**
     * @return el nombre del paciente
     */
    public String getName() {
        return name;
    }

    /**
     * @param name define el nombre del paciente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return la direcci�n del paciente
     */
    public List<AddressPatient> getAddressPatient() {
        return addressPatient;
    }

    /**
     * @param addressPatient define la direcci�n del paciente
     */
    public void setAddressPatient(List<AddressPatient> addressPatient) {
        this.addressPatient = addressPatient;
    }

    /**
     * @return el tel�fono del paciente
     */
    public List<TelephonePatient> getTelephonePatient() {
        return telephonePatient;
    }

    /**
     * @param telephonePatient define el tel�fono del paciente
     */
    public void setTelephonePatient(List<TelephonePatient> telephonePatient) {
        this.telephonePatient = telephonePatient;
    }

    /**
     * @return las enfermedades asociadas del paciente
     */
    public String getAssociatedDiseases() {
        return associatedDiseases;
    }

    /**
     * @param associatedDiseases define las enfermedades asociadas del paciente
     */
    public void setAssociatedDiseases(String associatedDiseases) {
        this.associatedDiseases = associatedDiseases;
    }

    /**
     * @return si el paciente presenta alguna observaci�n
     */
    public String getObservations() {
        return observations;
    }

    /**
     * @param observations define la observaci�n del paciente
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<Appointment> getAppointmentPatient() {
        return appointmentPatient;
    }

    public void setAppointmentPatient(List<Appointment> appointmentPatient) {
        this.appointmentPatient = appointmentPatient;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", dateBorn='" + dateBorn +
                ", name='" + name +
                ", addressPatient=" + addressPatient +
                ", telephonePatient=" + telephonePatient +
                ", associatedDiseases='" + associatedDiseases +
                ", observations='" + observations +
                '}';
    }
}
