package com.darly.darlyview.wedget.lottie.animation.keyframe;

import com.darly.darlyview.wedget.lottie.value.Keyframe;
import com.darly.darlyview.wedget.lottie.utils.MiscUtils;

import java.util.List;

public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {

  public IntegerKeyframeAnimation(List<Keyframe<Integer>> keyframes) {
    super(keyframes);
  }

  @Override Integer getValue(Keyframe<Integer> keyframe, float keyframeProgress) {
    if (keyframe.startValue == null || keyframe.endValue == null) {
      throw new IllegalStateException("Missing values for keyframe.");
    }

    if (valueCallback != null) {
      //noinspection ConstantConditions
      return valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame,
          keyframe.startValue, keyframe.endValue,
          keyframeProgress, getLinearCurrentKeyframeProgress(), getProgress());
    }

    return MiscUtils.lerp(keyframe.startValue, keyframe.endValue, keyframeProgress);
  }
}
