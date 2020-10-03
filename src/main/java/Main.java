import entities.*;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    private static final String URL = "http://localhost:8081";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();


    public static void main(String[] args) {
        headers.setContentType(MediaType.APPLICATION_JSON);

        Calendar calendar = new GregorianCalendar();
        calendar.set(2021,8, 30);

        System.out.println("Let`s add arena");

        Arena arena1 = new Arena();
        arena1.setName("Olympiskii");
        arena1.setAddress("Vasylkivska str, 55");
        arena1.setCapacity(40001);
        HttpEntity<Arena> postArena = new HttpEntity<>(arena1);
        ResponseEntity<Void> response = restTemplate.exchange(URL + "/arenas", HttpMethod.POST, postArena, Void.class);

        System.out.println("Let`s add one lessee\n");

        Lessee lessee1 = new Lessee();
        lessee1.setName("Cool Manager");
        lessee1.setPhoneNumber("050-333-2222");
        lessee1.setEmail("coolman@mail.com");
        HttpEntity<Lessee> postLessee = new HttpEntity<>(lessee1);
        ResponseEntity<Void> response2  = restTemplate.exchange(URL + "/lessees", HttpMethod.POST, postLessee, Void.class);


        System.out.println("Let`s add concert\n");

        Concert concert1 = new Concert();
        concert1.setArena(arena1);
        concert1.setDate(calendar.getTime());
        concert1.setName("Bring Me The Horizon");
        concert1.setType("Music");
        HttpEntity<Concert> postConcert = new HttpEntity<>(concert1);
        ResponseEntity<Void> response3  = restTemplate.exchange(URL + "/concerts", HttpMethod.POST, postConcert, Void.class);


        System.out.println("3 visitors bought tickets\n");

        Visitor visitor1 = new Visitor();
        visitor1.setName("Artem Pogorelov");
        visitor1.setPhoneNumber("067-589-2524");

        Visitor visitor2 = new Visitor();
        visitor2.setName("Rita Yusupova");
        visitor2.setPhoneNumber("098-874-2544");

        Visitor visitor3 = new Visitor();
        visitor3.setName("Kylo Ren");
        visitor3.setPhoneNumber("050-242-2433");

        Ticket ticket1 = new Ticket();
        ticket1.setVisitor(visitor1);
        ticket1.setConcert(concert1);
        ticket1.setPrice(1000);

        Ticket ticket2 = new Ticket();
        ticket1.setVisitor(visitor2);
        ticket1.setConcert(concert1);
        ticket1.setPrice(1000);

        Ticket ticket3 = new Ticket();
        ticket1.setVisitor(visitor3);
        ticket1.setConcert(concert1);
        ticket1.setPrice(1000);

        HttpEntity<Ticket> postTicket = new HttpEntity<>(ticket1);
        ResponseEntity<Void> response4  = restTemplate.exchange(URL + "/tickets", HttpMethod.POST, postTicket, Void.class);

        postTicket = new HttpEntity<>(ticket2);
        response4  = restTemplate.exchange(URL + "/tickets", HttpMethod.POST, postTicket, Void.class);

        postTicket = new HttpEntity<>(ticket3);
        response4  = restTemplate.exchange(URL + "/tickets", HttpMethod.POST, postTicket, Void.class);


    }
}
