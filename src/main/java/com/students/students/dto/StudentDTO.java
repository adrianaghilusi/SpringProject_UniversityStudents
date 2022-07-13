package com.students.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class StudentDTO {
    private String sfirstname;
    private String slastname;
    private String email;
    private String phone;
    private Integer sid;


}
