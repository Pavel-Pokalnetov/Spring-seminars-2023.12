package ru.gb.pokalnetovps.PersonalNotes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.pokalnetovps.PersonalNotes.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
