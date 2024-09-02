package ait.wordcards.wordCard.service;

import ait.wordcards.groups.dto.GroupResponseDto;
import ait.wordcards.groups.entity.Group;
import ait.wordcards.groups.repository.IGroupRepository;
import ait.wordcards.groups.service.IGroupService;
import ait.wordcards.wordCard.dto.CardRequestDto;
import ait.wordcards.wordCard.dto.CardResponseDto;
import ait.wordcards.wordCard.entity.Card;
import ait.wordcards.wordCard.repository.ICardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class CardServiceImpl implements ICardService {

    private final ICardRepository repository;
    private final ModelMapper mapper;
    private final IGroupService groupService;

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

//        Set<Group> groups = new HashSet<>();
//        entity.setGroups(groups);

        entity = repository.save(entity);

        return mapper.map(entity, CardResponseDto.class);
    }

    @Override
    @Transactional
    public CardResponseDto update(Long id, CardRequestDto dto) {

        Card entity = mapper.map(dto, Card.class);
        entity.setId(id);
        entity = repository.save(entity);

        return mapper.map(entity, CardResponseDto.class);
    }

    @Override
    public CardResponseDto addGroupToCard(Long cardId, Long groupId) {

        Group findedGroup = groupService.findGroupById(groupId);
        Card findedCard = repository.findCardById(cardId);

        findedCard.addGroup(findedGroup);

        return mapper.map(findedCard, CardResponseDto.class);
    }

    @Override
    public CardResponseDto removeGroupFromCard(Long cardId, Long groupId) {

        Group findedGroup = groupService.findGroupById(groupId);
        Card findedCard = repository.findCardById(cardId);

        findedCard.removeGroup(findedGroup);

        return mapper.map(findedCard, CardResponseDto.class);
    }

}
