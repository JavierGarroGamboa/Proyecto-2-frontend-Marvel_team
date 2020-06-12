package una.ac.cr.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.model.Appointment;
import una.ac.cr.service.AppointmentService;
import una.ac.cr.view.AppointmentView;

import java.text.Normalizer;
import java.util.List;
import java.util.Vector;

import static javax.swing.JOptionPane.showMessageDialog;


public class AppointmentController {

    // Using logger for project
    final Logger logger = LogManager.getLogger(AppointmentController.class);

    // APPOINTMENT Model
    private List<Appointment> listAppointmentModel;
    //APPOINTMENT Service
    private AppointmentService appointmentService;
    // Vector for the Data Table
    private Vector<Vector<String>> dataVector;

    //APPOINTMENT View
    AppointmentView appointmentView;

    public AppointmentController() {

        appointmentService = new AppointmentService();

        actualizar();
        initController();
    }

    private void initController() {
        //appointmentView.getButtonConfirm().addActionListener(e->saveAppointmen());
        appointmentView.getButtonConfirm().addActionListener(e->searchText());

        actualizar();
    }

    /**
     * Method to Actualizar
     */
    private void actualizar() {
        dataVector = loadDataFromAppointmentService(0);
        appointmentView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_APPOINTMENT);
    }


    /**
     * Method to parseInt
     */

    private int parseInt(String phone) {

        int phone1 = 0;
        if (!phone.equals("")) {
            phone1 = Integer.parseInt(phone);
        }
        return phone1;

    }


    /**
     * Method to filter the data from the service depending of the search value
     * As soon the user click the button search
     */
    private void searchText() {
        int searchTerm = 0;
        logger.debug("Searching the information of: " + searchTerm);


        if (appointmentView.getTextFielFilter().getText().length() != 0) {
            searchTerm = parseInt(appointmentView.getTextFielFilter().getText());
            if (searchTerm != 0) {
                dataVector = loadDataFromAppointmentService(searchTerm);
                Vector<String> appointmentVector = dataVector.elementAt(0);
                logger.debug("Data found: " + dataVector.size());

                appointmentView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_APPOINTMENT);

            } else {
                dataVector = loadDataFromAppointmentService(0);
                appointmentView.getTextFielFilter().setText("");
                logger.debug("Data found: " + dataVector.size());

                appointmentView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_APPOINTMENT);
            }


        } else {
            showMessageDialog(null, "Debes de ingresar el Identificacion ");

        }

    }

    /**
     * Method to load data from the service
     *
     * @param searchTerm filter the data with this term
     * @return vector of doctor
     */
    private Vector<Vector<String>> loadDataFromAppointmentService(int searchTerm) {

        dataVector = new Vector();

        if (searchTerm > 0) {
            listAppointmentModel = appointmentService.searchAppointmentByTerm(searchTerm);

        } else {
            listAppointmentModel = appointmentService.loadAllAppointment();
        }

        if (listAppointmentModel != null && listAppointmentModel.size() > 0) {
            int index = 0;
            Vector<String> appointmenVector = null;
            for (Appointment appointment : listAppointmentModel) {
                appointmenVector = new Vector();
                appointmenVector.add(checkIfNull(appointment.getId_appointment()));
                appointmenVector.add(checkIfNull(appointment.getDoctorOffice()));
                appointmenVector.add(checkIfNull(appointment.getDoctor()));
                appointmenVector.add(checkIfNull(appointment.getPatient()));
                appointmenVector.add(checkIfNull(appointment.getDate()));
                appointmenVector.add(checkIfNull(appointment.getService()));


                dataVector.add(appointmenVector);
            }
        }

        return dataVector;
    }



    /**
     * Check if the value is null
     *
     * @param obj the value
     * @return Empty value if it's null
     */
    private String checkIfNull(Object obj) {
        String text;
        if (obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }

    /**
     * Metodo para eliminar las Tildes
     * de las palablas
     */
    private String quitarTildes(String text) {
        String textLimpio = "";
        textLimpio = Normalizer.normalize(text, Normalizer.Form.NFD);
        textLimpio = textLimpio.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        return textLimpio;
    }


}
