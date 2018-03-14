package com.darly.darlyview.common.easing;

import com.darly.darlyview.common.easing.back.*;
import com.darly.darlyview.common.easing.bounce.*;
import com.darly.darlyview.common.easing.circ.*;
import com.darly.darlyview.common.easing.cubic.*;
import com.darly.darlyview.common.easing.elastic.*;
import com.darly.darlyview.common.easing.expo.*;
import com.darly.darlyview.common.easing.linear.*;
import com.darly.darlyview.common.easing.quad.*;
import com.darly.darlyview.common.easing.quint.*;
import com.darly.darlyview.common.easing.sine.*;

/**
 * @author Darly/张宇辉/2018/3/14 14:01
 * @version 1.0/com.darly.darlyview.common.easing
 */


public enum Skill {
    BackEaseIn(BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),
    BounceEaseIn(BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(BounceEaseInOut.class),
    CircEaseIn(CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),
    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),
    ElasticEaseIn(ElasticEaseIn.class),
    ElasticEaseOut(ElasticEaseOut.class),
    ExpoEaseIn(ExpoEaseIn.class),
    ExpoEaseOut(ExpoEaseOut.class),
    ExpoEaseInOut(ExpoEaseInOut.class),
    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(QuadEaseOut.class),
    QuadEaseInOut(QuadEaseInOut.class),
    QuintEaseIn(QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(QuintEaseInOut.class),
    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(SineEaseInOut.class),
    Linear(Linear.class);

    private Class easingMethod;

    private Skill(Class clazz) {
        this.easingMethod = clazz;
    }

    public BaseEasingMethod getMethod(float duration) {
        try {
            return (BaseEasingMethod)this.easingMethod.getConstructor(new Class[]{Float.TYPE}).newInstance(new Object[]{Float.valueOf(duration)});
        } catch (Exception var3) {
            var3.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }
}
