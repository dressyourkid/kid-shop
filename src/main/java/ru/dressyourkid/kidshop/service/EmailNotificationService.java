package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailNotificationService implements NotificationService {

    private Properties mailProps;

    @Value("${notification.email.sender}")
    private String sender;
    @Value("${notification.email.password}")
    private String password;
    @Value("${notification.email.smtpHost}")
    private String smtpHost;
    @Value("${notification.email.smtpPort}")
    private String smtpPort;

    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    @PostConstruct
    public void init() {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        mailProps = new Properties();
        mailProps.setProperty("mail.smtps.host", smtpHost);
        mailProps.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        mailProps.setProperty("mail.smtp.socketFactory.fallback", "false");
        mailProps.setProperty("mail.smtp.port", smtpPort);
        mailProps.setProperty("mail.smtp.socketFactory.port", smtpPort);
        mailProps.setProperty("mail.smtps.auth", "true");

        /*
        If set to false, the QUIT command is sent and the connection is immediately closed. If set
        to true (the default), causes the transport to wait for the response to the QUIT command.

        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
                http://forum.java.sun.com/thread.jspa?threadID=5205249
                smtpsend.java - demo program from javamail
        */
        mailProps.put("mail.smtps.quitwait", "false");
    }

    @Override
    public void notify(String addressee, String message) throws Exception {
        notify(addressee, "", message);
    }

    @Override
    public void notify(String addressee, String subject, String message) throws Exception {
        Session session = Session.getInstance(mailProps, null);
        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(sender));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addressee, false));

        msg.setSubject(subject);
        msg.setText(message, "utf-8");
        msg.setSentDate(new Date());

        Transport t = session.getTransport("smtps");

        t.connect(smtpHost, sender, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
    }

}
