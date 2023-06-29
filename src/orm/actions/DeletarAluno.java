package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class DeletarAluno {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		try (Scanner input = new Scanner(System.in)) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
			EntityManager manager = factory.createEntityManager();
			
			System.out.print("ID(para deletar): ");
			Long id = input.nextLong();
			aluno.setId(id);
			aluno = manager.find(Aluno.class, aluno.getId());
			
			manager.getTransaction().begin();
			manager.remove(aluno);
			manager.getTransaction().commit();
			
			System.out.println("Aluno Excluído.");
			
			manager.close();
			factory.close();
		}

	}

}