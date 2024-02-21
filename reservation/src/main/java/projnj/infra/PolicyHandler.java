package projnj.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import projnj.config.kafka.KafkaProcessor;
import projnj.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ReservationRepository reservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Dispatched'"
    )
    public void wheneverDispatched_MakeReservation(
        @Payload Dispatched dispatched
    ) {
        Dispatched event = dispatched;
        System.out.println(
            "\n\n##### listener MakeReservation : " + dispatched + "\n\n"
        );

        // Sample Logic //
        Reservation.makeReservation(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
