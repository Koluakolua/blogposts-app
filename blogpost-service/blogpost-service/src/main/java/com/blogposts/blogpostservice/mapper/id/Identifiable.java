package com.blogposts.blogpostservice.mapper.id;

public interface Identifiable<T> {
    T getId();

    void setId(T id);
}
