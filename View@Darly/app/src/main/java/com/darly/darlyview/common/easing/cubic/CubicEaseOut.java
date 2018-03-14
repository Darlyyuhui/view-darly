package com.darly.darlyview.common.easing.cubic;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:13
 * @version 1.0/com.darly.darlyview.common.easing.cubic
 */

public class CubicEaseOut extends BaseEasingMethod {
    public CubicEaseOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * ((t = t / d - 1.0F) * t * t + 1.0F) + b);
    }
}
