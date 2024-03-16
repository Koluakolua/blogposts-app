package com.blogposts.blogpostservice.entity.reaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReactionCompositeKey implements Serializable {
    private Long userId;
    private Long blogpost;
}
