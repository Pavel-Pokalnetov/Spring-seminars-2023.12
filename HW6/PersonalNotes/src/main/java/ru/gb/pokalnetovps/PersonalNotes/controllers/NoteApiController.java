package ru.gb.pokalnetovps.PersonalNotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.pokalnetovps.PersonalNotes.model.Note;
import ru.gb.pokalnetovps.PersonalNotes.services.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteApiController {

    @Autowired
    private NoteService noteService;

    /** Создать заметку
     * @param note
     * @return
     */
    @PostMapping
    public ResponseEntity<?> addNote(@RequestBody Note note) {
        System.out.println(note);
        noteService.addNote(note);
        return ResponseEntity.ok().build();
    }

    /** Получить все заметки
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    /** Получить заметку по id
     * @param id
     * @return
     */
    @GetMapping("/notes/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    /** Изменить заметку
     * @param id
     * @param note
     * @return
     */
    @PutMapping("/notes/{id}")
    public ResponseEntity<?> updateNote(@PathVariable Long id, @RequestBody Note note) {
        note.setId(id);
        noteService.updateNote(note);
        return ResponseEntity.ok().build();
    }

    /** Удалить заметку
     * @param id
     * @return
     */
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }

}

