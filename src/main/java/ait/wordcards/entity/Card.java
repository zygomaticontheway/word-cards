package ait.wordcards.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Entity
@Table(name = "word-cards")
public class Card {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "language")
    private String language;

    @Column(name = "word")
    private String word;

    @Column(name = "example")
    private String example;

    @Column(name = "translateLanguage")
    private String translateLanguage;

    @Column(name = "translation")
    private String translation;

    @Column(name = "group")
    private String group;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", word='" + word + '\'' +
                ", example='" + example + '\'' +
                ", translateLanguage='" + translateLanguage + '\'' +
                ", translation='" + translation + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
