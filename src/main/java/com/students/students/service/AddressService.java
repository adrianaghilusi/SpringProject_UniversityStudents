package com.students.students.service;

import com.students.students.dto.AddressDTO;
import com.students.students.model.Address;
import com.students.students.model.Student;
import com.students.students.repository.AddressRepository;
import com.students.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressService {
private final AddressRepository addressRepository;
private final StudentRepository studentRepository;
    public AddressService(AddressRepository addressRepository, StudentRepository studentRepository) {
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
    }
    public Address convertDTOtoModel(AddressDTO addressDTO){
        return new Address(addressDTO.homeAddress,addressDTO.county, addressDTO.city);
    }
    public Address createAddress(AddressDTO address) throws Exception {
        Optional<Student> studentOptional = studentRepository.findById(address.getSid());
        Student s = new Student();
        if(studentOptional.isPresent())
            s = studentOptional.get();
        else throw new Exception("nu merge");
        Address a = convertDTOtoModel(address);
        a.setStudent(s);
        return addressRepository.save(a);
    }
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address updateAddress(AddressDTO address, Integer addId) throws Exception {
        var addConv = convertDTOtoModel(address);
        var whichAddress = addressRepository.getById(addId);
        if(!addConv.getHomeAddress().isEmpty())
            whichAddress.setHomeAddress(addConv.homeAddress);
        if(!addConv.getCity().isEmpty())
            whichAddress.setCity(addConv.city);
        if(!addConv.getCounty().isEmpty())
            whichAddress.setCounty(addConv.county);
        if(!Objects.equals(address.getSid(), whichAddress.getStudent().getSid())){
            Optional<Student> studentOptional = studentRepository.findById(address.getSid());
            Student s = new Student();
            if(studentOptional.isPresent())
                s = studentOptional.get();
            else throw new Exception("nu merge");
            whichAddress.setStudent(s);
        }
        return addressRepository.save(whichAddress);
    }
}
