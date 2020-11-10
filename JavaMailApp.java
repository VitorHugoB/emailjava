/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

/**
 *
 * @author Vitor
 */
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class JavaMailApp
{
  private String emailremetente;
  private String emaildestinatario;
  private String assunto;
  private String mensagem;
  private String senha;

    public JavaMailApp() {
    }

    public String getEmailremetente() {
        return emailremetente;
    }

    public void setEmailremetente(String emailremetente) {
        this.emailremetente = emailremetente;
    }

    public String getEmaildestinatario() {
        return emaildestinatario;
    }

    public void setEmaildestinatario(String emaildestinatario) {
        this.emaildestinatario = emaildestinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  
  
  void geraremail(){
    Properties props = new Properties();
    /** Parâmetros de conexão com servidor Gmail */
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class",
    "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props,
      new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication()
           {
                 return new PasswordAuthentication(emailremetente,senha);
           }
      });

    /** Ativa Debug para sessão */
    session.setDebug(true);

    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(emailremetente));
      //Remetente

      Address[] toUser = InternetAddress.parse(emaildestinatario);//destinatario

      message.setRecipients(Message.RecipientType.TO, toUser);
      message.setSubject(assunto);//Assunto
      message.setText(mensagem);
      /**Método para enviar a mensagem criada*/
      Transport.send(message);

      JOptionPane.showMessageDialog(null, "email enviado com sucesso");

     } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
  }
}
