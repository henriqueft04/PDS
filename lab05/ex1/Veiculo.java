package ex1;

import java.util.ArrayList;

public abstract class Veiculo implements KmPercorridosInterface {
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private ArrayList<Integer> percursos = new ArrayList<Integer>();

    Veiculo(String matricula, String marca, String modelo, int potencia) {
        setMarca(marca);
        setMatricula(matricula);
        setModelo(modelo);
        setPotencia(potencia);
    }

    protected void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    protected void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    protected void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void trajeto(int quilometros) {
        percursos.add(quilometros);
    }

    public int ultimoTrajeto() {
        if (percursos.size() == 0) return 0;
        return percursos.get(percursos.size() - 1);
    }

    public int distanciaTotal() {
        int sum = 0;
        for(Integer d : this.percursos)
            sum += d;
        return sum;
    }

    @Override
    public String toString() {
        String str = "Marca: " + this.getMarca() + "; Modelo: " + this.getModelo() + "; Matricula: " + this.getMatricula() + "; Distancia Total: " + this.distanciaTotal() + "; Ultimo trajeto: " + this.ultimoTrajeto();
        return str;
    }

    public boolean equals(Veiculo obj) {
        return obj.getMatricula() == this.getMatricula();
    }
}
