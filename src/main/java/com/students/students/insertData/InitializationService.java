package com.students.students.insertData;

import com.students.students.model.Address;
import com.students.students.model.Student;
import com.students.students.repository.AddressRepository;
import com.students.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InitializationService {
    private final MockDataRepo mockDataRepo;
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    @Bean
    public void initData(){
        List<Address> addressList =  mockDataRepo.initAddress();
        List<Student> studentList =  mockDataRepo.initStudents();
        studentRepository.saveAll(studentList);
        int i =0;
        for(var s : addressList){
            s.setStudent(studentList.get(i++));
        }
      addressRepository.saveAll(addressList);
    }
}
