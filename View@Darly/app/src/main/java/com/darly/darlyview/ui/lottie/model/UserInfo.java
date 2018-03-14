package com.darly.darlyview.ui.lottie.model;

/**
 * @author Darly/张宇辉/2018/3/14 11:01
 * @version 1.0/com.darly.darlyview.ui.lottie.model
 */

public class UserInfo {
    private Long id;
    private String name;
    private String bio;
    private String location;
    private String city;
    private String  social_twitter;
    private String social_dribbble;
    private String social_behance;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSocial_twitter() {
        return social_twitter;
    }

    public void setSocial_twitter(String social_twitter) {
        this.social_twitter = social_twitter;
    }

    public String getSocial_dribbble() {
        return social_dribbble;
    }

    public void setSocial_dribbble(String social_dribbble) {
        this.social_dribbble = social_dribbble;
    }

    public String getSocial_behance() {
        return social_behance;
    }

    public void setSocial_behance(String social_behance) {
        this.social_behance = social_behance;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
