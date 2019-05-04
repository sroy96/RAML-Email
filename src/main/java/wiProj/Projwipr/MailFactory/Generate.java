package wiProj.Projwipr.MailFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Generate {
    @Autowired
    private EmailService emailService;
    public void run(String s) throws Exception {
        Mail mail = new Mail();
        mail.setFrom("sauravarduino@gmail.com");
        mail.setTo("sauravarduino@gmail.com");
        mail.setSubject("GREETING FROM WIPRO DEV TEAM");
        mail.setContent("Check Attachment");

        emailService.sendSimpleMessage(mail,s);
    }
}
