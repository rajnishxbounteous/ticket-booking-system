package org.example.ticketbookingsystem;

/**
 * TicketBookingSystem is the core class that manages ticket availability.
 * It ensures thread-safe booking using synchronized methods.
 */
public class TicketBookingSystem {
    // Shared resource: number of tickets available
    private int availableTickets;

    /**
     * Constructor to initialize the system with total tickets.
     * @param totalTickets initial number of tickets available
     */
    public TicketBookingSystem(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    /**
     * Thread-safe booking method.
     * Only one thread can execute this at a time.
     * @param user name of the user requesting tickets
     * @param requested number of tickets requested
     * @return true if booking succeeded, false otherwise
     */
    public synchronized boolean bookTickets(String user, int requested) {
        if (requested <= availableTickets) {
            availableTickets -= requested; // reduce available tickets
            System.out.println(user + " requested " + requested + " → Booked → Remaining: " + availableTickets);
            return true;
        } else {
            System.out.println(user + " requested " + requested + " → Failed (Not enough tickets)");
            return false;
        }
    }

    /**
     * Getter for remaining tickets.
     * @return number of tickets still available
     */
    public int getAvailableTickets() {
        return availableTickets;
    }
}