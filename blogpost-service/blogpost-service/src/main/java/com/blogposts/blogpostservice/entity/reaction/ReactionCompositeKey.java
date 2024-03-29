package com.blogposts.blogpostservice.entity.reaction;

import com.blogposts.blogpostservice.entity.Blogpost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactionCompositeKey implements Serializable {
    private Long userId;
    private Long blogpost;
}
