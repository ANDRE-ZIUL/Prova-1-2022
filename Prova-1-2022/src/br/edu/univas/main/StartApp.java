package br.edu.univas.main;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.univas.vo.Aluno;
import br.edu.univas.vo.Mestrado;
import br.edu.univas.vo.PosGraduacao;

public class StartApp {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Aluno alunoMest = new Mestrado();
		Aluno alunoPG = new PosGraduacao();
		Aluno student = new Aluno();
		ArrayList<Aluno> registeredStudents = new ArrayList<>();
		
		while(true) {
			printMenu();
			int option = readIntValue();
			
			if(option == 1) {
				registerStudent(student, registeredStudents, alunoMest, alunoPG);
			}else if(option == 2) {
				 printListPG(registeredStudents, alunoPG);
			}else if(option == 3) {
				printListMest(registeredStudents, alunoMest);
			}else if(option == 9) {
				System.out.println("Obrigado por usar a ferramenta!!! Até a próxima!!!");
				break;
			}else {
				System.out.println("Opção inválida!!! Digite uma opção válida!!!");
			}
		}
	}
	
	public static void printListMest(ArrayList<Aluno> registeredStudents, Aluno alunoMest) {
		System.out.println("LISTA DE ALUNOS EM MESTRADO: ");
		for(int i = 0; i < registeredStudents.size(); i++) {
			System.out.println("Nome: " + registeredStudents.get(i).getName());
			System.out.println("CPF: " + registeredStudents.get(i).getCpf());
			System.out.println("Email: " + registeredStudents.get(i).getEmail());
			System.out.println("------------------------------");
		}
		
	}
	
	public static void printListPG(ArrayList<Aluno> registeredStudents, Aluno alunoPG) {
		System.out.println("LISTA DE ALUNOS EM PÓS GRADUAÇÃO: ");
		for(int i = 0; i < registeredStudents.size(); i++) {
			System.out.println("Nome: " + registeredStudents.get(i).getName());
			System.out.println("CPF: " + registeredStudents.get(i).getCpf());
			System.out.println("Email: " + registeredStudents.get(i).getEmail());
			System.out.println("------------------------------");
		}
	}
	
	public static void registerStudent(Aluno student, ArrayList<Aluno> registeredStudents, Aluno alunoMest, Aluno alunoPG) {
		
		System.out.println("Cadastro de Aluno: ");
		System.out.println("Digite o nome do aluno: ");
		student.setName(scanner.nextLine());
		
		System.out.println("Digite o CPF do aluno: ");
		int cpf = readIntValue();
		
		System.out.println("Digite o email do aluno: ");
		student.setEmail(scanner.nextLine());
		
		System.out.println("Digite a categoria do aluno: \n1 - Mestrado \n2 - Pós Graduação");
		while(true) {
			int option = readIntValue();
			
			if(option == 1) {
				alunoMest = student;
				break;
			}else if(option == 2) {
				alunoPG = student;
				break;
			}else { 
				System.out.println("Opção inválida!!! Digite uma opção válida!!!");
			}
		}
		
		if(registeredStudents.size() != 0) {
			for(int i = 0; i < registeredStudents.size(); i++) {
				if(cpf == registeredStudents.get(i).getCpf()) {
					System.out.println("Aluno já cadastrado!!!");
				}else {
					student.setCpf(cpf);
					System.out.println("Aluno cadastrado com Sucesso!!!");
					registeredStudents.add(student);
				}
			}
		}else {
			student.setCpf(cpf);
			System.out.println("Aluno cadastrado com Sucesso!!!");
			registeredStudents.add(student);
		}
	}
		
	public static void printMenu() {
		System.out.println("MENU - Digite a opção desejada: \n1 - Cadastrar Aluno \n2 - Listar alunos Pós-graduação \n3 - Listar alunos Mestrado \n9 - Sair");
	}
	
	public static int readIntValue() {
		int value = scanner.nextInt();
		scanner.nextLine();
		return value;
	}
}
