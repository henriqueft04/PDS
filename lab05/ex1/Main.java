package ex1;

/**
 * WARNING: This class is not the main class of the exercise.
 * 			To test the classes created in the PDS exercise
 * 			you should run the EmpresaAluguer class.
 */
public class Main {
	public static void main(String[] args) {
		Rental tap = new Rental("TAP - TRANSPORTES AÉREOS PORTUGUESES, SGPS, S.A.", "1700-008",
				"customer@tapmilesandgo.com");

		Motociclo moto = new Motociclo("AA-BB-00", "Yamaha", "faieownf", 100, Tipo.DESPORTIVO);
		PMercadorias pm1 = new PMercadorias("CC-DD-11", "Tesla", "CyberTruck", 100, "10498", 9500, 80000);

		tap.addVeiculo(moto);
		tap.addVeiculo(pm1);

		System.out.println(moto.equals(pm1));
		System.out.println(tap);
	}
}
