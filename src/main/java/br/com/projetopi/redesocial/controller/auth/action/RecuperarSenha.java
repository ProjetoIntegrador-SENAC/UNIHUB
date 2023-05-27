package br.com.projetopi.redesocial.controller.auth.action;


import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.AuthService;
import br.com.projetopi.redesocial.service.UsuarioService;
import br.com.projetopi.redesocial.util.RecuperarSenhaUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@WebServlet("/recupera-senha")
public class RecuperarSenha extends HttpServlet {

    private UsuarioService usuarioService;
    private AuthService authService;

    public RecuperarSenha(){
        this.usuarioService = new UsuarioService();
        this.authService = new AuthService();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipient = req.getParameter("emailUser");
        String recipientName = req.getParameter("nomeUser");

        //Pega emails
        List<String> emails = usuarioService.getUsuarioAll()
                .stream()
                .map(Usuario::getEmail)
                .collect(Collectors.toList());

        //Valida se email existe
        if(!emails.contains(recipient)){
            return;
        }

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        final String username = RecuperarSenhaUtils.EMAIL.getInfo();
        final String password = RecuperarSenhaUtils.SENHA.getInfo();

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try{

            // Pega a senha criptografada e descriptografa
            String passwordcyphed = usuarioService.getPasswordByEmail(recipient);
            String passwordDecyphed = authService.getPassword(passwordcyphed);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Recuperação de senha");
            message.setText("Prezado(a) " + recipientName +
                    "\nSegue sua senha para login: \n" +
                    passwordDecyphed +"\n" +
                    "Clique no link para retornar a página de login: http://localhost:8080");

            Transport.send(message);



            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e){
            e.printStackTrace();
        }

        resp.sendRedirect("/login?acao=ExibirTelaLogin");

    }

}
