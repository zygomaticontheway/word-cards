package ait.wordcards.service;

import ait.wordcards.dto.CardRequestDto;
import ait.wordcards.dto.CardResponseDto;

import java.util.List;

public interface ICardService {
    List<CardResponseDto> findAll();
    List<CardResponseDto> findByLanguagesSet(String language, String translateLanguage);
    List<CardResponseDto> findByWord(String word);
    CardResponseDto findById(Long id);
    CardResponseDto save (CardRequestDto dto);
    CardResponseDto update (Long id, CardRequestDto dto);
}
