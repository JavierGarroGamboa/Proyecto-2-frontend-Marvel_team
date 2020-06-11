package una.ac.cr.wedservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import una.ac.cr.service.AppointmentService;
import una.ac.cr.service.AppointmentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * REST Web Service
 *
 * @author mike.education
 */
@WebServlet(name = "StudentWebservice", urlPatterns = {"students"}, loadOnStartup = 1)
public class AppointmentWedService extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();
    private AppointmentService appointmentService = new AppointmentServiceImpl();

    /**
     * Retrieves All the Students
     * URL/students
     * URL/students?id=1
     * @return Student
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String json = null;
        String param = request.getParameter("id");
/*
        if (param != null) {
            int id = Integer.valueOf(param);
            Student student = studentService.findById(id);
            json = mapper.writeValueAsString(student);
        } else {
            List<Student> studentList = studentService.findAll();
            json = mapper.writeValueAsString(studentList);
        }
*/
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(json);
    }
}
