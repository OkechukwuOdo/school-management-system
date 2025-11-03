package com.justintime.schoolmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Document(collection = "galleryItem")
public class GalleryItem {
    @Id
    private String id;

    private String title;               // "Graduation Ceremony 2024"
    private String description;
    private String mediaType;           // IMAGE, VIDEO, DOCUMENT
    private String url;                 // link to S3 / CDN
    private String thumbnailUrl;        // for quick loading

    private String category;            // e.g., "Event", "Sports", "Cultural Day"
    private LocalDateTime uploadedAt;

    @DBRef(lazy = true)
    private AppUser uploadedBy;         // staff or admin who uploaded it

    private List<String> tags;
}
