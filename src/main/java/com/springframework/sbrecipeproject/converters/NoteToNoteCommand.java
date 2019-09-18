package com.springframework.sbrecipeproject.converters;

import com.springframework.sbrecipeproject.commands.NoteCommand;
import com.springframework.sbrecipeproject.models.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NoteToNoteCommand implements Converter<Note, NoteCommand>{

    @Synchronized
    @Nullable
    @Override
    public NoteCommand convert(Note source) {
        if (source == null) {
            return null;
        }

        final NoteCommand notesCommand = new NoteCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}