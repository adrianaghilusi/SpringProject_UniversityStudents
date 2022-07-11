package com.students.students.service;

import com.students.students.model.Address;
import com.students.students.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {
private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
