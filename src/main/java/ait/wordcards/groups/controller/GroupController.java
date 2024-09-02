package ait.wordcards.groups.controller;


import ait.wordcards.groups.dto.GroupRequestDto;
import ait.wordcards.groups.dto.GroupResponseDto;
import ait.wordcards.groups.service.IGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GroupController {

    private final IGroupService service;

    @GetMapping("/groups")
    public List<GroupResponseDto> getGroups (@RequestParam (name = "title", required = false, defaultValue = "") String title){
        if ( title.isEmpty()){

            return service.findAll();

        } else {
            return service.findByTitle(title);
        }
    }

    @GetMapping("/groups/{id}")
    public GroupResponseDto findById (@PathVariable (name = "id") Long id){
        return service.findById(id);
    }

    @PostMapping("/groups")
    public GroupResponseDto createGroup (@RequestBody GroupRequestDto dto){
        return service.save(dto);
    }

}
