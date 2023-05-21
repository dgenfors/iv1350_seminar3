package se.kth.iv1350.amazingpos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogHandler {
    private PrintWriter file;
    private final String LOG_FILE_NAME;
    public LogHandler(String name) throws IOException{
        LOG_FILE_NAME = name;
        file = new PrintWriter(new FileWriter(LOG_FILE_NAME, true), true);
    }

    public void logException(Exception exception){
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append(LocalDate.now());
        msgBuilder.append(","+LocalTime.now());
        msgBuilder.append(", Exception:");
        msgBuilder.append(exception.getMessage());
        msgBuilder.append(" ,was thrown");
        file.println(msgBuilder);
        exception.printStackTrace(file);
        file.println("\n");
    }
    public void logDouble(int amountOfSales, double value){
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append(LocalDate.now());
        msgBuilder.append(","+LocalTime.now());
        msgBuilder.append(", Amount of Sales:");
        msgBuilder.append(" "+amountOfSales);
        msgBuilder.append(", Sum of Sales:");
        msgBuilder.append(" "+value);
        file.println(msgBuilder);
        file.println("\n");
    }
    
}
