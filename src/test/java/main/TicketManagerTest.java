package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager =  new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 23_000, "VKO", "BCN", 5);
    Ticket ticket2 = new Ticket(23, 13_500, "VKO", "VNC", 6);
    Ticket ticket3 = new Ticket(30, 11_300, "VKO", "VNC", 6);
    Ticket ticket4 = new Ticket(34, 15_000, "VKO", "VNC", 6);
    Ticket ticket5 = new Ticket(33, 12_000, "SVO", "VNC", 6);
    Ticket ticket6 = new Ticket(41,20_500, "VKO", "VNC", 6);
    Ticket ticket7 = new Ticket(39,18_500, "VKO", "VNC", 6);
    Ticket ticket8 = new Ticket(55,18_500, "VKO", "VNC", 6);

    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
    }

    @Test
    public void findAllWhenSome() {

        Ticket[] expected = {ticket3, ticket2, ticket4, ticket7, ticket8, ticket6};
        Ticket[] actual = manager.findAll("VKO", "VNC");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllWhenOne() {

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("SVO", "VNC");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllWhenNone() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVO", "BCN");

        Assertions.assertArrayEquals(expected, actual);
    }



}
