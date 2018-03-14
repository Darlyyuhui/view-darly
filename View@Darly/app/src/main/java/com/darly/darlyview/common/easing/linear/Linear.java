package com.darly.darlyview.common.easing.linear;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:18
 * @version 1.0/com.darly.darlyview.common.easing.linear
 */

public class Linear extends BaseEasingMethod {
    public Linear(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c * t / d + b);
    }
}
