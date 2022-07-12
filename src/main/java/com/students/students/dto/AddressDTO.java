package com.students.students.dto;

import com.students.students.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {
public String homeAddress;
public String county;
public String city;
public Integer sid;
}
