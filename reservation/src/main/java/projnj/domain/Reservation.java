package projnj.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import projnj.ReservationApplication;
import projnj.domain.Canceled;
import projnj.domain.Reserved;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hospitalId;

    private String hospitalName;

    private String address;

    @PostPersist
    public void onPostPersist() {
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();

        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void makeReservation(Dispatched dispatched) {
        //implement business logic here:

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        Reserved reserved = new Reserved(reservation);
        reserved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(dispatched.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);

            Reserved reserved = new Reserved(reservation);
            reserved.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelReservation(DispatchCanceled dispatchCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        Canceled canceled = new Canceled(reservation);
        canceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(dispatchCanceled.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);

            Canceled canceled = new Canceled(reservation);
            canceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
