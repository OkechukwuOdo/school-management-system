package com.justintime.schoolmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "albums")
public class GalleryAlbum {
    @Id
    private String id;
    private String name;                // "Graduation 2024"
    private String description;

    @DBRef(lazy = true)
    private List<GalleryItem> galleryItems = new ArrayList<>();
}
