package com.ctl.sbt.demo.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.time.LocalDateTime;

@Slf4j
@Component
public class NewsScheduler {

    @Autowired
    NewsJob newsJob;

    @Scheduled(cron = "${spring.newsapi.org.cron}")
    public void scheduleNews() throws JsonProcessingException, MessagingException {
        log.info("scheduleNews Started on "+ LocalDateTime.now());
        newsJob.sendMailLatestNews();
    }

}
