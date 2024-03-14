package com.blogposts.blogpostservice.service;

import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;

public interface ReactionService {
    GetReactionDto reactToPost(CreateReactionDto createReactionDto);
}
