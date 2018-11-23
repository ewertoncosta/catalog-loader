package br.com.cvc.catalogloader.expedia.expediacatalogloader;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@Component
public class Worker implements CommandLineRunner {

    private RestTemplate restTemplate;
    private RabbitTemplate rabbitTemplate;
    private static final int HOTEL_ID = 1;

    @Autowired
    public Worker(RestTemplate restTemplate, RabbitTemplate rabbitTemplate){
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        String data = restTemplate.getForObject("http://api.ean.com/ean-services/rs/hotel/v3/files?cid=496955&sig=1e856abf867c8e267e2e9d39eb61d491&apiKey=6jnq9p9j55k8mqngbreh2hn5u7&filename=ActivePropertyList_pt_BR"
                                                ,String.class);
        Stream.of(data.split("\n")).map(line -> {
            String[] worker = line.split("|");
            return new
        }).forEach(hotelContent -> rabbitTemplate.convertAndSend("hotel-static-info.http://api.ean.com/ean-services/rs/hotel/v3/files?cid=496955&sig=1e856abf867c8e267e2e9d39eb61d491&apiKey=6jnq9p9j55k8mqngbreh2hn5u7&filename=ActivePropertyList_pt_BR",null,hotelContent));
    }
}
