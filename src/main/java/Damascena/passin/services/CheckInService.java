package Damascena.passin.services;

import Damascena.passin.domain.attendee.Attendee;
import Damascena.passin.domain.checkin.CheckIn;
import Damascena.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import Damascena.passin.repositories.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckinRepository checkinRepository;

    public void registerCheckIn(Attendee attendee){
        this.verifyCheckInExists(attendee.getId());

        CheckIn newCheckIn = new CheckIn();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());

        this.checkinRepository.save(newCheckIn);
    }

    private void verifyCheckInExists(String attendeeId){
        Optional<CheckIn> isCheckedIn = this.getCheckIn(attendeeId);
        if (isCheckedIn.isPresent()) throw new CheckInAlreadyExistsException("Attendee already checked in");
    }

    public Optional<CheckIn>  getCheckIn(String attendeeId){
        return this.checkinRepository.findByAttendeeId(attendeeId);
    }
}
