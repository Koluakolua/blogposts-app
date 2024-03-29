package com.blogposts.blogpostservice.entity.view;

import com.blogposts.blogpostservice.entity.Blogpost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "blogpost_views")
@IdClass(ViewCompositeKey.class)
@AllArgsConstructor
@NoArgsConstructor
public class BlogpostView {
    @Id
    @Column(nullable = false, updatable = false)
    private Long userId;

    @Id
    @ManyToOne
    @JoinColumn(name = "blogpost_id", nullable = false, updatable = false)
    private Blogpost blogpost;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdWhen;
}
