package lab03.Voos;

public class Flight {
    private Plane plane;
    private String code;

    public Flight(String code, Plane plane) {
        this.setPlane(plane);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    protected void setCode(String code) {
        this.code = code;
    }

    protected void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int[][] getSeats(SeatType type) {
        return this.plane.getSeats(type);
    }

    public void setSeat(int row, int column, int reserveNumber, SeatType type) {
        this.plane.setSeat(row, column, reserveNumber, type);
    }
}
