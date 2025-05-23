package startypes;
import java.awt.Color;

public class FStar extends StarType{
    protected static FStar typeInstance = null;

    public FStar() {
        super(2, new Color(255, 255, 245));
        this.description = "This is a long description of the F type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static FStar getStar() {
        if (typeInstance == null) {
            typeInstance = new FStar();
        }
        return typeInstance;
    }
}
