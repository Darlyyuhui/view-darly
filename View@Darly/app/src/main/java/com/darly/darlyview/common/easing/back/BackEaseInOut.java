package com.darly.darlyview.common.easing.back;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:07
 * @version 1.0/com.darly.darlyview.common.easing.back
 */

public class BackEaseInOut extends BaseEasingMethod {
    private float s;

    public BackEaseInOut(float duration) {
        super(duration);
        this.s = 1.70158F;
    }

    public BackEaseInOut(float duration, float back) {
        this(duration);
        this.s = back;
    }

    public Float calculate(float t, float b, float c, float d) {
        return (t /= d / 2.0F) < 1.0F?Float.valueOf(c / 2.0F * t * t * (((this.s = (float)((double)this.s * 1.525D)) + 1.0F) * t - this.s) + b):Float.valueOf(c / 2.0F * ((t -= 2.0F) * t * (((this.s = (float)((double)this.s * 1.525D)) + 1.0F) * t + this.s) + 2.0F) + b);
    }
}
