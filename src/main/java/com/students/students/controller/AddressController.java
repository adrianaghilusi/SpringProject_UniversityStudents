package com.students.students.controller;

import com.students.students.dto.AddressDTO;
import com.students.students.model.Address;
import com.students.students.model.Student;
import com.students.students.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String createAddress(Model model, @RequestBody AddressDTO address) throws Exception {
        Address address1  = addressService.createAddress(address);
        return "redirect:/addresses";
    }
    @RequestMapping(value = "/updateAddress/{id}", method = RequestMethod.PUT)
    public String createAddress(Model model, @RequestBody AddressDTO address, @PathVariable(name = "id") Integer addId) throws Exception {
        Address address1  = addressService.updateAddress(address,addId);
        return "redirect:/addresses";
    }
}
