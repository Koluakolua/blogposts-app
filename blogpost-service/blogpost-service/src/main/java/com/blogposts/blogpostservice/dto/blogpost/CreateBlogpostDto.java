package com.blogposts.blogpostservice.dto.blogpost;

import com.blogposts.blogpostservice.dto.IdDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlogpostDto {
    @NotBlank
    private String text;

    @NotNull
    private LocalDateTime createdWhen;

    @NotNull
    private IdDto createdBy;
}
