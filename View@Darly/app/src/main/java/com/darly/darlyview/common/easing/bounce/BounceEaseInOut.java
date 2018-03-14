package com.darly.darlyview.common.easing.bounce;
import com.darly.darlyview.common.easing.BaseEasingMethod;

/**
 * @author Darly/张宇辉/2018/3/14 14:10
 * @version 1.0/com.darly.darlyview.common.easing.bounce
 */

public class BounceEaseInOut extends BaseEasingMethod {
    private BounceEaseOut mBounceEaseOut;
    private BounceEaseIn mBounceEaseIn;

    public BounceEaseInOut(float duration) {
        super(duration);
        this.mBounceEaseIn = new BounceEaseIn(duration);
        this.mBounceEaseOut = new BounceEaseOut(duration);
    }

    public Float calculate(float t, float b, float c, float d) {
        return t < d / 2.0F?Float.valueOf(this.mBounceEaseIn.calculate(t * 2.0F, 0.0F, c, d).floatValue() * 0.5F + b):Float.valueOf(this.mBounceEaseOut.calculate(t * 2.0F - d, 0.0F, c, d).floatValue() * 0.5F + c * 0.5F + b);
    }
}
