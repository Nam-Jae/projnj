package projnj.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import projnj.DispatchApplication;
import projnj.domain.Dispatched;

@Entity
@Table(name = "Dispatch_table")
@Data
//<<< DDD / Aggregate Root
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String carId;

    private String carType;

    private String workerId;

    private String dispatchTime;

    @PostPersist
    public void onPostPersist() {
        Dispatched dispatched = new Dispatched(this);
        dispatched.publishAfterCommit();
    }

    public static DispatchRepository repository() {
        DispatchRepository dispatchRepository = DispatchApplication.applicationContext.getBean(
            DispatchRepository.class
        );
        return dispatchRepository;
    }

    //<<< Clean Arch / Port Method
    public static void getHelp(Called called) {
        //implement business logic here:

        /** Example 1:  new item 
        Dispatch dispatch = new Dispatch();
        repository().save(dispatch);

        Dispatched dispatched = new Dispatched(dispatch);
        dispatched.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(called.get???()).ifPresent(dispatch->{
            
            dispatch // do something
            repository().save(dispatch);

            Dispatched dispatched = new Dispatched(dispatch);
            dispatched.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
