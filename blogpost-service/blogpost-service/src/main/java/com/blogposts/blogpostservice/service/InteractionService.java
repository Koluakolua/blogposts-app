package com.blogposts.blogpostservice.service;

import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.blogposts.blogpostservice.dto.view.CreateViewDto;
import com.blogposts.blogpostservice.dto.view.GetViewDto;

public interface InteractionService {
    GetReactionDto reactToPost(CreateReactionDto createReactionDto);
    GetViewDto viewPost(CreateViewDto createViewDto);
}
