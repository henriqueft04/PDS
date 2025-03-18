package ex1;

import java.util.ArrayList;
import java.util.List;

public class Rental {
	private String nome;
	private String codigoPostal;
	private String email;
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();

	public Rental(String nome, String codigoPostal, String email) {
		setNome(nome);
		setCodigoPostal(codigoPostal);
		setEmail(email);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void addVeiculo(Veiculo veiculo) {
		if (this.veiculos.contains(veiculo))
			return;
		this.veiculos.add(veiculo);
	}

	public void removeVeiculo(Veiculo veiculo) {
		for (int i = 0; i < this.veiculos.size(); i++) {
			this.veiculos.remove(i);
		}
	}

	public Veiculo[] getStock() {
		return this.veiculos.toArray(new Veiculo[0]);
	}

	@Override
	public String toString() {
		String str = "Empresa:\n";
		str += "     " + this.getNome() + "\n";
		str += "     " + this.getCodigoPostal() + "\n";
		str += "     " + this.getEmail() + "\n";
		str += "Veiculos:\n";
		for (Veiculo veiculo : this.veiculos) {
			str += "     " + veiculo.toString() + "\n";
		}
		return str;
	}
}
