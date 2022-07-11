package com.students.students.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="address")
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer addressId;
public String homeAddress;
public String county;
@OneToOne
@JoinColumn(name="sid",referencedColumnName = "sid")
public Student student;
public String city;

    public Address(String homeAddress, String county, String city) {
        this.homeAddress = homeAddress;
        this.county = county;
        this.city = city;
    }
}
