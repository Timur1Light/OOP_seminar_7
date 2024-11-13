package view;


import model.Note;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface NotebookView {
    void showNotes(List<Note> notes);
    void showMessage(String message);
    LocalDateTime getDateTimeInput();
    LocalDateTime getDate();
    String getDescriptionInput();
    String getFileNameInput();
}
