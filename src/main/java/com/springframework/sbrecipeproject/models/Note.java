package com.springframework.sbrecipeproject.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // no cascade; it we delete note, we dont want to delete its recipe
    private Recipe recipe;

    @Lob // long object; allow more characters within a string
    private String recipeNotes;
}
