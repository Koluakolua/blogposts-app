package com.blogposts.blogpostservice.dto.blogpost;

import com.blogposts.blogpostservice.dto.GetUserDto;
import com.blogposts.blogpostservice.dto.reaction.GetReactionDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetBlogpostDto {
    private Long id;
    private String text;
    private LocalDateTime createdWhen;
    private GetUserDto createdBy;
    private List<GetReactionDto> reactions;
    private Long viewsCount;
}
