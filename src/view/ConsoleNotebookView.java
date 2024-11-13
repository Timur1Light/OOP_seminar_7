package view;

import model.Note;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class ConsoleNotebookView implements NotebookView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Записи не нейдены.");
        } else {
            for (Note note : notes) {
                System.out.println(note.toString().replaceFirst("T", " "));
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String dateTime = "";
        boolean input = true;
        while(input){
            try {
                System.out.println("Введите дату (yyyy-MM-dd):");
                String year = scanner.nextLine();
                System.out.println("Введите время (HH:mm):");
                String time = scanner.nextLine();
                dateTime = year+'T'+time;
                LocalDateTime.parse(dateTime, formatter);
                input = false;
            } catch (Exception ex){
                System.out.println("Ошибка ввода, введите заново:");
            }
        }
        return LocalDateTime.parse(dateTime, formatter);
    }

    @Override
    public LocalDateTime getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String year = "";
        boolean input = true;
        while(input){
            try {
                System.out.println("Введите дату (yyyy-MM-dd):");
                year = scanner.nextLine()+ "T00:00";
                LocalDateTime.parse(year , formatter);
                input = false;
            } catch (Exception ex){
                System.out.println("Ошибка ввода, введите дату в формате (yyyy-MM-dd):");
            }
        }
        return LocalDateTime.parse(year , formatter);
    }

    @Override
    public String getDescriptionInput() {
        System.out.println("Введите запись:");
        return scanner.nextLine();
    }
    @Override
    public String getFileNameInput() {
        System.out.println("Укажите имя файла:");
        return scanner.nextLine();
    }
}
