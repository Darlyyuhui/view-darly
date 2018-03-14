package com.darly.darlyview.common.easing.quint;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:20
 * @version 1.0/com.darly.darlyview.common.easing.quint
 */

public class QuintEaseInOut extends BaseEasingMethod {
    public QuintEaseInOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return (t /= d / 2.0F) < 1.0F?Float.valueOf(c / 2.0F * t * t * t * t * t + b):Float.valueOf(c / 2.0F * ((t -= 2.0F) * t * t * t * t + 2.0F) + b);
    }
}
