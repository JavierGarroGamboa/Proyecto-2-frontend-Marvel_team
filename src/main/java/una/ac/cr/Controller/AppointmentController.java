package una.ac.cr.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import una.ac.cr.Constants;
import una.ac.cr.Modelo.*;
import una.ac.cr.Servise.AppointmentService;
import una.ac.cr.Servise.DoctorOfficeService;
import una.ac.cr.Servise.DoctorService;
import una.ac.cr.Servise.PatientService;
import una.ac.cr.view.AppointmentView;

import java.text.Normalizer;
import java.util.List;
import java.util.Vector;

import static javax.swing.JOptionPane.showMessageDialog;


public class AppointmentController {

    // Using logger for project
    final Logger logger = LogManager.getLogger(AppointmentController.class);
    // Appointment Model
    private List<Appointment> listAppointmentModel;
    // Appointment Model
    private List<Appointment> appointmentModel;
    // Patient Model
    private List<Patient> listPatientModel;
    // DoctorOffice Model
    private List<DoctorOffice> listDoctorOfficeModel;
    // Doctor Model
    private List<Doctor> listDoctorModel;
    // DoctorActivities Model
    private List<Services> listDoctorActivitiesModel;
    //Patient Service
    private PatientService patientService;
    //DoctorOffice Service
    private DoctorOfficeService doctorOfficeService;
    // Doctor Service
    private DoctorService doctorService;
    //Appointment Service
    private AppointmentService appointmentService;
    // Vector for the Data Table
    private Vector<Vector<String>> dataVector;
    //Vector for  Patient
    private Vector<String> patientVector;
    //Vector for  DoctorOffice
    private Vector<String> doctorOfficeVector;
    //Vector for  Doctor
    private Vector<String> doctorVector;
    //Vector for  Doctor
    private Vector<String> doctorActivitiesVector;
    //APPOINTMENT View
    AppointmentView appointmentView;

    public AppointmentController() {

        appointmentService = new AppointmentService();
        appointmentView = new AppointmentView("Confirm Appointment");
        loadDataFromDoctorActivitiesService();
        actualizar();
        initController();
    }

    private void initController() {
        appointmentView.getButtonConfirm().addActionListener(e->upDateAppointmen());
        appointmentView.getButtonFilter().addActionListener(e -> searchText());

        actualizar();
    }

    /**
     * Method to Actualizar
     */
    private void actualizar() {
        dataVector = loadDataFromAppointmentService(0);
        appointmentView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_Appointment);
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

    private Appointment confirmAppointment(int id) {
        Appointment save = new Appointment();
        for (Appointment appointment : listAppointmentModel) {
            if (appointment.getIdAppointment() == id) {
                appointment.setConfirm(true);
                save = appointment;
            }

        }
        return save;
    }
    /**
     * Method to upDate the data using the service
     */
    private void upDateAppointmen() {
        if (appointmentView.getTextFielFilter().getText().length() != 0) {
            Appointment appointment = new Appointment();
            Appointment appointmentSaved = null;

            appointmentSaved = appointmentService.upDateAppointment(confirmAppointment(parseInt(appointmentView.getTextFielFilter().getText())));
            if (appointmentSaved != null) {
                showMessageDialog(null, "Se almaceno correctamente los datos de la Cita con " +
                        "el id [" + appointmentSaved.getIdAppointment() + "]");


            } else {
                showMessageDialog(null, "Hubo un error al almacenar los datos de la Cita");
            }
            actualizar();
        } else {
            showMessageDialog(null, "Hora y Fecha ya estan Reservadas");
        }

    }

        /**
         * Method to filter the data from the service depending of the search value
         * As soon the user click the button search
         */
        private void searchText () {
            int searchTerm = 0;
            logger.debug("Searching the information of: " + searchTerm);


            if (appointmentView.getTextFielFilter().getText().length() != 0) {
                searchTerm = parseInt(appointmentView.getTextFielFilter().getText());
                if (searchTerm != 0) {
                    dataVector = loadDataFromAppointmentService(searchTerm);
                    Vector<String> appointmentVector = dataVector.elementAt(0);
                    logger.debug("Data found: " + dataVector.size());

                    appointmentView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_Appointment);

                } else {
                    dataVector = loadDataFromAppointmentService(0);
                    appointmentView.getTextFielFilter().setText("");
                    logger.debug("Data found: " + dataVector.size());

                    appointmentView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER_Appointment);
                }


            } else {
                showMessageDialog(null, "Debes de ingresar el Identificacion ");

            }

        }
        /**
         * Metodo validar si esta confirmada o no
         * @param isPremium
         * @return
         */
        private String validarPremium ( boolean isPremium){
            String premiun = "No Confirmada";
            if (isPremium) {
                premiun = "Confirmada";
            }
            return premiun;
        }

        /**
         * Mostrar los servicios de la cita
         * @return
         */
        private Vector<String> mostrarServicios (Vector < String > serviceAppoiment) {
            Vector<String> service = new Vector<>();
            int tamanio = serviceAppoiment.size();
            for (int i = 0; i < tamanio; i++) {
                String name = serviceAppoiment.get(i);
                for (Services services : listDoctorActivitiesModel) {
                    if (services.getId().get$oid().equals(name)) {
                        service.add(services.getServices());
                        break;
                    }
                }

            }
            return service;
        }

        /**
         * Method to load data from the service
         *
         * @param searchTerm filter the data with this term
         * @return vector of doctor
         */
        private Vector<Vector<String>> loadDataFromAppointmentService ( int searchTerm){

            dataVector = new Vector();

            if (searchTerm > 0) {
                listAppointmentModel = appointmentService.searchAppointmentByTerm(searchTerm);

            } else {
                listAppointmentModel = appointmentService.loadAllAppointment();
                appointmentModel = appointmentService.loadAllAppointment();
            }

            if (listAppointmentModel != null && listAppointmentModel.size() > 0) {
                int index = 0;
                Vector<String> appointmenVector = null;
                for (Appointment appointment : listAppointmentModel) {
                    appointmenVector = new Vector();
                    appointmenVector.add(checkIfNull(appointment.getIdAppointment()));
                    appointmenVector.add(checkIfNull(appointment.getDoctorOffice().getName()));
                    appointmenVector.add(checkIfNull(appointment.getDoctor().getName()));
                    appointmenVector.add(checkIfNull(appointment.getPatient().getName()));
                    appointmenVector.add(checkIfNull(appointment.getDate()));
                    appointmenVector.add(checkIfNull(mostrarServicios(appointment.getService())));
                    appointmenVector.add(checkIfNull(appointment.getCost()));
                    appointmenVector.add(checkIfNull(validarPremium(appointment.getConfirm())));


                    dataVector.add(appointmenVector);
                }
            }

            return dataVector;
        }


        /**
         * Method to load data from the service
         *
         * @return vector of DortorActivities
         */
        private Vector<String> loadDataFromDoctorActivitiesService () {

            doctorActivitiesVector = new Vector<String>();

            listDoctorActivitiesModel = appointmentService.loadAllDoctorServices();


            if (listDoctorActivitiesModel != null && listDoctorActivitiesModel.size() > 0) {

                for (Services doctorActivities : listDoctorActivitiesModel) {
                    doctorActivitiesVector.add(checkIfNull(doctorActivities.getServices()));

                }
            }

            return doctorActivitiesVector;
        }


        /**
         * Check if the value is null
         *
         * @param obj the value
         * @return Empty value if it's null
         */
        private String checkIfNull (Object obj){
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
        private String quitarTildes (String text){
            String textLimpio = "";
            textLimpio = Normalizer.normalize(text, Normalizer.Form.NFD);
            textLimpio = textLimpio.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

            return textLimpio;
        }


    }
