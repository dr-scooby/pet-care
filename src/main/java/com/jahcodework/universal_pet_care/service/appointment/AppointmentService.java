package com.jahcodework.universal_pet_care.service.appointment;

import com.jahcodework.universal_pet_care.model.Appointment;
import com.jahcodework.universal_pet_care.request.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/*

 Appointment states:
 approved
 not-approved
 on-going
 cancelled
 waiting-for-approval
 */
// make it a Spring Bean using @Service
@Service
@RequiredArgsConstructor
public class AppointmentService implements IAppointmentService{
    @Override
    public Appointment createAppointment(Appointment appt, Long sender, Long recipient) {
        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return null;
    }

    @Override
    public Appointment updateAppointment(Long id, AppointmentRequest apptrequest) {
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {

    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return null;
    }

    @Override
    public Appointment getAppointmentByNo(String appointmentNo) {
        return null;
    }
}
