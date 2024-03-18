package com.blogposts.blogpostservice.repository;

import com.blogposts.blogpostservice.entity.view.BlogpostView;
import com.blogposts.blogpostservice.entity.view.ViewCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewRepository extends JpaRepository<BlogpostView, ViewCompositeKey> {
    Long countBlogpostViewByBlogpostId(Long blogpostId);
}
