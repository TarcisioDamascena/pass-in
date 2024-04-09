package Damascena.passin.dto.event;

import Damascena.passin.domain.event.Event;
import lombok.Getter;

@Getter
public class EventResponseDTO {
    EventDetailDTO event;

    public EventResponseDTO(Event event, Integer numberOfAttendees)
    {
        this.event = new EventDetailDTO(event.getId(), event.getTitle(), event.getDetails(), event.getSlug(), event.getMaximumAttendees(), numberOfAttendees);
    }
}
