package ru.gb.pokalnetovps.PersonalNotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.PersonalNotes.model.Note;
import ru.gb.pokalnetovps.PersonalNotes.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void addNote(Note note) throws RuntimeException {
        noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        List<Note> noteList = new ArrayList<>();
        noteRepository.findAll().iterator().forEachRemaining(noteList::add);
        return noteList;
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
