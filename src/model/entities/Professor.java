package model.entities;

import exception.DadosInvalidosException;
import model.entities.enums.CargoEnums.Cargo;
import model.entities.enums.MateriaEnums.Materia;

public class Professor extends Pessoa{
	private Double salario;
	private Materia disciplina; 
	
		public Professor(Cargo cargo,String nome, Integer idade, Double altura, Double salario, Materia disciplina) throws DadosInvalidosException {
			super(cargo,nome,idade,altura);
			
			if(salario <= 0) { 
				throw new DadosInvalidosException("Erro: salario invalido!"); 
				}
			if(disciplina == null) { 
				throw new DadosInvalidosException("Erro: disciplina invalida!");
				}
			
			this.salario = salario;
			this.disciplina = disciplina;
			
			
		}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Materia getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Materia disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return super.toString()
				+ "\nSalario: R$" + getSalario()
				+ "\nDisciplina: " + getDisciplina();
	}
	
	
	
}
