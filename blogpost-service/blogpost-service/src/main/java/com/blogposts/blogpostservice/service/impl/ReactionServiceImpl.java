package com.blogposts.blogpostservice.service.impl;

import com.blogposts.blogpostservice.dto.GetUserDto;
import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.blogposts.blogpostservice.repository.ReactionRepository;
import com.blogposts.blogpostservice.service.APIClient;
import com.blogposts.blogpostservice.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionServiceImpl implements ReactionService {
    private final ReactionRepository reactionRepository;
    private final APIClient apiClient;

    @Autowired
    public ReactionServiceImpl(ReactionRepository reactionRepository, APIClient apiClient) {
        this.reactionRepository = reactionRepository;
        this.apiClient = apiClient;
    }

    @Override
    public GetReactionDto reactToPost(CreateReactionDto createReactionDto) {
        //Exception handled in global handler
        GetUserDto getUserDto = this.apiClient.getUser(createReactionDto.getUserId());


    }
}
