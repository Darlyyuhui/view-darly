package com.darly.darlyview.ui.lottie.model;

import android.net.Uri;

/**
 * @author Darly/张宇辉/2018/3/14 10:58
 * @version 1.0/com.darly.darlyview.ui.lottie.model
 */

public class CompositionArgs {

    private String assetName;
    private String  url;
    private Uri fileUri;
    private AnimationData  animationData;

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Uri getFileUri() {
        return fileUri;
    }

    public void setFileUri(Uri fileUri) {
        this.fileUri = fileUri;
    }

    public AnimationData getAnimationData() {
        return animationData;
    }

    public void setAnimationData(AnimationData animationData) {
        this.animationData = animationData;
    }
}
