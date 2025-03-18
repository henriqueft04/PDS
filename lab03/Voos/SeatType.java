package lab03.Voos;

public enum SeatType {
    TOURIST('T'), EXECUTIVE('E');

    public char asChar() {
        return this.asChar;
    }

    private char asChar;

    private SeatType(char asChar) {
        this.asChar = asChar;
    }

    public static SeatType fromChar(char c) {
        for (SeatType st : SeatType.values()) {
            if (st.asChar == c) {
                return st;
            }
        }
        return null;
    }
}
