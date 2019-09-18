package com.springframework.sbrecipeproject.converters;

import com.springframework.sbrecipeproject.commands.NoteCommand;
import com.springframework.sbrecipeproject.models.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteCommandToNoteTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Note";
    NoteCommandToNote converter;

    @Before
    public void setUp() throws Exception {
        converter = new NoteCommandToNote();

    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NoteCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(ID_VALUE);
        noteCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Note note = converter.convert(noteCommand);

        //then
        assertNotNull(note);
        assertEquals(ID_VALUE, note.getId());
        assertEquals(RECIPE_NOTES, note.getRecipeNotes());
    }

}