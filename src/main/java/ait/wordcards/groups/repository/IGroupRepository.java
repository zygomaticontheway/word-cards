package ait.wordcards.groups.repository;

import ait.wordcards.groups.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGroupRepository extends JpaRepository<Group, Long> {
    List<Group> findGroupByTitleIgnoreCase(String word);
}
