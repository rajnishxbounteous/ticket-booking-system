package org.example.ticketbookingsystem.ticketbooking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * BookingSimulation coordinates the entire ticket booking process.
 *
 * Responsibilities:
 * - Initialize TicketBookingSystem
 * - Create ExecutorService and submit BookingTask objects
 * - Collect results from futures
 * - Delegate reporting to SummaryReport
 * - Measure execution time
 */
public class BookingSimulation {

    public void runSimulation(int initialTickets, int userCount, int threadPoolSize) {
        long start = System.currentTimeMillis();

        TicketBookingSystem system = new TicketBookingSystem(initialTickets);

        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<Boolean>> futures = new ArrayList<>();

        // Simulate multiple users
        for (int i = 1; i <= userCount; i++) {
            futures.add(executor.submit(new BookingTask(system, "User-" + i)));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Count successful bookings
        int successfulBookings = 0;
        for (Future<Boolean> future : futures) {
            try {
                if (future.get()) {
                    successfulBookings++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Calculate tickets sold and remaining
        int soldTickets = initialTickets - system.getAvailableTickets();
        int remainingTickets = system.getAvailableTickets();

        // Print final summary
        FinalBookingSummary.printReport(initialTickets, soldTickets, remainingTickets);

        long end = System.currentTimeMillis();
        System.out.println("\nTotal Execution time: " + (end - start) + " ms");
    }
}
