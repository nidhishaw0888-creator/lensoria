package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    
    // Lambda expression for formatting date and time
    public static DateFormatter dateFormatter = () -> {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return now.format(formatter);
    };
    
    // Lambda for date
    public static DateFormatter dateOnly = () -> {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return now.format(formatter);
    };
    
    // Lambda for time
    public static DateFormatter timeOnly = () -> {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    };
    
    @FunctionalInterface
    public interface DateFormatter {
        String format();
    }
}