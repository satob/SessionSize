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
        return UUID.randomUUID().toString();
    }
}
