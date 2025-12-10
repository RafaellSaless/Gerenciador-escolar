package model.entities;

import exception.DadosInvalidosException;
import model.entities.enums.CargoEnums.Cargo;

public abstract class Pessoa {
	private Cargo cargo;
	private String nome;
	private Integer idade;
	private Double altura;

	
	public Pessoa(Cargo cargo, String nome, Integer idade, Double altura) throws DadosInvalidosException {
        if (nome == null || nome.trim().isEmpty()) {
        		throw new DadosInvalidosException("Erro: nome está vazio!");
        } else if(idade <= 0 || altura <=0) {
        		throw new DadosInvalidosException("Erro: idade ou altura invalido!");
        } else {
        	
        		this.cargo = cargo;
			this.nome = nome;
			this.idade = idade;
			this.altura = altura;
        } 
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	public String toString() {
		return "Nome: " + getNome() +" - " + getCargo()
		+ "\nIdade: " + getIdade()
		+ "\nAltura: " + getAltura();
	}

	
	
	
	
}
