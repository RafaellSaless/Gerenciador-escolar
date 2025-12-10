package model.entities;

import java.util.List;
import java.util.Scanner;

import exception.DadosInvalidosException;
import model.entities.enums.CargoEnums.Cargo;
import model.entities.enums.MateriaEnums.Materia;

import java.util.ArrayList;

public class Sistema {
	Scanner sc = new Scanner(System.in);
	
	List<Pessoa> listaPessoas = new ArrayList<>();
	
	public void cadastrarPessoa() {
		System.out.println("-----------");
		System.out.print("Aluno ou Professor? (a/p) "); 
		char tipo = sc.next().charAt(0);
		System.out.print("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Idade: ");
		int idade = sc.nextInt();
		System.out.print("Altura: ");
		Double altura = sc.nextDouble();
		
		if(tipo == 'a' || tipo == 'A') {
			System.out.print("Id matricula: ");
			int idMatricula = sc.nextInt();
			System.out.print("Curso: ");
			sc.nextLine();
			String cursoString = sc.nextLine();
		
			
			try {
				Materia curso = Materia.valueOf(cursoString.toUpperCase());
				Pessoa pessoa = new Aluno(Cargo.ALUNO,nome, idade, altura, idMatricula, curso);
				listaPessoas.add(pessoa);
			}
			catch(DadosInvalidosException e) {
				System.out.println(e.getMessage());
			}
			catch(IllegalArgumentException e) {
				System.out.println("Erro: materia não existe!");
			}
		} else if(tipo == 'p' || tipo == 'P') {
			System.out.print("Salario: R$");
			double salario = sc.nextDouble();
			System.out.print("Disciplina: ");
			sc.nextLine();
			String disciplinaString = sc.next();

			
			try{ 
				Materia disciplina = Materia.valueOf(disciplinaString.toUpperCase());
				Pessoa pessoa = new Professor(Cargo.PROFESSOR,nome,idade,altura,salario,disciplina);
				listaPessoas.add(pessoa);
			}
			catch(DadosInvalidosException e) {
				System.out.println(e.getMessage());
			}
			catch(IllegalArgumentException e) {
				System.out.println("Erro: materia não existe!");
			}
		} else {
			System.out.printf("Erro: Opção 'tipo' invalida! (%s)", tipo);
		}
		System.out.println("");
	}
	
	public void listarPessoas() {
		for(Pessoa pe: listaPessoas) {
			System.out.println(pe.getClass() + " - " + pe.getNome());
		}
	}
	
	public String buscarNome () {
		System.out.println();
		sc.nextLine();
		System.out.print("Digite o nome a procurar: ");
		String procurar = sc.nextLine();
		for(Pessoa pe: listaPessoas) {
			if(pe.getNome().trim().equalsIgnoreCase(procurar.trim())) {
					return pe.toString() + "\n";
			}
		}
		return "Nome não está na lista!";
	}
	
	public void removerPorNome() {
		System.out.print("Digite o nome para remover: ");
		String remover = sc.nextLine();
		for (int i = 0; i < listaPessoas.size(); i++) {
		    if (listaPessoas.get(i).getNome().equalsIgnoreCase(remover)) {
		        listaPessoas.remove(i);
		        System.out.println("Removido!");
		        return;
			}
		}
			System.out.println("Nome: '" + remover + "' não encontrado");
	}
	
	public void calcularIdades() {
		double mediaIdadeTodos =0;
		double mediaIdadeAlunos =0;
		double MediaIdadeProfessores =0;
		
		int quantAlunos =0;
		int quantProfs = 0;
		
		for(Pessoa p: listaPessoas) {
			mediaIdadeTodos += p.getIdade();
			if(p instanceof Professor) {
				MediaIdadeProfessores += p.getIdade();
				quantProfs +=1;
			} else {
				mediaIdadeAlunos += p.getIdade();
				quantAlunos +=1;
			} 
}
		if(listaPessoas.size() > 0) { 
			System.out.println("Media idade geral: " + (mediaIdadeTodos / listaPessoas.size())); } else { System.out.println("Sem pessoas cadastradas!"); }
		if(quantAlunos > 0) {
		System.out.println("Media Idade Alunos: " + (mediaIdadeAlunos / quantAlunos)); } else { System.out.println("Sem alunos cadastrados!"); }
		if(quantProfs > 0) {
		System.out.println("Media Idade Professores: " + (MediaIdadeProfessores / quantProfs ));} else {System.out.println("Sem professores cadastrados!");}
	}
	
	public void calcularSalarios() {
		double mediaSalarios =0;
		int quantProfs = 0;
		
		for(Pessoa p: listaPessoas) {
			if(p instanceof Professor) {
				mediaSalarios += ((Professor) p).getSalario();
				quantProfs +=1;
			}
		}
		if(quantProfs > 0) {
		System.out.println("Media de salarios dos professores: " + (mediaSalarios / quantProfs)); } else {System.out.println("Sem professores cadastrados!");}
				
				
	}
}
