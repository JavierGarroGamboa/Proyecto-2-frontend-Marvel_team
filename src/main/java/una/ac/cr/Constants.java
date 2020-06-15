package una.ac.cr;

import java.util.Arrays;
import java.util.Vector;

public class Constants {
    /**
     *
     */
    public static final String WS_ENDPOINT = "http://localhost:8083/api/";
    public static final String Patient="patients";
    public static final String DoctorOffice="doctorOffices";
    public static final String Doctor="doctor";
    public static final String TypeDoctor="typeDoctor";
    public static final String DoctorActivities="services";
    public static final String Appointment="appointment";



    /**
     *
     */
    public static final Vector<String> TABLE_HEADER = new Vector(
            Arrays.asList(new String[]{"Identificacion","Fecha de Nacimiento", "Nombre", "Direccion","Telefono","Enfermedades Asociadas ", "Observaciones"}));

    /**
     *
     */
    public static final Vector<String> TABLE_HEADER_Medical_Office = new Vector(
            Arrays.asList(new String[]{"Identificacion", "Nombre", "Horario","Telefono","Direccion"}));
    /**
     *
     */
    public static final Vector<String> TABLE_HEADER_Doctor = new Vector(
            Arrays.asList(new String[]{"Identificacion", "Nombre", "Tipo Doctor","Premium"}));
    /**
     *
     */
    public static final Vector<String> TABLE_HEADER_Appointment = new Vector(
            Arrays.asList(new String[]{"Identificacion", "Consultorio","Doctor", "Paciente","Fecha y Hora","Servicios","Costo Total","Confirmada"}));

    public static final String IMAGESAVE = "Conograma/src/main/resources/save.png";
    public static final String IMAGEDELETE = "Conograma/src/main/resources/delete.png";
    public static final String IMAGEUPDATE = "Conograma/src/main/resources/update.png";
    public static final String IMAGESEARCH = "Conograma/src/main/resources/search.png";
    public static final String IMAGEBACK = "Conograma/src/main/resources/back.png";
    public static final String IMAGEPATIENT = "Conograma/src/main/resources/patient.png";
    public static final String IMAGEDOCTOR = "Conograma/src/main/resources/doctor.png";
    public static final String IMAGEDOCTOROFFICE = "Conograma/src/main/resources/doctorOffice.png";
}
