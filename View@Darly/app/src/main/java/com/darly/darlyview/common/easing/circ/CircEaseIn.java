package com.darly.darlyview.common.easing.circ;
import com.darly.darlyview.common.easing.BaseEasingMethod;
/**
 * @author Darly/张宇辉/2018/3/14 14:11
 * @version 1.0/com.darly.darlyview.common.easing.circ
 */

public class CircEaseIn extends BaseEasingMethod {
    public CircEaseIn(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(-c * ((float)Math.sqrt((double)(1.0F - (t /= d) * t)) - 1.0F) + b);
    }
}
