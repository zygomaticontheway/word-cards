package ait.wordcards.groups.entity;

import ait.wordcards.wordCard.entity.Card;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "card-groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

//    @ManyToMany(mappedBy = "card_Id")
//    @JoinTable(
//            name = "group-cards", //имя таблицы
//            joinColumns = @JoinColumn(name = "group_id"),
//            inverseJoinColumns = @JoinColumn(name = "card_id")
//    )
//    @Column(name = "word-cards")
//    private Set<Card> cards;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;

        return id.equals(group.id) && title.equals(group.title);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

//    public boolean addCard (Card card){
//        if (cards == null){
//            cards = new HashSet<>();
//        }
//        return cards.add(card);
//    }
//    public boolean removeCard (Card card){
//        return cards.remove(card);
//    }

    private String cardsInfo(Set<Card> cards){
        return cards.stream()
                .map(card -> "Word: " + '\"' + card.getWord() + '\"' + " Language set: " + card.getLanguage() + "–" + card.getTranslateLanguage())
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", title='" + title + '\'' +
//                ", cards= [" +  cardsInfo (cards) + "]" +
                '}';
    }
}
