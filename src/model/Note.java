package model;


import java.time.LocalDateTime;

public class Note {
    private final LocalDateTime dateTime;
    private final String description;

    public Note(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return dateTime.toString() + ": " + description;
        //return dateTime.toLocalDate().toString() + " " + dateTime.toLocalTime().toString() + ": " + description;
    }
}