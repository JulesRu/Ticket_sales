package main;

public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int travelTime;

    public Ticket(int id, int price, String from, String to, int travelTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public String getFrom() {

        return from;
    }

    public void setFrom(String departureAirport) {

        this.from = from;
    }

    public String getTo() {

        return to;
    }

    public void setTo(String to) {

        this.to = to;
    }

    public int getTravelTime() {

        return travelTime;
    }

    public void setTravelTime(int travelTime) {

        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean matchesFrom(String search) {
        if (getFrom().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesTo(String search) {
        if (getTo().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
