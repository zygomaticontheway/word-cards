package ait.wordcards.dto;

import lombok.*;

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
    private String group;

    @Override
    public String toString() {
        return "CardRequestDto{" +
                "language='" + language + '\'' +
                ", word='" + word + '\'' +
                ", example='" + example + '\'' +
                ", translateLanguage='" + translateLanguage + '\'' +
                ", translation='" + translation + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}

