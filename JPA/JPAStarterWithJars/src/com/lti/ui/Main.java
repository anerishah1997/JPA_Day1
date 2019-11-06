package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {

		Student student = new Student(6,"Shekhar",69);
		//JPA Api
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("JPA-PU"); //used for reading persistence_unit inside persitence.xml file which contains all db connection info.
		EntityManager entityManager=factory.createEntityManager(); // this object is used for handling lifecycle of entity. All CRUD op is performed by this object's methods.
		entityManager.getTransaction().begin(); // for insert/update/delete we need transaction.. so open transaction
		entityManager.persist(student); // to save student object.
		entityManager.getTransaction().commit(); // transaction close with commit.
		System.out.println("Student object saved");
		
		// to read one object. Second parameter is the primary key. Based on that ot will fetch.
		System.out.println("After saving student object");
		Student stud1 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(stud1);
		// to read all objects
		/*for(int i=1;i<=3;i++)
		{
			Student stud = entityManager.find(Student.class, i);
			System.out.println(stud);
		}*/
		
		// update stud1 set avgScore.
		stud1.setAvgScore(70.0);
		System.out.println("After update student object: ");
		entityManager.getTransaction().begin(); 
		entityManager.merge(stud1);
		Student student2 = entityManager.find(Student.class, student.getRollNumber());
		entityManager.getTransaction().commit();
		System.out.println(student2);
		
		// to remove the object.
		
		System.out.println("After removing student object: ");
		entityManager.getTransaction().begin(); 
		entityManager.remove(student2);
		entityManager.getTransaction().commit();
		student2 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student2);
		
		
	}

}
