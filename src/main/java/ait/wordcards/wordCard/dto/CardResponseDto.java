package ait.wordcards.wordCard.dto;

import ait.wordcards.groups.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

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
    private Set<Group> groups;

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

