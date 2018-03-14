package com.darly.darlyview.common.easing.sine;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:22
 * @version 1.0/com.darly.darlyview.common.easing.sine
 */

public class SineEaseOut extends BaseEasingMethod {
    public SineEaseOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * (float)Math.sin((double)(t / d) * 1.5707963267948966D) + b);
    }
}
