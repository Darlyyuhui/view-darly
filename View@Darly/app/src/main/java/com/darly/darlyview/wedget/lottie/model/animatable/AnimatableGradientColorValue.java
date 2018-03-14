package com.darly.darlyview.wedget.lottie.model.animatable;

import com.darly.darlyview.wedget.lottie.value.Keyframe;
import com.darly.darlyview.wedget.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.darly.darlyview.wedget.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.darly.darlyview.wedget.lottie.model.content.GradientColor;

import java.util.List;

public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor,
    GradientColor> {
  public AnimatableGradientColorValue(
      List<Keyframe<GradientColor>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation() {
    return new GradientColorKeyframeAnimation(keyframes);
  }
}
