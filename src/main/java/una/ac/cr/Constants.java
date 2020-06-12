package una.ac.cr;

import java.util.Arrays;
import java.util.Vector;

public class Constants {
    /**
     *
     */
    public static final String WS_ENDPOINT = "http://localhost:8083/api/";
    public static final String Patient = "patients";
    public static final String DoctorOffice = "doctorOffices";
    public static final String Doctor = "doctor";
    public static final String TypeDoctor = "typeDoctor";
    public static final String DoctorActivities = "doctorActivities";
    public static final String Appointment = "appointment";


    /**
     *
     */
    public static final Vector<String> TABLE_HEADER_Appointment = new Vector(
            Arrays.asList(new String[]{"Identificacion", "Consultorio","Doctor", "Paciente","Fecha y Hora","Servicios"}));

}
