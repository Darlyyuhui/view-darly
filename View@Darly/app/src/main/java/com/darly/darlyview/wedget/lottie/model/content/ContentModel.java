package com.darly.darlyview.wedget.lottie.model.content;


import android.support.annotation.Nullable;

import com.darly.darlyview.wedget.lottie.LottieDrawable;
import com.darly.darlyview.wedget.lottie.animation.content.Content;
import com.darly.darlyview.wedget.lottie.model.layer.BaseLayer;

public interface ContentModel {
  @Nullable Content toContent(LottieDrawable drawable, BaseLayer layer);
}
