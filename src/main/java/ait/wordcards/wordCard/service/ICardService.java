package ait.wordcards.wordCard.service;

import ait.wordcards.wordCard.dto.CardRequestDto;
import ait.wordcards.wordCard.dto.CardResponseDto;

import java.util.List;

public interface ICardService {
    List<CardResponseDto> findAll();
    List<CardResponseDto> findByLanguagesSet(String language, String translateLanguage);
    List<CardResponseDto> findByWord(String word);
    CardResponseDto findById(Long id);
    CardResponseDto save (CardRequestDto dto);
    CardResponseDto update (Long id, CardRequestDto dto);
    CardResponseDto addGroupToCard (Long cardId, Long groupId);
    CardResponseDto removeGroupFromCard (Long cardId, Long groupId);
}
