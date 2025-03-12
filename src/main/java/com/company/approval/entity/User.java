package com.company.approval.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@SequenceGenerator(name = "seq", initialValue = 100, allocationSize = 1, sequenceName = "user_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;
	private String name;
	private String email;
	private String password;
}
