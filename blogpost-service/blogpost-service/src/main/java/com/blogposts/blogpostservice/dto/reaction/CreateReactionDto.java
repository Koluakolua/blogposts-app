package com.blogposts.blogpostservice.dto.reaction;

import com.blogposts.blogpostservice.dto.IdDto;
import com.blogposts.blogpostservice.entity.reaction.ReactionEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReactionDto {
    @NotNull
    private IdDto user;

    @NotNull
    private IdDto blogpost;

    private ReactionEnum reaction;

    @NotNull
    private LocalDateTime createdWhen;

}
