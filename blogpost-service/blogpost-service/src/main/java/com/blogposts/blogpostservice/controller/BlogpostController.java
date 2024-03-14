package com.blogposts.blogpostservice.controller;

import com.blogposts.blogpostservice.dto.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.GetBlogpostDto;
import com.blogposts.blogpostservice.service.BlogpostService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/blogposts")
public class BlogpostController {
    private final BlogpostService blogpostService;

    @Autowired
    public BlogpostController(BlogpostService blogpostService) {
        this.blogpostService = blogpostService;
    }

    @GetMapping
    public ResponseEntity<List<GetBlogpostDto>> getBlogposts() {
        return new ResponseEntity<>(this.blogpostService.getBlogposts(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<GetBlogpostDto> createBlogpost(@RequestBody @Valid CreateBlogpostDto createBlogpostDto) {
        return new ResponseEntity<>(this.blogpostService.createBlogpost(createBlogpostDto), HttpStatus.CREATED);
    }
}
