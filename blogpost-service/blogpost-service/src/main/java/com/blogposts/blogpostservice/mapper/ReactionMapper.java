package com.blogposts.blogpostservice.mapper;

import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.blogposts.blogpostservice.entity.reaction.BlogpostReaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = IdMapper.class)
public interface ReactionMapper {
    @Mapping(source = "user", target = "userId", qualifiedByName = "toId")
    BlogpostReaction toReaction(CreateReactionDto createReactionDto);

    @Mapping(source = "userId", target = "user", qualifiedByName = "toIdDto")
    GetReactionDto toGetReactionDto(BlogpostReaction reaction);
}
