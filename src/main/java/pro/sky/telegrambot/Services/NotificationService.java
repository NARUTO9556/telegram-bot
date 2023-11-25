package pro.sky.telegrambot.Services;

import java.time.LocalDateTime;

public interface NotificationService {
    void sendNotification(LocalDateTime dateTime);
}
