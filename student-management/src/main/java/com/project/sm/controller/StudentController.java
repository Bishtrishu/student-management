package com.project.sm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.sm.DAO.StudentDAOimpl;
import com.project.sm.DAO.StudentDAO;
import com.project.sm.api.Student;
import com.project.sm.service.StudentService;


@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@GetMapping({"/showStudent","/"})
	public String showStudentList(Model model) {
		// call the SERVICE method to get the data

		List<Student> studentList = studentService.loadStudents();

		//for (Student tempStudent : studentList) {
		//	System.out.println(tempStudent);
		//}
		model.addAttribute("students", studentList);

		return "student-list";
	}

	@GetMapping("/showAddStudentPage")
	public String addStudentList(Model model) {
		
		Student student=new Student();
		model.addAttribute("student",student);
		
		
		return "add-student";
	}


	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		
		System.out.println(student);
		
		//do a condition check
		//If the user doesn't have an id do a insert
		//If the user does a id -> do a update
		
		if(student.getId()==0){
			
			//insert a new record 
			studentService.saveStudent(student);
		}
		else {
			
			//do an update
			studentService.update(student);
			
		}
		
		//do a SERVICE call to save the student data
		//studentService.saveStudent(student);
		
		return "redirect:/showStudent";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		
		// We should give the user object who clicked on the update button
		System.out.println("Looking data for the student having id: "+ id);
		
		Student thestudent = studentService.getStudent(id);
		System.out.println(thestudent);
		
		//setting the student information 
		model.addAttribute("student", thestudent);
		return "add-student";
	}
	
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		
		//capture the id of the student whom you are trying to delete
		//once capture id , do a service call to delete
		
		studentService.deleteStudent(id);
		
		
		return "redirect:/showStudent";
	}
	
}
