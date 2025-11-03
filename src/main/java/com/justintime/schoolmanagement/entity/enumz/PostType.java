package com.justintime.schoolmanagement.entity.enumz;

public enum PostType {
    Event,Blog;
    @Override
    public String toString() {
        return this.name();
    }
}
