package org.example.ticketbookingsystem.ticketbooking;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * BookingTask represents a single user trying to book tickets.
 * Each task runs in its own thread when submitted to ExecutorService.
 *
 * Responsibilities:
 * - Generate a random ticket request (between 1 and 3).
 * - Call the TicketBookingSystem to attempt booking.
 * - Return true if booking succeeded, false otherwise.
 */
public class BookingTask implements Callable<Boolean> {
    private final TicketBookingSystem system; // shared booking system
    private final String user;                // user name (e.g., "User-1")
    private final Random random = new Random();

    /**
     * Constructor to initialize with system and user name.
     * @param system the shared TicketBookingSystem instance
     * @param user   the name of the user (thread identifier)
     */
    public BookingTask(TicketBookingSystem system, String user) {
        this.system = system;
        this.user = user;
    }

    /**
     * The call() method is executed when the task runs in a thread.
     * It generates a random ticket request and attempts booking.
     * @return true if booking succeeded, false otherwise
     */
    @Override
    public Boolean call() {
        int requested = random.nextInt(3) + 1; // random number between 1 and 3
        return system.bookTickets(user, requested);
    }
}
