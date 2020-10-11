package com.bharat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.hibernate.demo.entity.Course;
import com.bharat.hibernate.demo.entity.Instructor;
import com.bharat.hibernate.demo.entity.InstructorDetails;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(InstructorDetails.class)
				                                    .addAnnotatedClass(Instructor.class)
				                                    .addAnnotatedClass(Course.class)
				                                    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int theId = 10;
			session.beginTransaction();
			Course tempCourse = session.get(Course.class, theId);
			session.delete(tempCourse);
			session.getTransaction().commit();
			session.beginTransaction();
			theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("\n\n" + tempInstructor);
			System.out.println("\n\n" + tempInstructor.getCourse());
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}


