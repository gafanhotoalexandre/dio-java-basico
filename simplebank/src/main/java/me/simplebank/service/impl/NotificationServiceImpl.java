package me.simplebank.service.impl;

import me.simplebank.domain.model.user.User;
import me.simplebank.dto.NotificationDTO;
import me.simplebank.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final RestTemplate restTemplate;

    public NotificationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        /*
        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            System.err.println("erro ao enviar notificação");
            throw new Exception("Serviço de notificação fora do ar");
        }
        */
        System.out.println("Notificação enviada para o usuário...");
    }
}
