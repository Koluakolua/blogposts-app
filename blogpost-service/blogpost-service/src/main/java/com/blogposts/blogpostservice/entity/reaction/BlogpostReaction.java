package com.blogposts.blogpostservice.entity.reaction;

import com.blogposts.blogpostservice.entity.Blogpost;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "blogpost_reactions", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"blogpost_id", "user_id"})
})
public class BlogpostReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blogpost_id", nullable = false)
    private Blogpost blogpost;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private ReactionEnum reaction;

    @Column(nullable = false)
    private LocalDateTime createdWhen;
}
