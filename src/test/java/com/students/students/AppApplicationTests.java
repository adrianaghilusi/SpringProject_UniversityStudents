package com.students.students;

import com.students.students.dto.StudentDTO;
import com.students.students.model.Student;
import com.students.students.repository.StudentRepository;
import com.students.students.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testFindByOrderByGradeAsc(){
		StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
		List<Student> studentList = new ArrayList<>();
		Student stud1 = new Student("a","b","c","d",9.88);
		Student stud2 = new Student("a","b","c","d",8.43);
		Student stud3 = new Student("a","b","c","d",7.56);
		studentList.add(stud3);
		studentList.add(stud2);
		studentList.add(stud1);
//		studentRepository.save(stud1);
//		studentRepository.save(stud2);
//		studentRepository.save(stud3);
		when(studentRepository.findByOrderByGradeAsc()).thenReturn(studentList);
		List<Student> studentListOrdered = new ArrayList<>();
		studentListOrdered.add(stud3);
		studentListOrdered.add(stud2);
		studentListOrdered.add(stud1);
		Assertions.assertEquals(studentList,studentListOrdered);

	}

	@Test
	public void testGetStudentsGradesSortedCustom(){
		StudentService studentService = mock(StudentService.class);
		List<StudentDTO> studentList = new ArrayList<>();
		StudentDTO stud1 = new StudentDTO("a","b","c","d",1,9.88);
		StudentDTO stud2 = new StudentDTO("a","b","c","d",2,8.43);
		StudentDTO stud3 = new StudentDTO("a","b","c","d",3,7.56);
		studentList.add(stud3);
		studentList.add(stud2);
		studentList.add(stud1);
		when(studentService.getStudentsGradesSortedCustom()).thenReturn(studentList);
		List<StudentDTO> studentListOrdered = new ArrayList<>();
		studentListOrdered.add(stud3);
		studentListOrdered.add(stud2);
		studentListOrdered.add(stud1);
		Assertions.assertEquals(studentList,studentListOrdered);

	}

}
