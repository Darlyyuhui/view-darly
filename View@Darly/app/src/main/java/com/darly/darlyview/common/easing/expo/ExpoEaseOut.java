package com.darly.darlyview.common.easing.expo;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:17
 * @version 1.0/com.darly.darlyview.common.easing.expo
 */
public class ExpoEaseOut extends BaseEasingMethod {
    public ExpoEaseOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(t == d?b + c:c * (-((float)Math.pow(2.0D, (double)(-10.0F * t / d))) + 1.0F) + b);
    }
}
