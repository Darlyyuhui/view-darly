package com.darly.darlyview.common.easing.back;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:07
 * @version 1.0/com.darly.darlyview.common.easing.back
 */

public class BackEaseOut extends BaseEasingMethod {
    private float s;

    public BackEaseOut(float duration) {
        super(duration);
        this.s = 1.70158F;
    }

    public BackEaseOut(float duration, float back) {
        this(duration);
        this.s = back;
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * ((t = t / d - 1.0F) * t * ((this.s + 1.0F) * t + this.s) + 1.0F) + b);
    }
}