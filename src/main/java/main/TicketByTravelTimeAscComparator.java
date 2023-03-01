package main;

import java.util.Comparator;

public class TicketByTravelTimeAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.travelTime < o2.travelTime) {
            return -1;
        } else if (o1.travelTime > o2.travelTime) {
            return 1;
        } else {
            return 0;
        }
    }
}
