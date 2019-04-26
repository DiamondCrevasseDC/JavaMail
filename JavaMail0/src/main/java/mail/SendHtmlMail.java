package mail;

import XMLProcessor.Process;
import XMLProcessor.Row;
import util.StringUtil;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class SendHtmlMail {

    /**
     * @param smtpHost 邮箱smtp服务器地址，在邮箱设置里可以看到
     * @param from 发件人邮箱
     * @param to 收件人邮箱，多个收件人邮箱用逗号分隔
     * @param cc 抄送人邮箱，多个抄送人邮箱用逗号分隔
     * @param subject 邮件主题
     * @param messageText 邮件内容
     * @throws MessagingException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void sendMessage(String smtpHost, String from, String to,String cc,String subject, String messageText) throws MessagingException,
            java.io.UnsupportedEncodingException {

        // Step 1: Configure the mail session
        System.out.println("Configuring mail session for: " + smtpHost);
        java.util.Properties props = new java.util.Properties();
        props.setProperty("mail.smtp.auth", "true");// 指定是否需要SMTP验证
        props.setProperty("mail.smtp.host", smtpHost);// 指定SMTP服务器
        props.put("mail.transport.protocol", "smtp");
        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);// 是否在控制台显示debug信息

        // Step 2: Construct the message
        System.out.println("Constructing message -  from=" + from + "  to=" + to);
        InternetAddress fromAddress = new InternetAddress(from);
        InternetAddress toAddress = new InternetAddress(to);
        InternetAddress[] internetAddressCC = InternetAddress.parse(cc);
        MimeMessage testMessage = new MimeMessage(mailSession);
        testMessage.setRecipients(Message.RecipientType.CC, internetAddressCC);
        testMessage.setFrom(fromAddress);
        testMessage.addRecipient(javax.mail.Message.RecipientType.TO, toAddress);
        testMessage.setSentDate(new java.util.Date());
        testMessage.setSubject(MimeUtility.encodeText(subject, "gb2312", "B"));

        testMessage.setContent(messageText, "text/html;charset=gb2312");
        System.out.println("Message constructed");

        // Step 3: Now send the message
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(smtpHost, "邮箱前缀", "密码或smtp密码");
        transport.sendMessage(testMessage, testMessage.getAllRecipients());
        transport.close();

        System.out.println("Message sent!");
    }
}
