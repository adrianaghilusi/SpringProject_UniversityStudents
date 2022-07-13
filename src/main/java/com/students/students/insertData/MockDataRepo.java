package com.students.students.insertData;

import com.students.students.model.Address;
import com.students.students.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class MockDataRepo {
    public static final Integer numberOfEntities = 5;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public List<Student> initStudents(){
        List<Student> studentList =  new ArrayList<>();
        for(int i=1; i< numberOfEntities; i++){
            var num = (Math.random() * (10 - 5)) + 5;
            Student s = new Student("firstname"+i,"lastname"+i, "email"+i, "phone"+i,Double.parseDouble(df.format(num)));
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
