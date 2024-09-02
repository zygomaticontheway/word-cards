package ait.wordcards.wordCard.dto;

import ait.wordcards.groups.entity.Group;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardRequestDto {

    private String language;
    private String word;
    private String example;
    private String translateLanguage;
    private String translation;
//    private Set<Group> groups;

    @Override
    public String toString() {
        return "CardRequestDto{" +
                "language='" + language + '\'' +
                ", word='" + word + '\'' +
                ", example='" + example + '\'' +
                ", translateLanguage='" + translateLanguage + '\'' +
                ", translation='" + translation + '\'' +
//                ", group='" + group + '\'' +
                '}';
    }
}

