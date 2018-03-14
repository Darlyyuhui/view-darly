package com.darly.darlyview.common.easing.back;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:06
 * @version 1.0/com.darly.darlyview.common.easing.back
 */

public class BackEaseIn extends BaseEasingMethod {
    private float s;

    public BackEaseIn(float duration) {
        super(duration);
        this.s = 1.70158F;
    }

    public BackEaseIn(float duration, float back) {
        this(duration);
        this.s = back;
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * (t /= d) * t * ((this.s + 1.0F) * t - this.s) + b);
    }
}