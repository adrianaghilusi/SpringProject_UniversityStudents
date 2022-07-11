package com.students.students.dto;

public class StudentDTO {
    public String sfirstname;
    public String slastname;
    public String email;
    public String phone;

    public StudentDTO(String sfirstname, String slastname, String email, String phone) {
        this.sfirstname = sfirstname;
        this.slastname = slastname;
        this.email = email;
        this.phone = phone;
    }
}
