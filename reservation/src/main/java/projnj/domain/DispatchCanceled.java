package projnj.domain;

import java.util.*;
import lombok.*;
import projnj.domain.*;
import projnj.infra.AbstractEvent;

@Data
@ToString
public class DispatchCanceled extends AbstractEvent {

    private Long id;
    private String carId;
    private String carType;
    private String workerId;
    private String dispatchTime;
}
