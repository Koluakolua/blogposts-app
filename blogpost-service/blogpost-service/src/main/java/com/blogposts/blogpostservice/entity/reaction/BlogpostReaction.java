package com.blogposts.blogpostservice.entity.reaction;

import com.blogposts.blogpostservice.entity.Blogpost;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "blogpost_reactions")
@IdClass(ReactionCompositeKey.class)
public class BlogpostReaction {
    @Id
    @ManyToOne
    @JoinColumn(name = "blogpost_id", nullable = false, updatable = false)
    private Blogpost blogpost;

    @Id
    @Column(nullable = false, updatable = false)
    private Long userId;

    @Column(nullable = false)
    private ReactionEnum reaction;

    @Column(nullable = false)
    private LocalDateTime createdWhen;
}
