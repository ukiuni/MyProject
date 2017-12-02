package com.ukiuni.education.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ukiuni.education.myproject.controller.repository.RegistaionRepository;
import com.ukiuni.education.myproject.entity.Registation;

@RestController
@RequestMapping("api/registrations")
public class RegistationController {
	@Autowired
	private RegistaionRepository registationRepository;

	@PostMapping
	public Registation regist(@RequestParam String mail) {
		Registation registation = new Registation();
		registation.setMail(mail);
		return registationRepository.save(registation);
	}

}
