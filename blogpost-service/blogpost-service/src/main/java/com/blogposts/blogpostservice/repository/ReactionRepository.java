package com.blogposts.blogpostservice.repository;

import com.blogposts.blogpostservice.entity.reaction.BlogpostReaction;
import com.blogposts.blogpostservice.entity.reaction.ReactionCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<BlogpostReaction, ReactionCompositeKey> {

}
