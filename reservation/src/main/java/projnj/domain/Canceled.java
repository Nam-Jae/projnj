package projnj.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import projnj.domain.*;
import projnj.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String hospitalId;
    private String hospitalName;
    private String address;

    public Canceled(Reservation aggregate) {
        super(aggregate);
    }

    public Canceled() {
        super();
    }
}
//>>> DDD / Domain Event
