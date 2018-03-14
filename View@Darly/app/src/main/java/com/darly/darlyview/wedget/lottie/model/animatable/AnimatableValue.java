package com.darly.darlyview.wedget.lottie.model.animatable;

import com.darly.darlyview.wedget.lottie.animation.keyframe.BaseKeyframeAnimation;

public interface AnimatableValue<K, A> {
  BaseKeyframeAnimation<K, A> createAnimation();
}
