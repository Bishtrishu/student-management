package com.project.sm.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.sm.api.Student;
import com.project.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOimpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Student> loadStudent() {

		List<Student> studentList = new ArrayList<Student>();

		String sql = "select * from students;";

		List<Student> theListOfStudents = jdbcTemplate.query(sql, new StudentRowMapper());

		return theListOfStudents;
	}

	public void saveStudent(Student student) {

		// Write the logic to store the student object into the database

		Object[] sqlParameters = { student.getName(), student.getMobile(), student.getCountry() };

		String sql = "insert into students(name,mobile,country) values(?,?,?);";

		jdbcTemplate.update(sql, sqlParameters);

		System.out.println("1 record Inserted....");

	}

	public Student getStudent(int id) {

		String sql = "select * from students where id=?;";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);

		return student;
	}

	public void update(Student student) {

		String sql = "update students set name=?,mobile=?,country=? where id=?;";
		jdbcTemplate.update(sql, student.getName(), student.getMobile(), student.getCountry(), student.getId());
		System.out.println("1 record updated");

	}

	public void deleteStudent(int id) {

		String sql="Delete from students where id=?;";
		jdbcTemplate.update(sql,id);
		System.out.println("1 record deleted");
		
	}

}
