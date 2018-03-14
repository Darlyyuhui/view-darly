package com.darly.darlyview.ui.lottie.model;


/**
 * @author Darly/张宇辉/2018/3/14 10:46
 * @version 1.0/com.darly.darlyview.ui.lottie.model
 */

public class AnimationData {

    private Long id;
    private String title;
    private String description;
    private String bgColor;
    private String aepFile;
    private String bodymovinVersion;
    private String slug;
    private String speed;
    private String preview;
    private String lottieLink;
    private UserInfo userInfo;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getAepFile() {
        return aepFile;
    }

    public void setAepFile(String aepFile) {
        this.aepFile = aepFile;
    }

    public String getBodymovinVersion() {
        return bodymovinVersion;
    }

    public void setBodymovinVersion(String bodymovinVersion) {
        this.bodymovinVersion = bodymovinVersion;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getLottieLink() {
        return lottieLink;
    }

    public void setLottieLink(String lottieLink) {
        this.lottieLink = lottieLink;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
