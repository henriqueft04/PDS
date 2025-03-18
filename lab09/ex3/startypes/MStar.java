package startypes;
import java.awt.Color;

public class MStar extends StarType{
    protected static MStar typeInstance = null;

    public MStar() {
        super(1, Color.RED);
        this.description = "This is a long description of the M type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static MStar getStar() {
        if (typeInstance == null) {
            typeInstance = new MStar();
        }
        return typeInstance;
    }
}
