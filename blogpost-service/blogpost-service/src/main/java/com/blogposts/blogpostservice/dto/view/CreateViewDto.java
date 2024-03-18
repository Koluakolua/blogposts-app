package com.blogposts.blogpostservice.dto.view;

import com.blogposts.blogpostservice.dto.IdDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateViewDto {
    @NotNull
    private IdDto user;
    @NotNull
    private IdDto blogpost;
    @NotNull
    private LocalDateTime createdWhen;
}
