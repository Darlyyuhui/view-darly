package com.darly.darlyview.common.easing.elastic;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:15
 * @version 1.0/com.darly.darlyview.common.easing.elastic
 */
public class ElasticEaseOut extends BaseEasingMethod {
    public ElasticEaseOut(float duration) {
        super(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        if(t == 0.0F) {
            return Float.valueOf(b);
        } else if((t /= d) == 1.0F) {
            return Float.valueOf(b + c);
        } else {
            float p = d * 0.3F;
            float s = p / 4.0F;
            return Float.valueOf(c * (float)Math.pow(2.0D, (double)(-10.0F * t)) * (float)Math.sin((double)((t * d - s) * 6.2831855F / p)) + c + b);
        }
    }
}
