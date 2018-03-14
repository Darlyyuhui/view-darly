package com.darly.darlyview.common.easing;

import android.animation.TypeEvaluator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Darly/张宇辉/2018/3/14 14:02
 * @version 1.0/com.darly.darlyview.common.easing
 */


public abstract class BaseEasingMethod implements TypeEvaluator<Number> {
    protected float mDuration;
    private ArrayList<EasingListener> mListeners = new ArrayList();

    public void addEasingListener(BaseEasingMethod.EasingListener l) {
        this.mListeners.add(l);
    }

    public void addEasingListeners(BaseEasingMethod.EasingListener... ls) {
        BaseEasingMethod.EasingListener[] var2 = ls;
        int var3 = ls.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            BaseEasingMethod.EasingListener l = var2[var4];
            this.mListeners.add(l);
        }

    }

    public void removeEasingListener(BaseEasingMethod.EasingListener l) {
        this.mListeners.remove(l);
    }

    public void clearEasingListeners() {
        this.mListeners.clear();
    }

    public BaseEasingMethod(float duration) {
        this.mDuration = duration;
    }

    public void setDuration(float duration) {
        this.mDuration = duration;
    }

    public final Float evaluate(float fraction, Number startValue, Number endValue) {
        float t = this.mDuration * fraction;
        float b = startValue.floatValue();
        float c = endValue.floatValue() - startValue.floatValue();
        float d = this.mDuration;
        float result = this.calculate(t, b, c, d).floatValue();
        Iterator iterator = this.mListeners.iterator();

        while(iterator.hasNext()) {
            BaseEasingMethod.EasingListener l = (BaseEasingMethod.EasingListener)iterator.next();
            l.on(t, result, b, c, d);
        }

        return Float.valueOf(result);
    }

    public abstract Float calculate(float var1, float var2, float var3, float var4);

    public interface EasingListener {
        void on(float var1, float var2, float var3, float var4, float var5);
    }
}
