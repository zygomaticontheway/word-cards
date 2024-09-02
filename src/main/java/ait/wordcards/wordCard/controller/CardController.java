package ait.wordcards.wordCard.controller;


import ait.wordcards.wordCard.dto.CardRequestDto;
import ait.wordcards.wordCard.dto.CardResponseDto;
import ait.wordcards.wordCard.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardController {

    private final ICardService service;

    @GetMapping("/cards")
    public List<CardResponseDto> getCards(@RequestParam(name = "language", required = false, defaultValue = "") String language,
                                          @RequestParam(name = "translateLanguage", required = false, defaultValue = "") String translateLanguage,
                                          @RequestParam(name = "word", required = false, defaultValue = "") String word) {
        if (language.isEmpty() && translateLanguage.isEmpty() && word.isEmpty()) {

            return service.findAll();

        } else if (!word.isEmpty()) {

            return service.findByWord(word);

        } else {
            return service.findByLanguagesSet(language, translateLanguage);
        }
    }

    @GetMapping("/cards/{id}")
    public CardResponseDto findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/cards")
    public CardResponseDto createCard(@RequestBody CardRequestDto dto) {
        return service.save(dto);
    }

    @PutMapping("/cards/{cardId}/groups/{groupId}")
    public CardResponseDto addGroupToCard(@PathVariable(name = "cardId") Long cardId,
                                          @PathVariable(name = "groupId") Long groupId) {
        return service.addGroupToCard(cardId, groupId);
    }

    @DeleteMapping("/cards/{cardId}/groups/{groupId}")
    public CardResponseDto removeGroupFromCard(@PathVariable(name = "cardId") Long cardId,
                                               @PathVariable(name = "groupId") Long groupId) {
        return service.removeGroupFromCard(cardId, groupId);
    }

}
