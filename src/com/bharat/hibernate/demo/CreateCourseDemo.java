package com.bharat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.hibernate.demo.entity.Course;
import com.bharat.hibernate.demo.entity.Instructor;
import com.bharat.hibernate.demo.entity.InstructorDetails;

public class CreateCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(InstructorDetails.class)
				                                    .addAnnotatedClass(Instructor.class)
				                                    .addAnnotatedClass(Course.class)
				                                    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int theId = 1;
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, theId);
			Course tempCourse1 = new Course("The SuperMario - Classic");
			Course tempCourse2 = new Course("Learn Guitar in 15 hours");
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}


