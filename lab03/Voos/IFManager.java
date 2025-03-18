package lab03.Voos;

import java.io.File;

public interface IFManager {
    public Flight addFlight(File file);
    public Flight addFlight(String flightCode, int touristRows, int touristColumns, int executiveRows, int executiveColumns);
    public String printFlightSeats(String flightCode);
    public int reserveSeats(String flightCode, int seats, SeatType type);
    public void cancelReservations(String flightCode, int reservationCode);
}
