package projnj.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import projnj.domain.*;
import projnj.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Called extends AbstractEvent {

    private Long id;
    private String carId;
    private String driverName;
    private String position;
    private String accidentTime;

    public Called(Call aggregate) {
        super(aggregate);
    }

    public Called() {
        super();
    }
}
//>>> DDD / Domain Event
