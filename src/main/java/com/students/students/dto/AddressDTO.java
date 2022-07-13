package com.students.students.dto;

import com.students.students.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AddressDTO {
private Integer addressId;
private String homeAddress;
private String county;
private Integer sid;
private String city;
}
