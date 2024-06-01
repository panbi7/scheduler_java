package scheduler.main;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScheduleManager scheduleManager = new ScheduleManager();

        while (true) {
            System.out.println("====== 임성훈 일정 관리 프로그램 ======");
            System.out.println("1. 전체 일정 출력");
            System.out.println("2. 일정 추가");
            System.out.println("3. 일정 수정");
            System.out.println("4. 일정 삭제");
            System.out.println("5. 일정 저장");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    for (int i = 0; i < scheduleManager.getSchedules().size(); i++) {
                        System.out.println("Index: " + i);
                        System.out.println(scheduleManager.getSchedules().get(i));
                    }
                    break;
                case 2:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    Schedule newSchedule = new Schedule(title, date, description);
                    scheduleManager.addSchedule(newSchedule);
                    break;
                case 3:
                    System.out.print("수정할 일정의 인덱스를 입력하세요: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Title: ");
                    title = scanner.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Description: ");
                    description = scanner.nextLine();
                    Schedule updatedSchedule = new Schedule(title, date, description);
                    scheduleManager.updateSchedule(updateIndex, updatedSchedule);
                    break;
                case 4:
                    System.out.print("삭제할 일정의 인덱스를 입력하세요: ");
                    int deleteIndex = scanner.nextInt();
                    scheduleManager.removeSchedule(deleteIndex);
                    break;
                case 5:
                    scheduleManager.saveSchedules();
                    break;
                case 0:
                    scheduleManager.saveSchedules();
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}
