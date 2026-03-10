package org.example.ticketbookingsystem;

import org.example.ticketbookingsystem.ticketbooking.BookingSimulation;

/**
 * Main class is now just an entry point.
 * It delegates the actual simulation to BookingSimulation.
 */
public class Main {
    public static void main(String[] args) {
        BookingSimulation simulation = new BookingSimulation();
        simulation.runSimulation(50, 100, 10);
        // 50 tickets, 100 users, 10 threads
    }
}

