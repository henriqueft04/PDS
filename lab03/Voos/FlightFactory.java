package lab03.Voos;

public class FlightFactory {

    public static Flight getFlight(String code, int touristRows, int touristColumns, int executiveRows, int executiveColumns) {
        
        if (code == null || code.isEmpty()) {
            return null;
        }

        if (touristRows <= 0 || touristColumns <= 0 || executiveRows < 0 || executiveColumns < 0) {
            return null;
        }

        Plane plane = new Plane(touristRows, touristColumns, executiveRows, executiveColumns);
        return new Flight(code, plane);
    }

}
