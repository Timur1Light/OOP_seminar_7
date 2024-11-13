/*
Необходимо реализовать проект удовлетворяющий изученному материалу.
Проект содержит интерфейсы, реализован с использованием MVP паттерна,
удовлетворяет всем принципам SOLID. Создать проект с записной книжкой. Идея
в том, что пользователь может делать записи на различные дни (например в
19:00 стоматолог), читать записи, сохранять и загружать в файл, сортировать,
искать записи на конкретный день или неделю.
Приложение должно быть консольным
 */

import model.Notebook;
import presenter.NotebookPresenter;
import view.ConsoleNotebookView;
import view.NotebookView;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Notebook model = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(model, view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить запись");
            System.out.println("2. Показать записи за день");
            System.out.println("3. Показать записи за неделю");
            System.out.println("4. Сохранить записи");
            System.out.println("5. Загрузить записи");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    presenter.addNote();
                    break;
                case 2:
                    presenter.showNotesForDay();
                    break;
                case 3:
                    presenter.showNotesForWeek();
                    break;
                case 4:
                    presenter.saveNotes();
                    break;
                case 5:
                    presenter.loadNotes();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Не правильный ввод, повторите выбор пункта!");
            }
        }
    }
}