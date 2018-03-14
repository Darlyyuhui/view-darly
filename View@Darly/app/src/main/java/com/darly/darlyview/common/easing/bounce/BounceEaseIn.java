package com.darly.darlyview.common.easing.bounce;

import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:09
 * @version 1.0/com.darly.darlyview.common.easing.bounce
 */

public class BounceEaseIn extends BaseEasingMethod {
    private BounceEaseOut mBounceEaseOut;

    public BounceEaseIn(float duration) {
        super(duration);
        this.mBounceEaseOut = new BounceEaseOut(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return Float.valueOf(c - this.mBounceEaseOut.calculate(d - t, 0.0F, c, d).floatValue() + b);
    }
}