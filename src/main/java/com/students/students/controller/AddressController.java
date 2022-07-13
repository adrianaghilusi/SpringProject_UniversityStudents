package com.students.students.controller;

import com.students.students.dto.AddressDTO;
import com.students.students.model.Address;
import com.students.students.model.Student;
import com.students.students.service.AddressService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createAddress(AddressDTO address) throws Exception {
        Address address1  = addressService.createAddress(address);
        return "redirect:/addresses";
    }
    @RequestMapping(value = "/addAddress", method = RequestMethod.GET)
    public String addAddress(){
        return "../templates/addAddress";
    }
    @RequestMapping(value = "/updateAddress/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateAddress(@PathVariable (value = "id") Integer aId){
        Address add  = addressService.getById(aId);
        AddressDTO address =  new AddressDTO();
        address.setAddressId(add.getAddressId());
        address.setHomeAddress(add.getHomeAddress());
        address.setCity(add.getCity());
        address.setCounty(add.getCounty());
        address.setSid(add.getStudent().getSid());
        return new ModelAndView("../templates/updateAddress").addObject("address", address);
    }
    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateAddress(Model model,AddressDTO address) throws Exception {
        System.out.println(address.getAddressId());
        Address address1  = addressService.updateAddress(address,address.getAddressId());
        return "redirect:/addresses";
    }

    @RequestMapping(value = "/deleteAddress/{id}", method = RequestMethod.DELETE)
    public String deleteAddress(Model model, @RequestBody AddressDTO address, @PathVariable(name = "id") Integer addId) throws Exception {
        addressService.deleteAddress(address,addId);
        return "redirect:/addresses";
    }
}
