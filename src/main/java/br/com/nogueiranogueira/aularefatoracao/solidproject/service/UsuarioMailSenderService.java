package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import org.springframework.stereotype.Service;

@Service
public class UsuarioMailSenderService {

    private final SmtpEmailService smtpEmailService;

    public UsuarioMailSenderService(SmtpEmailService smtpEmailService) {
        this.smtpEmailService = smtpEmailService;
    }

    public void enviarEmailBoasVindas(String email, String nome) {

        String assunto = "Bem-vindo!";
        String mensagem = "Olá " + nome + ", seu cadastro foi realizado com sucesso.";

        smtpEmailService.sendEmail(email, assunto, mensagem);
    }
}
