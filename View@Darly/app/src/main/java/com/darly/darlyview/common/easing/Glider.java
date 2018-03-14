package com.darly.darlyview.common.easing;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;


/**
 * @author Darly/张宇辉/2018/3/14 14:04
 * @version 1.0/com.darly.darlyview.common.easing
 */

public class Glider {
    public Glider() {
    }

    public static ValueAnimator glide(Skill skill, float duration, ValueAnimator animator) {
        return glide(skill, duration, animator, (BaseEasingMethod.EasingListener[])null);
    }

    public static ValueAnimator glide(Skill skill, float duration, ValueAnimator animator, BaseEasingMethod.EasingListener... listeners) {
        BaseEasingMethod t = skill.getMethod(duration);
        if(listeners != null) {
            t.addEasingListeners(listeners);
        }

        animator.setEvaluator(t);
        return animator;
    }

    public static PropertyValuesHolder glide(Skill skill, float duration, PropertyValuesHolder propertyValuesHolder) {
        propertyValuesHolder.setEvaluator(skill.getMethod(duration));
        return propertyValuesHolder;
    }
}
