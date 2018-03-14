package com.darly.darlyview.wedget.lottie.model.animatable;

import com.darly.darlyview.wedget.lottie.value.Keyframe;
import com.darly.darlyview.wedget.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.darly.darlyview.wedget.lottie.animation.keyframe.FloatKeyframeAnimation;

import java.util.List;

public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {

  AnimatableFloatValue() {
    super(0f);
  }

  public AnimatableFloatValue(List<Keyframe<Float>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<Float, Float> createAnimation() {
    return new FloatKeyframeAnimation(keyframes);
  }
}
