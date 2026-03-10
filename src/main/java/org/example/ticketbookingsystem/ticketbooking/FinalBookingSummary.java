package org.example.ticketbookingsystem.ticketbooking;

/**
 * SummaryReport is responsible for printing the final ticket sales summary.
 *
 * Responsibilities:
 * - Display initial tickets, total tickets sold, and remaining tickets.
 * - Keep reporting logic separate from booking logic (clean design).
 */
public class FinalBookingSummary {

    /**
     * Prints the final summary of ticket sales.
     * @param initialTickets number of tickets available at the start
     * @param sold           total tickets successfully booked
     * @param remaining      tickets left after all booking attempts
     */
    public static void printReport(int initialTickets, int sold, int remaining) {
        System.out.println("\n----------------------------------");
        System.out.println("Summary");
        System.out.println("----------------------------------");
        System.out.println("Initial Tickets: " + initialTickets);
        System.out.println("Total Tickets Sold: " + sold);
        System.out.println("Remaining Tickets: " + remaining);
    }
}
