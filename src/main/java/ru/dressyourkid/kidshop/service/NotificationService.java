package ru.dressyourkid.kidshop.service;

public interface NotificationService {
    void notify(String addressee, String message) throws Exception;
    void notify(String addressee, String subject, String message) throws Exception;
}
