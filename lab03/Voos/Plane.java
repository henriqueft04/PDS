package lab03.Voos;

public class Plane {
    private int[][] touristSeats;
    private int[][] executiveSeats;

    public Plane(int touristRows, int touristColumns, int executiveRows, int executiveColumns) {
        this.touristSeats = new int[touristRows][touristColumns];
        this.executiveSeats = new int[executiveRows][executiveColumns];
    }

    public int[][] getSeats(SeatType type) {
        if (type == SeatType.TOURIST) {
            return this.touristSeats;
        } else if (type == SeatType.EXECUTIVE) {
            return this.executiveSeats;
        } else {
            return null;
        }
    }

    public void setSeat(int row, int column, int reserveNumber, SeatType type) {
        if (type == SeatType.EXECUTIVE) {
            this.executiveSeats[row][column] = reserveNumber;
        } else if (type == SeatType.TOURIST) {
            this.touristSeats[row][column] = reserveNumber;
        }
    }

}
