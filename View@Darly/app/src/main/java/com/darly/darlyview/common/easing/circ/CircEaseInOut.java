package com.darly.darlyview.common.easing.circ;
import com.darly.darlyview.common.easing.BaseEasingMethod;
/**
 * @author Darly/张宇辉/2018/3/14 14:11
 * @version 1.0/com.darly.darlyview.common.easing.circ
 */

public class CircEaseInOut extends BaseEasingMethod {
    public CircEaseInOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return (t /= d / 2.0F) < 1.0F?Float.valueOf(-c / 2.0F * ((float)Math.sqrt((double)(1.0F - t * t)) - 1.0F) + b):Float.valueOf(c / 2.0F * ((float)Math.sqrt((double)(1.0F - (t -= 2.0F) * t)) + 1.0F) + b);
    }
}
