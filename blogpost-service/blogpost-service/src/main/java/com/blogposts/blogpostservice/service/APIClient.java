package com.blogposts.blogpostservice.service;

import com.blogposts.blogpostservice.dto.IdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface APIClient {
    @GetMapping("api/v1/users/{id}")
    IdDto getUser(@PathVariable Long id);
}
