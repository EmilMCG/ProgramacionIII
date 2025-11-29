package com.example.springbootweb.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseService {
    // This service initializes Firebase using a service account JSON file.
    // To use: place the service account JSON in the project and set
    // spring.firebase.service-account-file=classpath:serviceAccount.json
    @PostConstruct
    public void init() throws IOException {
        try {
            String path = System.getProperty("firebase.service.account");
            if (path == null || path.isEmpty()) return; // not configured
            FileInputStream serviceAccount = new FileInputStream(path);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            // Log but do not fail startup if not configured
            System.out.println("Firebase init skipped or failed: " + e.getMessage());
        }
    }
}
