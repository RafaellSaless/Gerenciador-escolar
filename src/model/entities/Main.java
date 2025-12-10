package model.entities;

import java.util.Locale;
import java.util.Scanner;

import exception.DadosInvalidosException;
import model.entities.enums.CargoEnums.Cargo;
import model.entities.enums.MateriaEnums.Materia;


public class Main {

	public static void main(String[] args) throws DadosInvalidosException {
		
		Locale.setDefault(Locale.US);
		Sistema sistema = new Sistema();
		Scanner sc = new Scanner(System.in);
		
		//Para usar de exemplo
		Pessoa prof = new Professor(Cargo.PROFESSOR,"Rafael", 123, 1.21, 1123.1, Materia.MATEMATICA);
		Pessoa alun = new Aluno(Cargo.ALUNO, "Henrique",123, 1.21, 1123, Materia.MATEMATICA);
		
		
		sistema.listaPessoas.add(alun);
		sistema.listaPessoas.add(prof);
		int opcao;
		do { 
			System.out.println("=-----= MENU ESCOLAR =-----=");
			System.out.println("1 - Cadastrar pessoas");
			System.out.println("2 - Listar Pessoas");
			System.out.println("3 - Remover Pessoas");
			System.out.println("4 - Pesquisar registros por nome");
			System.out.println("5 - Calcular M/ de idades ");
			System.out.println("6 - Calcular M/ salarial professores");
			System.out.println("0 - sair");
			System.out.print("Escolha a opção: ");
			opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				sistema.cadastrarPessoa();
				break;
			case 2: 
				sistema.listarPessoas();
				break;
			case 3: 
				sistema.removerPorNome();
				break;
			case 4:
				System.out.println(sistema.buscarNome());
				break;
			case 5:
				sistema.calcularIdades();
				break;
			case 6:
				sistema.calcularSalarios();
				break;
			default:
				if(opcao != 0) { 
				System.out.println("Opção invalida!!"); }
			};
			
		} while(opcao !=0);
		
		sc.close();
	}
}
