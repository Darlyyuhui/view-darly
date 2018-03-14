package com.darly.darlyview.common.easing.cubic;
import com.darly.darlyview.common.easing.BaseEasingMethod;
/**
 * @author Darly/张宇辉/2018/3/14 14:13
 * @version 1.0/com.darly.darlyview.common.easing.cubic
 */
public class CubicEaseInOut extends BaseEasingMethod {
    public CubicEaseInOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return (t /= d / 2.0F) < 1.0F?Float.valueOf(c / 2.0F * t * t * t + b):Float.valueOf(c / 2.0F * ((t -= 2.0F) * t * t + 2.0F) + b);
    }
}
