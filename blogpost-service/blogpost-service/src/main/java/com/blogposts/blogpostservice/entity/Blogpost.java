package com.blogposts.blogpostservice.entity;

import com.blogposts.blogpostservice.entity.reaction.BlogpostReaction;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "blogposts")
public class Blogpost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime createdWhen;

    @OneToMany(mappedBy = "blogpost", cascade = CascadeType.REMOVE)
    private List<BlogpostReaction> reactions;

    @Transient
    private Long viewsCount;
}
