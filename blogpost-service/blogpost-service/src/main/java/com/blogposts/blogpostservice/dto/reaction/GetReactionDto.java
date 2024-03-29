package com.blogposts.blogpostservice.dto.reaction;

import com.blogposts.blogpostservice.dto.IdDto;
import com.blogposts.blogpostservice.entity.reaction.ReactionEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetReactionDto {
    private IdDto user;

    private IdDto blogpost;

    private ReactionEnum reaction;

    private LocalDateTime createdWhen;

}
