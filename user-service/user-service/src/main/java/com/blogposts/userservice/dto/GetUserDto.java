package com.blogposts.userservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDto {
    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private LocalDateTime userSince;
}
