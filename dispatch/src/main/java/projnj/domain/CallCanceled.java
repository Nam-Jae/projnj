package projnj.domain;

import java.util.*;
import lombok.*;
import projnj.domain.*;
import projnj.infra.AbstractEvent;

@Data
@ToString
public class CallCanceled extends AbstractEvent {

    private Long id;
    private String carId;
    private String driverName;
    private String position;
    private String accidentTime;
}
