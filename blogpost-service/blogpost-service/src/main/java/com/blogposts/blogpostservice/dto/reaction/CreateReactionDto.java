package com.blogposts.blogpostservice.dto.reaction;

import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
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
    //TODO: maybe receive userDto and map it to userId. Because there is inconsistency, user is passed as
    @NotNull
    private Long userId;

    @NotNull
    private GetBlogpostDto blogpost;

    @NotNull
    private ReactionEnum reaction;

    @NotNull
    private LocalDateTime createdWhen;

}
