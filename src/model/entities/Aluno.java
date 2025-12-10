package model.entities;


import exception.DadosInvalidosException;
import model.entities.enums.CargoEnums.Cargo;
import model.entities.enums.MateriaEnums.Materia;

public class Aluno extends Pessoa{
	private Integer matricula;
	private Materia curso;
	
	
	public Aluno(Cargo cargo, String nome, Integer idade, Double altura, Integer matricula, Materia curso) throws DadosInvalidosException{
		super(cargo, nome, idade, altura);
		
		if(matricula == 0) {
			throw new DadosInvalidosException("Erro: matricula invalida!s");
		}
		
		if(curso == null) {
			throw new DadosInvalidosException("Erro: curso invalido!");
		}
		
		this.matricula = matricula;
		this.curso = curso;
	}


	public Integer getMatricula() {
		return matricula;
	}


	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}


	public Materia getCurso() {
		return curso;
	}


	public void setCurso(Materia curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return super.toString() 
				+ "\nMatricula: " + getMatricula() 
				+ "\nCurso: " + getCurso();
		}
	

}
