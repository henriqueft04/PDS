package startypes;
import java.awt.*;

public class Star {
    private StarType type;
    private int x;
    private int y;

    public Star(StarType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(type.getColor());
        g.fillOval(x, y , type.getSize(), type.getSize());
    }
}
