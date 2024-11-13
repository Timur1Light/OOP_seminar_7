package presenter;

import model.Note;
import model.Notebook;
import view.NotebookView;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


public class NotebookPresenter {
    private final Notebook model;
    private final NotebookView view;

    public NotebookPresenter(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    public void addNote() {
        LocalDateTime dateTime = view.getDateTimeInput();
        String description = view.getDescriptionInput();
        model.add(new Note(dateTime, description));
        view.showMessage("Запись добавлена.");
    }

    public void showNotesForDay() {
        LocalDateTime date = view.getDate();
        List<Note> notes = model.getNotesForDay(date);
        view.showNotes(notes);
    }

    public void showNotesForWeek() {
        LocalDateTime startOfWeek = view.getDate();
        List<Note> notes = model.getNotesForWeek(startOfWeek);
        view.showNotes(notes);
    }

    public void saveNotes() {
        String fileName = view.getFileNameInput();
        try {
            model.saveToFile(fileName);
            view.showMessage("Записи сохранены в файл: " + fileName);
        } catch (IOException e) {
            view.showMessage("Ошибка сохранения в файл: " + e.getMessage());
        }
    }

    public void loadNotes() {
        String fileName = view.getFileNameInput();
        try {
            model.loadFromFile(fileName);
            view.showMessage("Записи загруженны из файла:  " + fileName);
        } catch (IOException e) {
            view.showMessage("Ошибка загрузки записей из файла: " + e.getMessage());
        }
    }
}
