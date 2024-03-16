package com.blogposts.blogpostservice.controller;

import com.blogposts.blogpostservice.dto.blogpost.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.blogposts.blogpostservice.service.BlogpostService;
import com.blogposts.blogpostservice.service.ReactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blogposts")
public class BlogpostController {
    private final BlogpostService blogpostService;
    private final ReactionService reactionService;

    @Autowired
    public BlogpostController(BlogpostService blogpostService, ReactionService reactionService) {
        this.blogpostService = blogpostService;
        this.reactionService = reactionService;
    }

    @GetMapping
    public ResponseEntity<List<GetBlogpostDto>> getBlogposts() {
        return new ResponseEntity<>(this.blogpostService.getBlogposts(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<GetBlogpostDto> createBlogpost(@RequestBody @Valid CreateBlogpostDto createBlogpostDto) {
        return new ResponseEntity<>(this.blogpostService.createBlogpost(createBlogpostDto), HttpStatus.CREATED);
    }

    @PostMapping("react")
    public ResponseEntity<GetReactionDto> reactToPost(@RequestBody @Valid CreateReactionDto createReactionDto) {
        return new ResponseEntity<>(this.reactionService.reactToPost(createReactionDto), HttpStatus.CREATED);
    }
}
