package com.blogposts.userservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {
    @NotNull
    private String login;

    private String firstName;

    private String lastName;

    @NotNull
    private LocalDateTime userSince;

}
