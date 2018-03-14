package com.darly.darlyview.wedget.lottie.model.animatable;

import com.darly.darlyview.wedget.lottie.value.Keyframe;
import com.darly.darlyview.wedget.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.darly.darlyview.wedget.lottie.animation.keyframe.ScaleKeyframeAnimation;
import com.darly.darlyview.wedget.lottie.value.ScaleXY;

import java.util.List;

public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {

  AnimatableScaleValue() {
    this(new ScaleXY(1f, 1f));
  }

  public AnimatableScaleValue(ScaleXY value) {
    super(value);
  }

  public AnimatableScaleValue(List<Keyframe<ScaleXY>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<ScaleXY, ScaleXY> createAnimation() {
    return new ScaleKeyframeAnimation(keyframes);
  }
}
