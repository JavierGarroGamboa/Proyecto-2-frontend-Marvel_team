package una.ac.cr.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.model.Appointment;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppointmentService {

    // Using logger for project
    final Logger logger = LogManager.getLogger(AppointmentService.class);

    private static final String REST_URI = Constants.WS_ENDPOINT.concat(Constants.Appointment);

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
                if (searchTerm > 0 && appointment.getId_appointment() == searchTerm) {
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
}
