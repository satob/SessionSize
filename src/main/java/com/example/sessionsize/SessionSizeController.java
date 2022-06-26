package com.example.sessionsize;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionSizeController {
    @Autowired
    HttpSession session;

    @RequestMapping("/test")
    public String test() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<100000; i++) {
            UUID uuid = UUID.randomUUID();
            sb.append(uuid);
        }
        session.setAttribute(UUID.randomUUID().toString(), sb.toString());

//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("Pbkdf2PasswordHash.Iterations", "3072");
//        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
//        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
//        passwordHash.initialize(parameters);

        return UUID.randomUUID().toString();
    }
}
