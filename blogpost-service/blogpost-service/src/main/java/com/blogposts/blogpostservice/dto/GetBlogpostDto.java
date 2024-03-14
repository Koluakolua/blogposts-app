package com.blogposts.blogpostservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBlogpostDto {
    private Long id;
    private String text;
    private LocalDateTime createdWhen;
    private GetUserDto createdBy;
    //private List<GetReactionDto> reactions;
}
