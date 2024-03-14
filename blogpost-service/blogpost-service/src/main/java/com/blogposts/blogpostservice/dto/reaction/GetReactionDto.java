package com.blogposts.blogpostservice.dto.reaction;

import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
import com.blogposts.blogpostservice.entity.reaction.ReactionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReactionDto {
    private Long userId;

    private GetBlogpostDto blogpost;

    private ReactionEnum reaction;

    private LocalDateTime createdWhen;

}
