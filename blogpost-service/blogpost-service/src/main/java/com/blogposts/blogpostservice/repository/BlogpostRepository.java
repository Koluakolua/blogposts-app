package com.blogposts.blogpostservice.repository;

import com.blogposts.blogpostservice.entity.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogpostRepository extends JpaRepository<Blogpost, Long> {
}
