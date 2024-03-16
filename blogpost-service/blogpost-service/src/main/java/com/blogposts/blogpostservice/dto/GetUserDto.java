package com.blogposts.blogpostservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUserDto {
    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private LocalDateTime userSince;
}
