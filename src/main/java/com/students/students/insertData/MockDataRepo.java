package com.students.students.insertData;

import com.students.students.model.Address;
import com.students.students.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class MockDataRepo {
    public static final Integer numberOfEntities = 5;
    public List<Student> initStudents(){
        List<Student> studentList =  new ArrayList<>();
        for(int i=1; i< numberOfEntities; i++){
            Student s = new Student("firstname"+i,"lastname"+i, "email"+i, "phone"+i );
            studentList.add(s);
        }
        return studentList;
    }
    public List<Address> initAddress(){
        List<Address> studentList =  new ArrayList<>();
        for(int i=1; i< numberOfEntities; i++){
            Address s = new Address("home"+i,"county"+i, "city"+i);
            studentList.add(s);
        }
        return studentList;
    }
}
