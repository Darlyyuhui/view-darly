package com.darly.darlyview.wedget.lottie.animation.keyframe;

import com.darly.darlyview.wedget.lottie.value.Keyframe;

import java.util.List;

abstract class KeyframeAnimation<T> extends BaseKeyframeAnimation<T, T> {
  KeyframeAnimation(List<? extends Keyframe<T>> keyframes) {
    super(keyframes);
  }
}
