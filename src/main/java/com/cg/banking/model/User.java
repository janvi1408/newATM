package com.cg.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Valid
public class User {
private String userName;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int userId;
//@Size(min=4, message="Pin should be minimum of 4 digits")
@Min(value=1000, message="It should be of 4 digits")
@Max(value=9999, message="It should be of 4 digits")
private Integer pin;
private String mobileNumber;
}
