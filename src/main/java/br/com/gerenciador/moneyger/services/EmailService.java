package br.com.gerenciador.moneyger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador.moneyger.resources.form.EmailForm;

@RestController
@RequestMapping(value = "/email")
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@CrossOrigin
	@PostMapping
	public String sendMail(@RequestBody EmailForm email) {
		SimpleMailMessage message = new SimpleMailMessage();
//		message.setText("Lorem ipsum dolor sit amet");
//		message.setSubject("Teste");
		message.setText(email.getTitulo() + "\n" + "\n" + email.getMensagem());
		message.setSubject(email.getAssunto());
		message.setTo("moneyger8076@gmail.com");

		mailSender.send(message);
		return "Email enviado com sucesso!";
	}
}
