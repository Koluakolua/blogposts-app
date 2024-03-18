package com.blogposts.blogpostservice.dto.view;

import com.blogposts.blogpostservice.dto.IdDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetViewDto {
    private IdDto user;
    private IdDto blogpost;
    private LocalDateTime createdWhen;
}
