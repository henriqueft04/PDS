package lab03.Voos;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;

public class Menu {

    public static void main(String[] args) {
        IFManager fManager = new FManager();

        Scanner scanner = new Scanner(System.in);
        String menu = "H - Help \n" +
                "I filename - flight Info  \n" +
                "M flight_code - flight reserve Map  \n" +
                "F flight_code num_seats_executive(opt) num_seats_tourists - add new Flight\n" +
                "R flight_code class number_seats - make Reservation \n" +
                "C reservation_code - Cancel reservation \n" +
                "Q - Quit \n";

        System.out.println("Escolha uma opção: (H para ajuda)");
        while (true) {

            String input = scanner.nextLine();
            Character choice = input.charAt(0);
            String flight_code_regex = "[A-Z]{2}[0-9]{4}";

            switch (Character.toUpperCase(choice)) {
                case 'H':
                    System.out.println(menu);
                    break;

                case 'I':
                    String[] parts = input.split(" ");
                    if (parts.length != 2 || !Pattern.matches(".*\\.txt", parts[1])) {
                        System.out.println("Invalid command");
                    } else {
                        File filename = new File(parts[1]);
                        // processar file
                        if (fManager.addFlight(filename) != null) {
                            System.out.println("Flight added");
                        } else {
                            System.err.println("Invalid file format");
                        }
                    }
                    break;

                case 'M':
                    String[] parts2 = input.split(" ");
                    if (parts2.length != 2 || !Pattern.matches(flight_code_regex, parts2[1])) {
                        System.err.println("Invalid command");
                    } else {
                        String flight_code = parts2[1];
                        // mostrar o print do mapa
                        String seatMap = fManager.printFlightSeats(flight_code);
                        if (seatMap == null) {
                            System.err.println("Flight not found");
                        } else {
                            System.out.println(seatMap);
                        }
                    }
                    break;

                case 'F':
                    String[] parts3 = input.split(" ");
                    if (!verifySeatsInput(parts3) || !Pattern.matches(flight_code_regex, parts3[1])) {
                        System.err.println("Invalid command");
                        break;
                    } else {
                        String flight_code = parts3[1];
                        int exe_rows = 0;
                        int exe_columns = 0;
                        int tour_rows = 0;
                        int tour_columns = 0;

                        if (parts3.length == 3) {
                            tour_rows = Integer.parseInt(parts3[2].split("x")[0]);
                            tour_columns = Integer.parseInt(parts3[2].split("x")[1]);
                        } else if (parts3.length == 4) {
                            exe_rows = Integer.parseInt(parts3[2].split("x")[0]);
                            exe_columns = Integer.parseInt(parts3[2].split("x")[1]);
                            tour_rows = Integer.parseInt(parts3[3].split("x")[0]);
                            tour_columns = Integer.parseInt(parts3[3].split("x")[1]);
                        } else {
                            System.err.println("Invalid command");
                            break;
                        }

                        // adicionar novo voo com os parametros
                        fManager.addFlight(flight_code, tour_rows, tour_columns, exe_rows, exe_columns);
                        System.out.println("Flight added");
                    }
                    break;

                case 'R':
                    String[] parts4 = input.split(" ");
                    if (parts4.length != 4 || !Pattern.matches(flight_code_regex, parts4[1])
                            || !Pattern.matches("[A-Z]", parts4[2]) || !Pattern.matches("[0-9]+", parts4[3])) {
                        System.err.println("Invalid command");
                    } else {
                        String flight_code = parts4[1];
                        String class_type = parts4[2];
                        int number_seats = Integer.parseInt(parts4[3]);
                        // adicionar reserva

                        int reservation_code = fManager.reserveSeats(flight_code, number_seats,
                                SeatType.fromChar(class_type.charAt(0)));
                        if (reservation_code == -1) {
                            System.err.println("Flight not found");
                        } else if (reservation_code == 0) {
                            System.err.println("Not enough seats");
                        } else {
                            System.out.println("Reservation code: " + flight_code + ":" + reservation_code);
                        }
                    }
                    break;

                case 'C':
                    String[] parts5 = input.split(" ");
                    String reservation_code_regex = "[A-Z]{2}[0-9]{4}:[0-9]+";
                    String reservation_code = "";
                    String flight_code = "";
                    int reservation_number = 1;
                    if (parts5.length != 2) {
                        System.err.println("Invalid command");
                    } else {
                        reservation_code = parts5[1];
                        flight_code = reservation_code.split(":")[0];
                        if (!Pattern.matches(reservation_code_regex, reservation_code)) {
                            System.err.println("Invalid command");
                            break;
                        }
                        reservation_number = Integer.parseInt(reservation_code.split(":")[1]);
                    }

                    fManager.cancelReservations(flight_code, reservation_number);
                    if (reservation_number == 0) {
                        System.err.println("Reservation not found");
                    } else {
                        System.err.println("Reservation cancelled");
                    }

                    break;

                case 'Q':
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid command");
                    break;
            }

        }
    }

    public static boolean verifySeatsInput(String[] parts) {
        return (parts.length == 3 || parts.length == 4)
                && Pattern.matches("[0-9]+x[0-9]+", parts[2])
                && (parts.length == 3 || Pattern.matches("[0-9]+x[0-9]+", parts[3]));
    }
}
