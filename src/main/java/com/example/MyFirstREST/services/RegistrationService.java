package com.example.MyFirstREST.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    //Поля UserService, NotificationService
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    //Метод processRegistration
    public void processRegistration(String name, int age, String email){
        dataProcessingService.addUserToList(userService.createUser(name, age, email));
    }
}
