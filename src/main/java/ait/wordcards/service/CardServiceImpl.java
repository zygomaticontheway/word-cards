package ait.wordcards.service;

import ait.wordcards.dto.CardRequestDto;
import ait.wordcards.dto.CardResponseDto;
import ait.wordcards.entity.Card;
import ait.wordcards.repository.ICardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CardServiceImpl implements ICardService {

    private final ICardRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<CardResponseDto> findAll() {

        return repository.findAll().stream()
                .map(c -> mapper.map(c, CardResponseDto.class))
                .toList();
    }

    @Override
    public List<CardResponseDto> findByLanguagesSet(String language, String translateLanguage) {

        try {
            List<Card> foundedCards = repository.findCardsByLanguageAndTranslateLanguageIgnoreCase(language, translateLanguage);
            return foundedCards.stream()
                    .map(c -> mapper.map(c, CardResponseDto.class))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public CardResponseDto findById(Long id) {

        Card entity = repository.findCardById(id);

        return mapper.map(entity, CardResponseDto.class);
    }

    @Override
    public List<CardResponseDto> findByWord(String word) {

        List<Card> foundedCards = repository.findCardsByWordIgnoreCase(word);

        return foundedCards.stream()
                .map(c -> mapper.map(c, CardResponseDto.class))
                .toList();
    }

    @Override
    @Transactional
    public CardResponseDto save(CardRequestDto dto) {

        Card entity = mapper.map(dto, Card.class);
        Card newCard = repository.save(entity);

        return mapper.map(newCard, CardResponseDto.class);
    }

    @Override
    @Transactional
    public CardResponseDto update(Long id, CardRequestDto dto) {

        Card entity = mapper.map(dto, Card.class);
        entity.setId(id);
        entity = repository.save(entity);

        return mapper.map(entity, CardResponseDto.class);
    }



}
