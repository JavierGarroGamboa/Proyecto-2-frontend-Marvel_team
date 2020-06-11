package una.ac.cr.service;

import una.ac.cr.model.Appointment;

import java.util.ArrayList;
import java.util.List;



public class AppointmentServiceImpl implements AppointmentService {
    List<Appointment> appointmentList = null;

    @Override
    public List<Appointment> findAll() {
        appointmentList = new ArrayList<Appointment>();
        Appointment student1 = new Appointment();
        Appointment student2 = new Appointment();

        appointmentList.add(student1);
        appointmentList.add(student2);

        return appointmentList;
    }

    @Override
    public Appointment findById(int id) {
        appointmentList = new ArrayList<Appointment>();
        Appointment student = null;
        /*
        Student student1 = new Student(123, "Sebastian Rojas", "Progra 3", "A+");
        Student student2 = new Student(122, "Emma Sanchez", "Progra 3", "B+");

        appointmentList.add(student1);
        appointmentList.add(student2);

        for (Student studentItem: appointmentList) {
            if (studentItem.getId()==id) {
                student = studentItem;
            }
        }*/

        return student;
    }

}
