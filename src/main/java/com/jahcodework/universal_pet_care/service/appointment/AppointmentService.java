package com.jahcodework.universal_pet_care.service.appointment;

import com.jahcodework.universal_pet_care.model.Appointment;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.AppointmentRepo;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import com.jahcodework.universal_pet_care.request.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    private final AppointmentRepo apptrepo;

    private final UserRepo userrepo;

    @Override
    public Appointment createAppointment(Appointment appt, Long senderid, Long recipientid) {
        Optional<User> sender =userrepo.findById(senderid);
        Optional<User> recipient =userrepo.findById(recipientid);


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
