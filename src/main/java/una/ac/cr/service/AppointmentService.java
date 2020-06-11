package una.ac.cr.service;

import una.ac.cr.model.Appointment;

import java.util.List;

public interface AppointmentService {
    public List<Appointment> findAll();
    public Appointment findById(int id);
}
