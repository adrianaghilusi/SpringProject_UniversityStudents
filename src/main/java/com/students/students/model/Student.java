package com.students.students.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 public Integer sid;
 public String sfirstname;
 public String slastname;
 public String email;
 public String phone;

 public Double grade;
 public Student(String sfirstname, String slastname, String email, String phone, Double grade ){
  this.sfirstname=sfirstname;
  this.slastname = slastname;
  this.email = email;
  this.phone = phone;
  this.grade = grade;
 }
}
