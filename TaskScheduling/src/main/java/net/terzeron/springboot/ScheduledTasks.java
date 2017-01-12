package net.terzeron.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by terzeron on 2017. 1. 9..
 */
@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000) // 특정 메소드가 일정 시각마다 실행되도록 스케쥴링 (fixedDelay를 쓰거나 cron을 사용할 수 있음)
    public void reportCurrentTime() {
        log.info("The time is now {}" , dateFormat.format(new Date()));
    }
}
