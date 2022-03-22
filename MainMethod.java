package com.spring;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainMethod
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("Cfg.xml");
		JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		StudentD d=(StudentD)context.getBean("studentD");
		do {
			System.out.println("Enter your choice :");
			System.out.println("1.Insert 2.Delete 3.Update 4.Select 5.Exit");
			int n=sc.nextInt();
			switch(n) {
			case 1:System.out.println("Insertion");
			Student s1=new Student();
			System.out.println("Enter Id :");
			s1.setStudentId(sc.nextInt());
			System.out.println("Enter Name :");
			s1.setStudentName(sc.next());
			System.out.println("Enter Gender :");
			s1.setStudentGender(sc.next());
			System.out.println("Enter marks :");
			s1.setStudentMarks(sc.nextInt());
			System.out.println("Enter phone number : ");
			s1.setMobileNum(sc.nextLong());
			int status=d.insertStudent(s1);
			System.out.println(status);
			break;


			case 2:System.out.println("deletion");
			Student s2=new Student();
			s2.setStudentId(sc.nextInt());
			int status1=d.deleteStudent(s2);
			System.out.println(status1);
			break;

			case 3:System.out.println("Enter the studentId whose information is to be updated");
			int status2=sc.nextInt();
			 System.out.println("a.Update studentName  b.Update studentGender c. Update studentMarks d.Update mobileNum ");
			 char ch1=sc.next().charAt(0);
		        switch(ch1) {
		        case 'a':
		        	String query2="update student set studentName=? where studentId=?";
		        System.out.println("Enter the studentName to which the name is to be updated");
		        String S1=sc.next();
		        template.update(query2,S1,status2);
		        break;
		        case 'b':
		        	String query3="update student set studentGender=? where studentId=?";
		        System.out.println("Enter the student gender to which the gender is to be updated");
		        String s5=sc.next();
		        template.update(query3,s5,status2);
		        break;
		        case 'c':
		        	String query4="update student set studentMarks=? where studentId=?";
		        System.out.println("Enter the studentMarks to which the marks is to be updated");
		        String S2=sc.next();
		        template.update(query4,S2,status2);
		        break;
		        case 'd':
		        	String query5="update student set mobileNum=? where studentId=?";
		        System.out.println("Enter the student mobileNum to which the mobileNum is to be updated");
		        String S3=sc.next();
		        template.update(query5,S3,status2);
		        break;}
		        System.out.println("Record updated.. ");
		        break;
		        
			
			/*case 3:System.out.println("Updation");
			//System.out.println("1.Update ID 2.Update Name 3.Update Gender 4.Update Marks 5.Update phnumber 6.Exit");
			Student s3=new Student();
			System.out.println("Enter student Id to be updated:");
			s3.setStudentId(sc.nextInt());
			System.out.println("Enter student name to be updated:");
			s3.setStudentName(sc.next());
			System.out.println("Enter student marks to be updated:");
			s3.setStudentMarks(sc.nextInt());
			System.out.println("Enter student phone number to be updated:");
			s3.setMobileNum(sc.nextLong());
	
			int status2=d.updateStudent(s3);
			System.out.println(status2);
			break;*/
			
			case 4:System.out.println("Selecting");
			Student s4=new Student();
			List<Student> w=d.selectStudent(s4);
			for (Student r : w) {
				System.out.println(r.getStudentId()+"     "+r.getStudentName()+"     "+r.getStudentGender()+"     "+r.getStudentMarks()+"     "+r.getMobileNum());
			}
			break;

			case 5:System.out.println("exiting");
			System.exit(0);
			break;
			}
		}while(true);
		/*Student s1=new Student();
		s1.setStudentId(1);
		s1.setStudentName("Medha");
		s1.setStudentGender("Female");
		s1.setStudentMarks(988);
		s1.setMobileNum(8919111111L);
		s1.setStudentAddress("Kukatpally");
		int status=d.insertStudent(s1);
		System.out.println(status);*/
		//System.out.println(student1.getStudentId()+ " "+student1.getStudentName()+" "+student1.getStudentGender()+" "+student1.getStudentMarks());
	}
}