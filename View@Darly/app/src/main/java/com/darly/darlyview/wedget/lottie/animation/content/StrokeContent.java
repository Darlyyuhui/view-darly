package com.darly.darlyview.wedget.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;

import com.darly.darlyview.wedget.lottie.LottieDrawable;
import com.darly.darlyview.wedget.lottie.LottieProperty;
import com.darly.darlyview.wedget.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.darly.darlyview.wedget.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.darly.darlyview.wedget.lottie.model.content.ShapeStroke;
import com.darly.darlyview.wedget.lottie.model.layer.BaseLayer;
import com.darly.darlyview.wedget.lottie.value.LottieValueCallback;

import static com.darly.darlyview.wedget.lottie.LottieProperty.STROKE_COLOR;

public class StrokeContent extends BaseStrokeContent {

  private final String name;
  private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
  @Nullable private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;

  public StrokeContent(final LottieDrawable lottieDrawable, BaseLayer layer, ShapeStroke stroke) {
    super(lottieDrawable, layer, stroke.getCapType().toPaintCap(),
        stroke.getJoinType().toPaintJoin(), stroke.getOpacity(), stroke.getWidth(),
        stroke.getLineDashPattern(), stroke.getDashOffset());
    name = stroke.getName();
    colorAnimation = stroke.getColor().createAnimation();
    colorAnimation.addUpdateListener(this);
    layer.addAnimation(colorAnimation);
  }

  @Override public void draw(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
    paint.setColor(colorAnimation.getValue());
    super.draw(canvas, parentMatrix, parentAlpha);
  }

  @Override public String getName() {
    return name;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> void addValueCallback(T property, @Nullable LottieValueCallback<T> callback) {
    super.addValueCallback(property, callback);
    if (property == STROKE_COLOR) {
      colorAnimation.setValueCallback((LottieValueCallback<Integer>) callback);
    } else if (property == LottieProperty.COLOR_FILTER) {
      if (callback == null) {
        colorFilterAnimation = null;
      } else {
        colorFilterAnimation =
            new ValueCallbackKeyframeAnimation<>((LottieValueCallback<ColorFilter>) callback);
      }
    }
  }
}