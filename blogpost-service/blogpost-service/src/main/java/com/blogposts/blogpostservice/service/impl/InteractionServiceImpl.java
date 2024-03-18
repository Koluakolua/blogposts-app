package com.blogposts.blogpostservice.service.impl;

import com.blogposts.blogpostservice.dto.GetUserDto;
import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.blogposts.blogpostservice.dto.view.CreateViewDto;
import com.blogposts.blogpostservice.dto.view.GetViewDto;
import com.blogposts.blogpostservice.entity.reaction.BlogpostReaction;
import com.blogposts.blogpostservice.entity.view.BlogpostView;
import com.blogposts.blogpostservice.entity.view.ViewCompositeKey;
import com.blogposts.blogpostservice.mapper.ReactionMapper;
import com.blogposts.blogpostservice.mapper.ViewMapper;
import com.blogposts.blogpostservice.repository.ReactionRepository;
import com.blogposts.blogpostservice.repository.ViewRepository;
import com.blogposts.blogpostservice.service.APIClient;
import com.blogposts.blogpostservice.service.InteractionService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.Optional;

@Slf4j
@Service
public class InteractionServiceImpl implements InteractionService {
    private final ReactionRepository reactionRepository;
    private final ReactionMapper reactionMapper;
    private final ViewMapper viewMapper;
    private final ViewRepository viewRepository;
    private final APIClient apiClient;

    @Autowired
    public InteractionServiceImpl(ReactionRepository reactionRepository, ReactionMapper reactionMapper, ViewMapper viewMapper, ViewRepository viewRepository, APIClient apiClient) {
        this.reactionRepository = reactionRepository;
        this.reactionMapper = reactionMapper;
        this.viewMapper = viewMapper;
        this.viewRepository = viewRepository;
        this.apiClient = apiClient;
    }

    @Override
    public GetReactionDto reactToPost(CreateReactionDto createReactionDto) {
        //TODO: maybe handle getUser error and unique constraint explicitly
        GetUserDto getUserDto = this.apiClient.getUser(createReactionDto.getUser().getId());
        BlogpostReaction reaction = this.reactionMapper.toReaction(createReactionDto);

        //TODO: make a separate DELETE method
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

    @Override
    public GetViewDto viewPost(CreateViewDto createViewDto) {
        //TODO: maybe handle getUser error and unique constraint explicitly
        GetUserDto getUserDto = this.apiClient.getUser(createViewDto.getUser().getId());

        BlogpostView blogpostView = this.viewMapper.toView(createViewDto);
        Optional<BlogpostView> blogpostViewFromDb = this.viewRepository.findById(new ViewCompositeKey(
                blogpostView.getUserId(),
                blogpostView.getBlogpost().getId()
        ));
        if (blogpostViewFromDb.isPresent()) {
            throw new ResourceAccessException("Post already viewed");
        }
        return this.viewMapper.toGetViewDto(this.viewRepository.save(blogpostView));
    }
}
