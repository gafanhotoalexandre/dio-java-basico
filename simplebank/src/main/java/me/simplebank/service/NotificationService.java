package me.simplebank.service;

import me.simplebank.domain.model.user.User;

public interface NotificationService {

    void sendNotification(User user, String message) throws Exception;
}
