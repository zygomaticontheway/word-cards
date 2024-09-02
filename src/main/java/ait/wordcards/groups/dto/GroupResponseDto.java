package ait.wordcards.groups.dto;

import ait.wordcards.wordCard.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupResponseDto {
    private Long id;
    private String title;
//    private Set<Card> cards;

//    private String cardsInfo(Set<Card> cards){
//        return cards.stream()
//                .map(card -> "Word: " + '\"' + card.getWord() + '\"' + " Language set: " + card.getLanguage() + "–" + card.getTranslateLanguage())
//                .collect(Collectors.joining(", "));
//    }
//
//    @Override
//    public String toString() {
//        return "Group{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", cards= [" +  cardsInfo (cards) + "]" +
//                '}';
//    }
}

