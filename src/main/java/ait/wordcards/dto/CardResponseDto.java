package ait.wordcards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponseDto {

    private Long id;
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

