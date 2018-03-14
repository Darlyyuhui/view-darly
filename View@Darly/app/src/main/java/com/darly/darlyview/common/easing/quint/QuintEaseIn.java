package com.darly.darlyview.common.easing.quint;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:20
 * @version 1.0/com.darly.darlyview.common.easing.quint
 */

public class QuintEaseIn extends BaseEasingMethod {
    public QuintEaseIn(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * (t /= d) * t * t * t * t + b);
    }
}