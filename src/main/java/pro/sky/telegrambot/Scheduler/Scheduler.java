package pro.sky.telegrambot.Scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.Services.NotificationService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
@Component
public class Scheduler {
    private final NotificationService notificationService;

    public Scheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void test() {
        notificationService.sendNotification(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
    }
}
