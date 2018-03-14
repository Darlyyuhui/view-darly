package com.darly.darlyview.common.easing.quad;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:19
 * @version 1.0/com.darly.darlyview.common.easing.quad
 */

public class QuadEaseIn extends BaseEasingMethod {
    public QuadEaseIn(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * (t /= d) * t + b);
    }
}
