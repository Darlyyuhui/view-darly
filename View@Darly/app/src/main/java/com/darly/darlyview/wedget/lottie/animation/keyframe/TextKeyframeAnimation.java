package com.darly.darlyview.wedget.lottie.animation.keyframe;

import com.darly.darlyview.wedget.lottie.value.Keyframe;
import com.darly.darlyview.wedget.lottie.model.DocumentData;

import java.util.List;

public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
  public TextKeyframeAnimation(List<Keyframe<DocumentData>> keyframes) {
    super(keyframes);
  }

  @Override DocumentData getValue(Keyframe<DocumentData> keyframe, float keyframeProgress) {
    return keyframe.startValue;
  }
}
