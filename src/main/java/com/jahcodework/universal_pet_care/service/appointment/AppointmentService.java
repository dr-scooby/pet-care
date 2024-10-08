package com.jahcodework.universal_pet_care.service.appointment;

import com.jahcodework.universal_pet_care.enumms.AppointmentStatus;
import com.jahcodework.universal_pet_care.exception.ResourceNotFoundException;
import com.jahcodework.universal_pet_care.model.Appointment;
import com.jahcodework.universal_pet_care.model.User;
import com.jahcodework.universal_pet_care.repository.AppointmentRepo;
import com.jahcodework.universal_pet_care.repository.UserRepo;
import com.jahcodework.universal_pet_care.request.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

        if(sender.isPresent() && recipient.isPresent()){
            appt.addPatient(sender.get());
            appt.addVet(recipient.get());
            appt.setAppointmentNo();
            appt.setStatus(AppointmentStatus.WAITING_FOR_APPROVAL);
            return apptrepo.save(appt);
        }

        throw new ResourceNotFoundException("Sender or Recipient not found");
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return apptrepo.findAll();
    }

    @Override
    public Appointment updateAppointment(Long id, AppointmentRequest apptrequest) {
        Appointment existingappointment = getAppointmentById(id);

        if( !Objects.equals(existingappointment.getStatus(), AppointmentStatus.WAITING_FOR_APPROVAL)){

        }

        return null;
    }

    // video #81, timestamp 6:00
    @Override
    public void deleteAppointment(Long id) {
        // video # 82 timestamp 2:56
        // or: apptrepo.findById(id).ifPresentOrElse(apptrepo::delete, ()->{throw new ResourceNotFoundException("Appointment not found")});
        //apptrepo.findById(id).ifPresentOrElse(appointment -> {apptrepo.delete(appointment);}, throw new ResourceNotFoundException("Appointment not found"));
        apptrepo.findById(id).ifPresentOrElse(apptrepo::delete, ()->{throw new ResourceNotFoundException("Appointment not found");});
    }

    @Override
    public Appointment getAppointmentById(Long id) {

        return apptrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("appointment not found"));
    }

    @Override
    public Appointment getAppointmentByNo(String appointmentNo) {
        return apptrepo.findByAppointmentNo(appointmentNo);
    }
}
