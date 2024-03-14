package com.blogposts.blogpostservice.repository;

import com.blogposts.blogpostservice.entity.reaction.BlogpostReaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<BlogpostReaction, Long> {

}
