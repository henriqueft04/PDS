package ex1;

public class VehicleFactory {
	public static Veiculo createMotociclo(String matricula, String marca, String modelo, int cilindrada, String tipo) {
		if (tipo.equals("desportivo"))
			return new Motociclo(matricula, marca, modelo, cilindrada, Tipo.DESPORTIVO);
		else if (tipo.equals("estrada"))
			return new Motociclo(matricula, marca, modelo, cilindrada, Tipo.ESTRADA);
		else
			throw new IllegalArgumentException("Tipo de motociclo inválido");
	}

	public static Veiculo createAutomovelLigeiro(String matricula, String marca, String modelo, int cilindrada,
			String numQuadro, int capacidade) {
		return new Automovel(matricula, marca, modelo, cilindrada, numQuadro, capacidade);
	}

	public static Veiculo createTaxi(String matricula, String marca, String modelo, int cilindrada, String numQuadro,
			int capacidade, String licenca) {
		return new Taxi(matricula, marca, modelo, cilindrada, numQuadro, capacidade, licenca);
	}

	public static Veiculo createPPEletrico(String matricula, String marca, String modelo, int autonomia, int capacidade,
			String numQuadro, int potencia, int consumo, int carga) {
		return new PPassageirosEletrico(matricula, marca, modelo, autonomia, capacidade, numQuadro, potencia, consumo, carga);
	}

	public static Veiculo createALEletrico(String matricula, String marca, String modelo, int autonomia,
			String numQuadro,
			int potencia, int consumo, int carga) {
		return new AutomovelEletrico(matricula, marca, modelo, autonomia, numQuadro, potencia, consumo, carga);
	}

	public static Veiculo createPesadoMercadorias(String matricula, String marca, String modelo, int autonomia,
			String numQuadro, int carga, int capacidade) {
		return new PMercadorias(matricula, marca, modelo, autonomia, numQuadro, carga, capacidade);
	}

	public static Veiculo createPesadoPassageiros(String matricula, String marca, String modelo, int autonomia,
			int capacidade, String numQuadro, int carga) {
		return new PPassageiros(matricula, marca, modelo, autonomia, capacidade, numQuadro, carga);
	}
}
