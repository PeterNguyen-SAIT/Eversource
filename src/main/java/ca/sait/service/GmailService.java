package ca.sait.service;

import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;

/**
 * Gmail service class used to send email to customers
 */
@Service
public class GmailService {
    /**
     * Send Mail function to read from template and call the other Send Mail function
     * @param email
     * @param subject
     * @param template
     * @param tags
     */
    public static void sendMail1(String email, String subject,
                                 String template, HashMap<String, String> tags) {
        try {
            // read in template in to a string
            BufferedReader br = new BufferedReader(new FileReader(new File(template)));
            String line = br.readLine();
            String body = "";
            while(line != null) {
                body += line;
                line = br.readLine();
            }

            // replace all heart tags with values
            for(String tag : tags.keySet()) {
                body = body.replace("%" + tag + "%", tags.get(tag));

            }

            // send email
            sendMail2(email, subject, body, true);

        } catch (IOException | MessagingException | NamingException ex) {
            Logger.getLogger(GmailService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Send mail function to retrieve connection to smtp and all other required params to send mails
     * @param to
     * @param subject
     * @param body
     * @param bodyIsHTML
     * @throws MessagingException
     * @throws NamingException
     */
    public static void sendMail2(String to, String subject, String body, boolean bodyIsHTML) throws MessagingException, NamingException {
        //Context env = (Context)new InitialContext().lookup("java:comp/env");
        String username = "AdminEmail@gmail.com";//(String)env.lookup("webmail-username");
        String password = "AdminEmailPassword";//(String)env.lookup("webmail-password");

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", "465");
        //props.put("mail.smtp.starttls.enable","true" );
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        //props.put("mail.smtp.connectiontimeout", "1000");
        //props.put("mail.smtp.timeout", "1000");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        // create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // address the message
        //Address fromAddress = new InternetAddress(username);
        Address toAddress = new InternetAddress(to);
        //message.setFrom("cprg352@sait.ca");
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // send the message
        Transport transport = session.getTransport();
        transport.connect(username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
