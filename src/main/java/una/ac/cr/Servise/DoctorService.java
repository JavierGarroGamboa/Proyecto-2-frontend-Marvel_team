package una.ac.cr.Servise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.Modelo.Doctor;
import una.ac.cr.Modelo.TypeDoctor;

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
public class DoctorService {
    // Using logger for project
    final Logger logger = LogManager.getLogger(DoctorService.class);
    private static final String REST_URI = Constants.WS_ENDPOINT.concat(Constants.Doctor);private Client client = null;
    private static final String REST_URI_TYPEDoctor = Constants.WS_ENDPOINT.concat(Constants.TypeDoctor);


    /**
     * Empty Constructor
     */
    public DoctorService() {
        client = ClientBuilder.newClient();
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the list of Doctor
     */
    public List<Doctor> loadAllDoctor() {

        logger.debug("Obteniendo toda la lista de Doctor");

        // Library Jackson parse JSon
        List<Doctor> doctorList = null;

        doctorList = Arrays.asList(client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get(Doctor[].class));

        return doctorList;
    }
    /**
     * This method will load the information from JSON depending if the filter text
     *
     * @param searchTerm filter term
     * @return the list of Doctor
     */
    public List<Doctor> searchDoctorsByTerm(int searchTerm) {

        logger.debug("Obteniendo la lista de Doctor que coinciden con [" + searchTerm + "]");

        List<Doctor> doctorsList = loadAllDoctor();
        List<Doctor> updatedDoctortList = new ArrayList<Doctor>();

        if (doctorsList != null && doctorsList.size() > 0) {
            for (Doctor doctor : doctorsList) {
                if (searchTerm > 0 && doctor.getIdDoctor() == searchTerm) {
                    updatedDoctortList.add(doctor);
                }
            }
        }

        return updatedDoctortList;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the save of doctor
     */

    public Doctor saveDoctor(Doctor doctor) {
        Doctor doctorSave;

        doctorSave = client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(doctor,
                MediaType.APPLICATION_JSON), Doctor.class);

        return doctorSave;
    }

    /**
     * This method will load all the data from the WS
     *
     * @return the true Doctor of doctor
     */

    public Doctor upDateDoctor(Doctor doctor) {
        Doctor doctorUpdate;

        doctorUpdate = client.target(REST_URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(doctor,
                MediaType.APPLICATION_JSON), Doctor.class);

        return doctorUpdate;
    }

    /**
     * This metodo will load delete the data from the WS
     *
     * @return the Doctor of Doctor
     */

    public Doctor deleteDoctorByTerm(int doctor) {
        Doctor doctorDelete;

        doctorDelete = client.target(REST_URI).path("/{id}")
                .resolveTemplate("id", doctor).request(MediaType.APPLICATION_JSON).delete(Doctor.class);

        return doctorDelete;
    }
    /**
     * This method will load all the data from the WS
     *
     * @return the list of patient
     */
    public List<TypeDoctor> loadAllTypeDoctor() {

        logger.debug("Obteniendo toda la lista de Tipos de Doctor");

        // Library Jackson parse JSon
        List<TypeDoctor> typeDoctorsList = null;

        typeDoctorsList = Arrays.asList(client.target(REST_URI_TYPEDoctor).request(MediaType.APPLICATION_JSON)
                .get(TypeDoctor[].class));

        return typeDoctorsList;
    }



}
