package scheduler.main;

import java.io.Serializable;
import java.time.LocalDate;

public class Schedule implements Serializable {
    private String title;
    private LocalDate date;
    private String description;

    public Schedule(String title, LocalDate date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDate: " + date + "\nDescription: " + description;
    }
}
