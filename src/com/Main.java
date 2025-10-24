package com;

import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Student Management System...🎓");
		StudentDAO dao = new StudentDAO();
		int choice;
		do {
			System.out.println("\n---Student Menu---");
			System.out.println("1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. View All Students");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("0. Exit");

			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1 -> {
				System.out.print("Enter RollNo: ");
				int rollNo = sc.nextInt();
				System.out.print("Enter Name: ");
				String name = sc.next();
				System.out.print("Enter Age: ");
				int age = sc.nextInt();
				System.out.print("Enter Email: ");
				String email = sc.next();
				System.out.print("Enter Mark: ");
				double mark = sc.nextDouble();

				Student s = new Student(rollNo, name, age, email, mark);
				if (dao.addStudent(s))
					System.out.println("Student added successfully 🤗");
				else
					System.out.println("Student not added 😥");
			}
			case 2 -> {
				System.out.print("Enter Student RollNo: ");
				int rollNo = sc.nextInt();

				Student s = dao.getStudentByRollNo(rollNo);
				if (s != null)
					System.out.println(s);
				else
					System.out.println("Student not found 😥");
			}
			case 3 -> {
				List<Student> list = dao.getAllStudents();
				if (!list.isEmpty()) {
					for (Student s : list)
						System.out.println(s);
				} else
					System.out.println("Students not found 😥");
			}
			case 4 -> {
				System.out.print("Enter Student RollNo for update: ");
				int rollNo = sc.nextInt();

				Student existing = dao.getStudentByRollNo(rollNo);
				System.out.println(existing);

				System.out.print("\nEnter updated name: ");
				String name = sc.next();
				System.out.print("Enter updated age: ");
				int age = sc.nextInt();
				System.out.print("Enter updated email: ");
				String email = sc.next();
				System.out.print("Enter updated mark: ");
				double mark = sc.nextDouble();

				Student updated = new Student(rollNo, name, age, email, mark);
				if (dao.updateStudent(updated)) // true
					System.out.println("Student record updated successfully 🤗");
				else
					System.out.println("Student record not updated 😥");
			}
			case 5 -> {
				System.out.print("Enter Student RollNo for delete: ");
				int rollNo = sc.nextInt();

				if (dao.deleteStudent(rollNo))
					System.out.println("Student deleted successfully 🤗");
				else
					System.out.println("Student not deleted 😥");
			}
			case 0 -> {
				System.out.println("\n\t\tThanks for Using Student Management System...❤️");
				System.out.println("\t\t\t---Have a Nice✨ Day🥰---");
			}
			default -> System.out.println("Invalid choice❌ Try again...");
			}
		} while (choice != 0);
	}

}
