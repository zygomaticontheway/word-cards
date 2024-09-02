package ait.wordcards.wordCard.entity;

import ait.wordcards.groups.entity.Group;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Entity
@Table(name = "word-cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    @JoinTable(
            name = "group-cards",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    @Column(name = "groups")
    private Set<Group> groups;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;

        return id.equals(card.id) && language.equals(card.language) && word.equals(card.word) && translateLanguage.equals(card.translateLanguage) && translation.equals(card.translation);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + word.hashCode();
        result = 31 * result + translateLanguage.hashCode();
        result = 31 * result + translation.hashCode();
        return result;
    }

    public boolean addGroup (Group group){
        if (groups == null){
            groups = new HashSet<>();
        }
        return groups.add(group);
    }
    public boolean removeGroup (Group group){
        return groups.remove(group);
    }

    private String groupsInfo(Set<Group> groups){
        return groups.stream()
                .map(group -> "Group: " + '\"' + group.getTitle() + '\"')
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", word='" + word + '\'' +
                ", example='" + example + '\'' +
                ", translateLanguage='" + translateLanguage + '\'' +
                ", translation='" + translation + '\'' +
                ", groups= [" +  groupsInfo (groups) + "]" +
                '}';
    }
}
