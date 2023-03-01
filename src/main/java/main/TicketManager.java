package main;

import repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {

        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.matchesFrom(from) && ticket.matchesTo(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result, comparator);
            }
        }
        return result;
    }
}
