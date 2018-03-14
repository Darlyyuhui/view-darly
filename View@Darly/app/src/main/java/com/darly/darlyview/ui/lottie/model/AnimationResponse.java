package com.darly.darlyview.ui.lottie.model;

import java.util.List;

/**
 * @author Darly/张宇辉/2018/3/14 10:54
 * @version 1.0/com.darly.darlyview.ui.lottie.model
 */

public class AnimationResponse {

    private int currentPage;
    private List<AnimationData> data;
    private String from;
    private int lastPage;
    private String nextPageUrl;
    private String path;
    private int perPage;
    private String prevPageUrl;
    private int to;
    private int total;


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<AnimationData> getData() {
        return data;
    }

    public void setData(List<AnimationData> data) {
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
