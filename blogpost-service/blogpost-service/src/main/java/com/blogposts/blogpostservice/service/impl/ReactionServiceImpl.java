package com.blogposts.blogpostservice.service.impl;

import com.blogposts.blogpostservice.dto.GetUserDto;
import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.blogposts.blogpostservice.entity.reaction.BlogpostReaction;
import com.blogposts.blogpostservice.mapper.ReactionMapper;
import com.blogposts.blogpostservice.repository.ReactionRepository;
import com.blogposts.blogpostservice.service.APIClient;
import com.blogposts.blogpostservice.service.ReactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReactionServiceImpl implements ReactionService {
    private final ReactionRepository reactionRepository;
    private final ReactionMapper reactionMapper;
    private final APIClient apiClient;

    @Autowired
    public ReactionServiceImpl(ReactionRepository reactionRepository, ReactionMapper reactionMapper, APIClient apiClient) {
        this.reactionRepository = reactionRepository;
        this.reactionMapper = reactionMapper;
        this.apiClient = apiClient;
    }

    @Override
    public GetReactionDto reactToPost(CreateReactionDto createReactionDto) {
        //TODO: maybe handle getUser error and unique constraint explicitly
        GetUserDto getUserDto = this.apiClient.getUser(createReactionDto.getUser().getId());
        BlogpostReaction reaction = this.reactionMapper.toReaction(createReactionDto);
        if (reaction.getReaction() == null) {
            this.reactionRepository.delete(reaction);
        }
        else {
            reaction = this.reactionRepository.save(reaction);
        }
        GetReactionDto getReactionDto = this.reactionMapper.toGetReactionDto(reaction);
        log.debug("getReaction:", reaction);
        log.debug("getReactionDto:", getReactionDto);
        return getReactionDto;
    }
}
