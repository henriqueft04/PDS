package startypes;
import java.awt.Color;

public class GStar extends StarType{
    protected static GStar typeInstance = null;

    public GStar() {
        super(1, new Color(245, 250, 250));
        this.description = "This is a long description of the G type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static GStar getStar() {
        if (typeInstance == null) {
            typeInstance = new GStar();
        }
        return typeInstance;
    }
}
