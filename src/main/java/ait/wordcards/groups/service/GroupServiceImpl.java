package ait.wordcards.groups.service;

import ait.wordcards.exception.GroupNotFoundException;
import ait.wordcards.groups.dto.GroupRequestDto;
import ait.wordcards.groups.dto.GroupResponseDto;
import ait.wordcards.groups.entity.Group;
import ait.wordcards.groups.repository.IGroupRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class GroupServiceImpl implements IGroupService {

    private final IGroupRepository repository;
    private final ModelMapper mapper;


    @Override
    public List<GroupResponseDto> findAll() {

        return repository.findAll().stream()
                .map(g -> mapper.map(g, GroupResponseDto.class))
                .toList();
    }

    @Override
    public List<GroupResponseDto> findByTitle(String title) {

        return repository.findGroupByTitleIgnoreCase(title).stream()
                .map(g -> mapper.map(g, GroupResponseDto.class))
                .toList();
    }

    @Override
    public GroupResponseDto findById(Long id) {

        return mapper.map(repository.findById(id), GroupResponseDto.class);
    }

    @Override
    @Transactional
    public GroupResponseDto save(GroupRequestDto dto) {

        Group entity = mapper.map(dto, Group.class);
        Group newGroup = repository.save(entity);

        return mapper.map(newGroup, GroupResponseDto.class);
    }

    @Override
    @Transactional
    public GroupResponseDto update(Long id, GroupRequestDto dto) {

        Group entity = mapper.map(dto, Group.class);
        entity.setId(id);
        entity = repository.save(entity);

        return mapper.map(entity, GroupResponseDto.class);
    }

    @Override
    public Group findGroupById(Long id) {

        return repository.findById(id).orElseThrow(() -> new GroupNotFoundException("Group with id: " + id + " not found"));
    }
}
