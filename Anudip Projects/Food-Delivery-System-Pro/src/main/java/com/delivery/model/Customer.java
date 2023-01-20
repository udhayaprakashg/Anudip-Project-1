package com.delivery.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sequence_id")
	@SequenceGenerator(sequenceName = "sequence_id", allocationSize = 1, name = "sequence_id")
	private Long cus_id;

	@NotBlank(message = "Enter Your Name")
	@Column(name = "customer_name")
	private String cus_name;

	@Column(name = "customer_email", length = 25)
	@NotNull(message = "It is Null - Provide Your Name")
	@NotBlank(message = "Blank email Id Not Acceptable - Enter Your Email Id")
	@Email(message = "Provide Proper Email Id")
	private String cus_email;

	@Column(name = "customer_phoneNO")
	private Long cus_phoneNo;

	@Column(name = "customer_address")
	private String cus_address;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	@JsonIgnoreProperties("customer")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Cart> productList = new ArrayList<>();

}