package com.ukiuni.education.myproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;

import lombok.Data;

@Data
@Entity
public class Registation {
	@Id
	@GeneratedValue
	private long id;

	@Email
	private String mail;
}
