import entities.*;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    private static final String URL = "http://localhost:8081/mediator";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();    
        calendar.set(2021,8, 30);

        System.out.println("Let`s add arena");

        Arena arena1 = new Arena("Olympiskii","Vasylkivska str, 55", 40001);
        HttpEntity<Arena> postArena = new HttpEntity<>(arena1);
        ResponseEntity<Void> response = restTemplate.exchange(URL, HttpMethod.POST, postArena, Void.class);

        System.out.println("Let`s add one lessee\n");

        Lessee lessee1 = new Lessee("Cool Manager", "050-333-2222", "coolman@mail.com");
        HttpEntity<Lessee> postLessee = new HttpEntity<>(lessee1);
        ResponseEntity<Void> response2  = restTemplate.exchange(URL, HttpMethod.POST, postLessee, Void.class);


        System.out.println("Let`s add concert\n");

        Concert concert1 = new Concert("Bring Me The Horizon", "Music", arena1, calendar.getTime());
        HttpEntity<Concert> postConcert = new HttpEntity<>(concert1);
        ResponseEntity<Void> response3  = restTemplate.exchange(URL, HttpMethod.POST, postConcert, Void.class);

        System.out.println("3 visitors bought tickets\n");

        Visitor visitor1 = new Visitor("Artem Pogorelov", "067-589-2524");

        HttpEntity<Visitor> postVisitor = new HttpEntity<>(visitor1);
        ResponseEntity<Void> response4  = restTemplate.exchange(URL, HttpMethod.POST, postVisitor, Void.class);

        Visitor visitor2 = new Visitor("Rita Yusupova", "098-874-2544");

        postVisitor = new HttpEntity<>(visitor2);
        response4  = restTemplate.exchange(URL, HttpMethod.POST, postVisitor, Void.class);

        Visitor visitor3 = new Visitor("Kylo Ren", "050-242-2433");

        postVisitor = new HttpEntity<>(visitor3);
        response4  = restTemplate.exchange(URL, HttpMethod.POST, postVisitor, Void.class);

        Ticket ticket1 = new Ticket(visitor1, concert1, 1000);

        Ticket ticket2 = new Ticket(visitor2, concert1, 1000);

        Ticket ticket3 = new Ticket(visitor3, concert1, 1000);

        HttpEntity<Ticket> postTicket = new HttpEntity<>(ticket1);
        ResponseEntity<Void> response5  = restTemplate.exchange(URL, HttpMethod.POST, postTicket, Void.class);

        postTicket = new HttpEntity<>(ticket2);
        response5  = restTemplate.exchange(URL, HttpMethod.POST, postTicket, Void.class);

        postTicket = new HttpEntity<>(ticket3);
        response5  = restTemplate.exchange(URL, HttpMethod.POST, postTicket, Void.class);


    }
}


