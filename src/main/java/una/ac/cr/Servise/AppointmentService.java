package una.ac.cr.Servise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.Modelo.Appointment;
import una.ac.cr.Modelo.Services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service to get the data from the service
 *
 * @author Javier Garro, Joshua Esquivel
 */
public class AppointmentService {

    // Using logger for project
    final Logger logger = LogManager.getLogger(AppointmentService.class);

    private static final String REST_URI = Constants.WS_ENDPOINT.concat(Constants.Appointment);
    private static final String REST_URI_Services = Constants.WS_ENDPOINT.concat(Constants.DoctorActivities);

    private Client client = null;

    /**
     * Empty Constructor
     */
    public AppointmentService() {
        client = ClientBuilder.newClient();
    }

    /**
     * This method will load the information from JSON depending if the filter text
     *
     * @param searchTerm filter term
     * @return the list of patient
     */
    public List<Appointment> searchAppointmentByTerm(int searchTerm) {

        logger.debug("Obteniendo la lista de pacientes que coinciden con [" + searchTerm + "]");

        List<Appointment> appointmentsList = loadAllAppointment();
        List<Appointment> updatedAppointmentstList = new ArrayList<Appointment>();

        if (appointmentsList != null && appointmentsList.size() > 0) {
            for (Appointment appointment : appointmentsList) {
                if (searchTerm > 0 && appointment.getIdAppointment() == searchTerm) {
                    updatedAppointmentstList.add(appointment);
                }
            }
        }

        return updatedAppointmentstList;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of Appointment
     */
    public List<Appointment> loadAllAppointment() {

        logger.debug("Obteniendo toda la lista de Appointment");

        // Library Jackson parse JSon
        List<Appointment> appointmentList = null;

        appointmentList = Arrays.asList(client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get(Appointment[].class));

        return appointmentList;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the save of appointment
     */

    public Appointment saveAppointment(Appointment appointment) {
        Appointment appointmentSave;

        appointmentSave = client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(appointment,
                MediaType.APPLICATION_JSON), Appointment.class);

        return appointmentSave;
    }

    /**
     * This metodo will load delete the data from the WS
     *
     * @return the boolean of appointmentDelete
     */

    public Appointment deleteAppointmentsByTerm(int appointment) {
        Appointment appointmentDelete;

        appointmentDelete = client.target(REST_URI).path("/{id}")
                .resolveTemplate("id", appointment).request(MediaType.APPLICATION_JSON).delete(Appointment.class);

        return appointmentDelete;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the true boolean of upDateAppointment
     */
    public Appointment upDateAppointment(Appointment appointment) {
        Appointment appointmentUpdate;

        appointmentUpdate = client.target(REST_URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(appointment,
                MediaType.APPLICATION_JSON), Appointment.class);

        return appointmentUpdate;
    }
    /**
     * This method will load all the data from the WS
     *
     * @return the list of Servicios
     */
    public List<Services> loadAllDoctorServices() {

        logger.debug("Obteniendo toda la lista de Servicios");

        // Library Jackson parse JSon
        List<Services> doctorActivitiesList = null;

        doctorActivitiesList = Arrays.asList(client.target(REST_URI_Services).request(MediaType.APPLICATION_JSON)
                .get(Services[].class));

        return doctorActivitiesList;
    }
}
