package com.ctl.sbt.demo.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class NewsJob {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.newsapi.org.apiKey:89bc90c10d874953b5eeb59749ee66d9123}")
    private String apiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendMailLatestNews() throws JsonProcessingException, MessagingException {
        String newsUlr = "https://newsapi.org/v2/top-headlines?country=in&apiKey="+apiKey;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> newsResp = restTemplate.getForEntity(newsUlr,String.class);

        JsonNode customerRoot= objectMapper.readTree(newsResp.getBody());

        sendMail(customerRoot);
    }

    private void sendMail(JsonNode customerRoot) throws MessagingException {
        int totalResults = customerRoot.path("totalResults").asInt();
        String headLines = "<ol><li>";

        for(JsonNode article : customerRoot.path("articles")){
            headLines = headLines + "</li><li>"+article.path("title").asText()+"<br>";
        }
        headLines= headLines +"</li></ol>";

        MimeMessage msg = javaMailSender.createMimeMessage();

        msg.addRecipients(Message.RecipientType.TO,
                InternetAddress.parse("manjunatha.d@centurylink.com"));

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setFrom("manjunatha.d@centurylink.com");

        SimpleDateFormat curSdf = new SimpleDateFormat("dd/MM/yyyy");
        String curDate = curSdf.format(new Date());

        helper.setSubject("News Headline:"+curDate);
        helper.setText("Hi All,<br>" +
                "Following is the india news for the day.<br><br>" + headLines +"<br>"+
                "Regards<br>" +
                "News Reader - (Auto Generated)", true);

        javaMailSender.send(msg);
    }
}
