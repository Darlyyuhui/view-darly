package com.darly.darlyview.common.easing.quint;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:21
 * @version 1.0/com.darly.darlyview.common.easing.quint
 */

public class QuintEaseOut extends BaseEasingMethod {
    public QuintEaseOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * ((t = t / d - 1.0F) * t * t * t * t + 1.0F) + b);
    }
}
