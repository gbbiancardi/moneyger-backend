package br.com.gerenciador.moneyger.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
//		SimpleMailMessage message = new SimpleMailMessage();
////		message.setText("Lorem ipsum dolor sit amet");
////		message.setSubject("Teste");
//		message.setText(email.getTitulo() + "\n" + "\n" + email.getMensagem());
//		message.setSubject(email.getAssunto());
//		message.setTo("moneyger8076@gmail.com");
//
//		mailSender.send(message);
//		return "Email enviado com sucesso!";
		try {
			MimeMessage mail = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo("moneyger8076@gmail.com");
			helper.setSubject(email.getAssunto());
			helper.setText("<b>Título: " + email.getTitulo() + "</b>\n\n" + "<p>Mensagem:</p>\n" + "<p>"
					+ email.getMensagem() + "</p>", true);
			mailSender.send(mail);

			return "Email enviado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao enviar e-mail";
		}
	}
}
