package com.darly.darlyview.common.easing.expo;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:17
 * @version 1.0/com.darly.darlyview.common.easing.expo
 */

public class ExpoEaseInOut extends BaseEasingMethod {
    public ExpoEaseInOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return t == 0.0F?Float.valueOf(b):(t == d?Float.valueOf(b + c):((t /= d / 2.0F) < 1.0F?Float.valueOf(c / 2.0F * (float)Math.pow(2.0D, (double)(10.0F * (t - 1.0F))) + b):Float.valueOf(c / 2.0F * (-((float)Math.pow(2.0D, (double)(-10.0F * --t))) + 2.0F) + b)));
    }
}

