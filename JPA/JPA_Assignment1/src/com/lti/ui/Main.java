package com.lti.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        //Author author=new Author(4, "Dheeeraj", "v", "Soni", "1234");
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("JPA-PU"); //used for reading persistence_unit inside persitence.xml file which contains all db connection info.
		EntityManager entityManager=factory.createEntityManager(); // this object is used for handling lifecycle of entity. All CRUD op is performed by this object's methods.
		/*entityManager.getTransaction().begin();
		entityManager.persist(author);
		entityManager.getTransaction().commit();
		System.out.println("Author saved");*/
		
		// Read author
		/*System.out.println("After saving author  object");
		Author author1 = entityManager.find(Author.class, author.getAuthorID());
		System.out.println(author1);*/
		
		// fetching author based on id.
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the author: ");
		int id = sc.nextInt();
		Author author2 = entityManager.find(Author.class, id);
		System.out.println(author2);*/
		
		
		// update
		Author auth1 = entityManager.find(Author.class, 3);
		auth1.setFirstName("Shekhar");
		auth1.setLastName("Singh");
		System.out.println("After update author object: ");
		entityManager.getTransaction().begin(); 
		entityManager.merge(auth1);
		Author auth2 = entityManager.find(Author.class, auth1.getAuthorID());
		entityManager.getTransaction().commit();
		System.out.println(auth2);
		
		
		// remove author
		/*System.out.println("After removing author object: ");
		entityManager.getTransaction().begin(); 
		entityManager.remove(author2);
		entityManager.getTransaction().commit();
		author2 = entityManager.find(Author.class,author.getAuthorID());
		System.out.println(author2);
*/		
		
	}

}
