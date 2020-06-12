package una.ac.cr;

import java.util.Arrays;
import java.util.Vector;

public class Constants {

    public static final String WS_ENDPOINT = "http://localhost:8083/api/";

    public static final String APPOINTMENT = "appointment";

    public static final Vector<String> TABLE_HEADER_APPOINTMENT = new Vector(
            Arrays.asList(new String[]{"Identificacion", "Consultorio","Doctor", "Paciente","Fecha y Hora","Servicios"}));

}
