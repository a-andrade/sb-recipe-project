package com.springframework.sbrecipeproject.converters;

import com.springframework.sbrecipeproject.commands.NoteCommand;
import com.springframework.sbrecipeproject.models.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jt on 6/21/17.
 */
public class NoteToNoteCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Note";
    NoteToNoteCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NoteToNoteCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Note note = new Note();
        note.setId(ID_VALUE);
        note.setRecipeNotes(RECIPE_NOTES);

        //when
        NoteCommand notesCommand = converter.convert(note);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Note()));
    }
}