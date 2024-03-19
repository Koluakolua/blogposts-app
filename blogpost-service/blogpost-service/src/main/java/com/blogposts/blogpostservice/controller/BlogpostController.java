package com.blogposts.blogpostservice.controller;

import com.blogposts.blogpostservice.dto.blogpost.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
import com.blogposts.blogpostservice.rabbitmq.RabbitMQProducer;
import com.blogposts.blogpostservice.service.BlogpostService;
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
    private final RabbitMQProducer rabbitMQProducer;

    @Autowired
    public BlogpostController(BlogpostService blogpostService, RabbitMQProducer rabbitMQProducer) {
        this.blogpostService = blogpostService;
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping
    public ResponseEntity<List<GetBlogpostDto>> getBlogposts() {
        return new ResponseEntity<>(this.blogpostService.getBlogposts(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<GetBlogpostDto> createBlogpost(@RequestBody @Valid CreateBlogpostDto createBlogpostDto) {
        return new ResponseEntity<>(this.blogpostService.createBlogpost(createBlogpostDto), HttpStatus.CREATED);
    }

    @PostMapping("test/{message}")
    public ResponseEntity<?> test(@PathVariable String message) {
        this.rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
