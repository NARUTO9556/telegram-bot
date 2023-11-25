package pro.sky.telegrambot.Services;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.Entity.Notification;
import pro.sky.telegrambot.Repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final TelegramBot telegramBot;

    public NotificationServiceImpl(NotificationRepository notificationRepository, TelegramBot telegramBot) {
        this.notificationRepository = notificationRepository;
        this.telegramBot = telegramBot;
    }

    @Override
    public void sendNotification(LocalDateTime dateTime) {
        List<Notification> tasks = notificationRepository.findAllByDateTime(dateTime);
        tasks.forEach(t-> {
            telegramBot.execute(new SendMessage(t.getChatId(), t.getText()));
        });
    }
}
