package com.darly.darlyview.common.easing.cubic;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:12
 * @version 1.0/com.darly.darlyview.common.easing.cubic
 */

public class CubicEaseIn extends BaseEasingMethod {
    public CubicEaseIn(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * (t /= d) * t * t + b);
    }
}
