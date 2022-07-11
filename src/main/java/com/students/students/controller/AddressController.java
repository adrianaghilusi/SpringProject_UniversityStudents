package com.students.students.controller;

import com.students.students.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService add) {
        this.addressService = add;
    }

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        model.addAttribute("allAddresses",addressService.getAllAddresses() );
        return "../templates/allAddresses";
    }
}
