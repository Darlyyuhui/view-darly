package com.darly.darlyview.ui.lottie.model;

import java.util.List;

/**
 * @author Darly/张宇辉/2018/3/14 10:56
 * @version 1.0/com.darly.darlyview.ui.lottie.model
 */

public class CollectionsResponse {
    private Long id;
    private String title;
    private Long authorId;
    private String tag;
    private String  slug;
    private String description;
    private List<AnimationData> entries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AnimationData> getEntries() {
        return entries;
    }

    public void setEntries(List<AnimationData> entries) {
        this.entries = entries;
    }
}
