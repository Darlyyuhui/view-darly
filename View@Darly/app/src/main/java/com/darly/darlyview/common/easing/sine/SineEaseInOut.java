package com.darly.darlyview.common.easing.sine;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:22
 * @version 1.0/com.darly.darlyview.common.easing.sine
 */

public class SineEaseInOut extends BaseEasingMethod {
    public SineEaseInOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(-c / 2.0F * ((float)Math.cos(3.141592653589793D * (double)t / (double)d) - 1.0F) + b);
    }
}
