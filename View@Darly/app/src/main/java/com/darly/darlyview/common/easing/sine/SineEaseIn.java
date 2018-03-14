package com.darly.darlyview.common.easing.sine;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:21
 * @version 1.0/com.darly.darlyview.common.easing.sine
 */

public class SineEaseIn extends BaseEasingMethod {
    public SineEaseIn(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(-c * (float)Math.cos((double)(t / d) * 1.5707963267948966D) + c + b);
    }
}
