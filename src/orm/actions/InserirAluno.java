package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class InserirAluno {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		
		System.out.print("Data de Nascimento: ");
		String dataNascimento = sc.nextLine();
		
		System.out.print("Naturalidade: ");
		String naturalidade = sc.nextLine();
		
		System.out.print("Endereço: ");
		String endereco = sc.nextLine();
		
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setCpf(cpf);
		aluno.setDataNascimento(dataNascimento);
		aluno.setNaturalidade(naturalidade);
		aluno.setEndereco(endereco);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno inserido.");
		System.out.println("ID: " + aluno.getId());
		
		sc.close();
		manager.close();
		factory.close();

	}
	
}
