package com.cg.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Valid
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Integer accountNo;

	 @Size(min=3, max=10, message = "Username cannot be empty")
	 private String typeOfAccount;
	 private double balance;


}
