package com.students.students.service;

import com.students.students.repository.AddressRepository;

public class AddressService {
private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}
