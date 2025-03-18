package startypes;
import java.awt.Color;

public class KStar extends StarType{
    protected static KStar typeInstance = null;

    public KStar() {
        super(1, new Color(230, 160, 10));
        this.description = "This is a long description of the K type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static KStar getStar() {
        if (typeInstance == null) {
            typeInstance = new KStar();
        }
        return typeInstance;
    }
}
