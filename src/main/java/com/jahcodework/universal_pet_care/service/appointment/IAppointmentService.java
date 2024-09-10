package com.jahcodework.universal_pet_care.service.appointment;

import com.jahcodework.universal_pet_care.model.Appointment;
import com.jahcodework.universal_pet_care.request.AppointmentRequest;

import java.util.List;

public interface IAppointmentService {

    Appointment createAppointment(Appointment appt, Long sender, Long recipient);

    List<Appointment> getAllAppointments();

    Appointment updateAppointment(Long id, AppointmentRequest apptrequest);

    void deleteAppointment(Long id);

    Appointment getAppointmentById(Long id);

    Appointment getAppointmentByNo(String appointmentNo);
}
