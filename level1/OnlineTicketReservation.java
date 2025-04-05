class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
	}
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }

        System.out.println("Ticket booked successfully: " + ticketID);
    }

    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = tail;
        boolean found = false;

        do {
            if (current.ticketID == ticketID) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket ID not found.");
            return;
        }

        if (current == head && current == tail) { // only one ticket
            head = tail = null;
        } else {
            prev.next = current.next;
            if (current == head)
                head = current.next;
            if (current == tail)
                tail = prev;
        }

        System.out.println("Ticket removed: " + ticketID);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("Current Booked Tickets:");
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No matching tickets found.");
    }

    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

public class OnlineTicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "Alice", "Inception", "A1", "12:00 PM");
        system.addTicket(2, "Bob", "Interstellar", "B2", "1:00 PM");
        system.addTicket(3, "Charlie", "Inception", "A2", "12:00 PM");

        system.displayTickets();

        system.searchTicket("Inception");

        System.out.println("Total tickets: " + system.countTickets());

        system.removeTicket(2);
        system.displayTickets();
    }
}
