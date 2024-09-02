package ait.wordcards.groups.service;

import ait.wordcards.groups.dto.GroupRequestDto;
import ait.wordcards.groups.dto.GroupResponseDto;
import ait.wordcards.groups.entity.Group;

import java.util.List;

public interface IGroupService {
    List<GroupResponseDto> findAll();
    List<GroupResponseDto> findByTitle(String title);
    GroupResponseDto findById(Long id);
    GroupResponseDto save (GroupRequestDto dto);
    GroupResponseDto update (Long id, GroupRequestDto dto);
    Group findGroupById (Long id);
}
