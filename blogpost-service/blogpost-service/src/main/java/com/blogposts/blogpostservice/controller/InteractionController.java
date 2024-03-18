package com.blogposts.blogpostservice.controller;

import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.blogposts.blogpostservice.dto.view.CreateViewDto;
import com.blogposts.blogpostservice.dto.view.GetViewDto;
import com.blogposts.blogpostservice.service.InteractionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/blogposts")
public class InteractionController {
    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping("view")
    public ResponseEntity<GetViewDto> viewPost(@RequestBody @Valid CreateViewDto createViewDto) {
        return new ResponseEntity<>(this.interactionService.viewPost(createViewDto), HttpStatus.CREATED);
    }

    @PostMapping("react")
    public ResponseEntity<GetReactionDto> reactToPost(@RequestBody @Valid CreateReactionDto createReactionDto) {
        return new ResponseEntity<>(this.interactionService.reactToPost(createReactionDto), HttpStatus.CREATED);
    }
}
