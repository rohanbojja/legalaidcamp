package org.legalaidcamp.server.services;

public interface MessagingService {
    public Boolean sendMessage(String phoneNumber, String message);
}
