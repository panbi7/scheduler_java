package scheduler.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<Schedule> schedules;
    private static final String FILE_NAME = "schedules.dat";

    public ScheduleManager() {
        schedules = new ArrayList<>();
        loadSchedules();
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    public void removeSchedule(int index) {
        if (index >= 0 && index < schedules.size()) {
            schedules.remove(index);
        }
    }

    public void updateSchedule(int index, Schedule schedule) {
        if (index >= 0 && index < schedules.size()) {
            schedules.set(index, schedule);
        }
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void saveSchedules() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(schedules);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadSchedules() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            schedules = (List<Schedule>) ois.readObject();
        } catch (FileNotFoundException e) {
            schedules = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
