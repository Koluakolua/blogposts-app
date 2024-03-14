package com.blogposts.blogpostservice.mapper;

import com.blogposts.blogpostservice.dto.reaction.CreateReactionDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.blogposts.blogpostservice.entity.reaction.BlogpostReaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReactionMapper {
    ReactionMapper MAPPER = Mappers.getMapper(ReactionMapper.class);


    BlogpostReaction fromCreateReactionDto(CreateReactionDto createReactionDto);

    GetReactionDto toGetReactionDto(BlogpostReaction blogpostReaction);
}
