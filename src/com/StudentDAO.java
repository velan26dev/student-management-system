package com;

import java.util.*;
import java.sql.*;

public class StudentDAO {

	public boolean addStudent(Student s) {
		try (Connection c = DBConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setInt(1, s.getRollNo());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getEmail());
			ps.setDouble(5, s.getMark());
			
			return ps.executeUpdate() > 0; //1 > 0 -- 0 > 0
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Student getStudentByRollNo(int rollNo) {
		Student s = null;
		try (Connection c = DBConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("select * from student where rollNo = ?");
			ps.setInt(1, rollNo);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		try (Connection c = DBConnection.getConnection()) {

			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			while (rs.next()) {
				Student s = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateStudent(Student s) {
		try (Connection c = DBConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("update student SET name = ?, age = ?, email = ?, mark = ? where rollNo = ?");
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setString(3, s.getEmail());
			ps.setDouble(4, s.getMark());
			ps.setInt(5, s.getRollNo());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteStudent(int rollNo) {
		try (Connection c = DBConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("delete from student where rollNo = ?");
			ps.setInt(1, rollNo);

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
