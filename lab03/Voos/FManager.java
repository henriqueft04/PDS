package lab03.Voos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class FManager implements IFManager {
    private Map<String, Flight> flights;
    private int reservationCode;

    public FManager() {
        this.flights = new HashMap<>();
        this.reservationCode = 0;
    }

    @Override
    public Flight addFlight(File file) {
        /*
         * File format:
         * >flight_code executive_rowsxexecutive_columns tourist_rowsxtourist_columns
         * T/E num
         * T/E num
         * ...
         */

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            String[] flightInfo = scanner.nextLine().split(" ");
            String flightCode = flightInfo[0];
            
            if (flightCode.charAt(0) != '>') {
                System.err.println("Invalid file format");
                scanner.close();
                return null;
            }


            int executiveRows = 0;
            int executiveColumns = 0;
            int touristRows = 0;
            int touristColumns = 0;

            if (flightInfo.length == 3) {
                executiveRows = Integer.parseInt(flightInfo[1].split("x")[0]);
                executiveColumns = Integer.parseInt(flightInfo[1].split("x")[1]);
                touristRows = Integer.parseInt(flightInfo[2].split("x")[0]);
                touristColumns = Integer.parseInt(flightInfo[2].split("x")[1]);
            } else if ( flightInfo.length == 2) {
                executiveRows = 0;
                executiveColumns = 0;
                touristRows = Integer.parseInt(flightInfo[1].split("x")[0]);
                touristColumns = Integer.parseInt(flightInfo[1].split("x")[1]);
            } else {
                System.err.println("Invalid file format");
                scanner.close();
                return null;
            }

            flightCode = flightCode.substring(1);

            Flight f = this.addFlight(flightCode, touristRows, touristColumns, executiveRows, executiveColumns);
            
            if (f == null) {
                scanner.close();
                return null;
            }

            while (scanner.hasNextLine()) {
                String[] seatInfo = scanner.nextLine().split(" ");
                char type = seatInfo[0].charAt(0);
                int num_seats = Integer.parseInt(seatInfo[1]);

                this.reserveSeats(flightCode, num_seats, SeatType.fromChar(type));
            }

            scanner.close();

            return f;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            return null;
        }
    }

    @Override
    public Flight addFlight(String flightCode, int touristRows, int touristColumns, int executiveRows, int executiveColumns) {
        if (this.flightCodeValid(flightCode)) {
            return null;
        }

        Flight f = FlightFactory.getFlight(flightCode, touristRows, touristColumns, executiveRows, executiveColumns);
        this.flights.put(flightCode, f);

        return f;
    }


    @Override
    public String printFlightSeats(String flightCode) {
        String result = "";

        // Check if flight exists
        if (!this.flightCodeValid(flightCode)) {
           return null; 
        }

        Flight f = this.flights.get(flightCode);
        int[][] touristSeatMap = f.getSeats(SeatType.TOURIST);
        int[][] executiveSeatMap = f.getSeats(SeatType.EXECUTIVE);

        int touristRows = touristSeatMap.length;
        int touristColumns = touristSeatMap[0].length;
        int executiveRows = executiveSeatMap.length;
        int executiveColumns = 0;
        if (executiveRows != 0) {
            executiveColumns = executiveSeatMap[0].length;
        }

        int totalRows = touristRows + executiveRows;
        int totalColumns = Math.max(touristColumns, executiveColumns);

        // Print lines numbers
        result += " ";
        for (int i = 1; i <= totalRows; i++) {
            result += String.format(" %2d", i);
        }
        result += "\n";

        // Print seats (first executive, then tourist)
        // The seat map is printed in horizontal order (columns first, then rows)
        for (int i = 0; i < totalColumns; i++) {
            result += String.format("%c", i + 'A');
            for (int j = 0; j < totalRows; j++) {
                if (j < executiveRows && i < executiveColumns) {
                    result += String.format(" %2d", executiveSeatMap[j][i]);
                } else if (j >= executiveRows && i < touristColumns) {
                    result += String.format(" %2d", touristSeatMap[j - executiveRows][i]);
                } else {
                    result += "   ";
                }
            }
            result += "\n";
        }

        return result;
    }

    @Override
    public int reserveSeats(String flightCode, int seats, SeatType type) {
        if (!this.flightCodeValid(flightCode) || seats <= 0) {
            return -1;
        }

        Flight f = this.flights.get(flightCode);
        int[][] seatMap = f.getSeats(type);


        // Verify if there are enough seats
        if (this.countEmptySeats(seatMap) < seats) {
            return 0;
        }

        this.reservationCode++;

        int remainingSeats = seats;

        // Search for an empty row
        for (int i = 0; i < seatMap.length; i++) {
            if (isRowEmpty(seatMap[i])) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    if (remainingSeats == 0) {
                        return this.reservationCode;
                    }

                    seatMap[i][j] = this.reservationCode;
                    f.setSeat(i, j, this.reservationCode, type);
                    remainingSeats--;
                }
            }
        }

        // If there are no empty rows, search for empty seats
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                if (remainingSeats == 0) {
                    return this.reservationCode;
                }

                if (seatMap[i][j] == 0) {
                    seatMap[i][j] = this.reservationCode;
                    remainingSeats--;
                }
            }
        }

        return 0;
    }

    @Override
    public void cancelReservations(String flightCode, int reservationCode) {
        if (!this.flightCodeValid(flightCode)) {
            return;
        }

        Flight f = this.flights.get(flightCode);
        int[][] touristSeats = f.getSeats(SeatType.TOURIST);
        int[][] executiveSeats = f.getSeats(SeatType.EXECUTIVE);

        // Reservation can be in either tourist or executive seats
        // If it's in neither, the array will be traversed and nothing will happen
        removeReservation(executiveSeats, reservationCode);
        removeReservation(touristSeats, reservationCode);
    }


    private boolean isRowEmpty(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private int countEmptySeats(int[][] seatMap) {
        int count = 0;
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                if (seatMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private void removeReservation(int[][] seatMap, int reservationCode) {
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                if (seatMap[i][j] == reservationCode) {
                    seatMap[i][j] = 0;
                }
            }
        }
    }

    private boolean flightCodeValid(String flightCode) {
        return this.flights.containsKey(flightCode);
    }

}
