package service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AuditService {
    private static final String FILE_NAME = "audit.csv";
    private static AuditService instance = null;

    private AuditService() {
    }

    public static AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public void writeAuditLog(String actionName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(actionName + "," + LocalDateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}