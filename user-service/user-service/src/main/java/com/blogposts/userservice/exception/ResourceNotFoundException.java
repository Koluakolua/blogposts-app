package com.blogposts.userservice.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String id;

    public ResourceNotFoundException(String resourceName, String id) {
        super(String.format("Resource %s with id %s not found", resourceName, id));
        this.resourceName = resourceName;
        this.id = id;
    }
}
