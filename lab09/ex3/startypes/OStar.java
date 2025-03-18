package startypes;
import java.awt.Color;

public class OStar extends StarType{
    protected static OStar typeInstance = null;

    public OStar() {
        super(5, new Color(225, 250, 250));
        this.description = "This is a long description of the O type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static OStar getStar() {
        if (typeInstance == null) {
            typeInstance = new OStar();
        }
        return typeInstance;
    }
}
