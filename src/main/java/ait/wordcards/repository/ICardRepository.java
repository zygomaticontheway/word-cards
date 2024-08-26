package ait.wordcards.repository;

import ait.wordcards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICardRepository extends JpaRepository<Card, Long> {
    Card findCardById(Long id);
    List<Card> findCardsByLanguageAndTranslateLanguageIgnoreCase(String language, String translateLanguage);
    List<Card> findCardsByWordIgnoreCase(String word);
}
