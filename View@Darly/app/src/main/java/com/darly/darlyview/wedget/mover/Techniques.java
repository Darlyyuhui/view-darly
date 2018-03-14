
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.darly.darlyview.wedget.mover;

import com.darly.darlyview.wedget.mover.attention.BounceAnimator;
import com.darly.darlyview.wedget.mover.attention.FlashAnimator;
import com.darly.darlyview.wedget.mover.attention.PulseAnimator;
import com.darly.darlyview.wedget.mover.attention.RubberBandAnimator;
import com.darly.darlyview.wedget.mover.attention.ShakeAnimator;
import com.darly.darlyview.wedget.mover.attention.StandUpAnimator;
import com.darly.darlyview.wedget.mover.attention.SwingAnimator;
import com.darly.darlyview.wedget.mover.attention.TadaAnimator;
import com.darly.darlyview.wedget.mover.attention.WaveAnimator;
import com.darly.darlyview.wedget.mover.attention.WobbleAnimator;
import com.darly.darlyview.wedget.mover.bouncing_entrances.BounceInAnimator;
import com.darly.darlyview.wedget.mover.bouncing_entrances.BounceInDownAnimator;
import com.darly.darlyview.wedget.mover.bouncing_entrances.BounceInLeftAnimator;
import com.darly.darlyview.wedget.mover.bouncing_entrances.BounceInRightAnimator;
import com.darly.darlyview.wedget.mover.bouncing_entrances.BounceInUpAnimator;
import com.darly.darlyview.wedget.mover.fading_entrances.FadeInAnimator;
import com.darly.darlyview.wedget.mover.fading_entrances.FadeInDownAnimator;
import com.darly.darlyview.wedget.mover.fading_entrances.FadeInLeftAnimator;
import com.darly.darlyview.wedget.mover.fading_entrances.FadeInRightAnimator;
import com.darly.darlyview.wedget.mover.fading_entrances.FadeInUpAnimator;
import com.darly.darlyview.wedget.mover.fading_exits.FadeOutAnimator;
import com.darly.darlyview.wedget.mover.fading_exits.FadeOutDownAnimator;
import com.darly.darlyview.wedget.mover.fading_exits.FadeOutLeftAnimator;
import com.darly.darlyview.wedget.mover.fading_exits.FadeOutRightAnimator;
import com.darly.darlyview.wedget.mover.fading_exits.FadeOutUpAnimator;
import com.darly.darlyview.wedget.mover.flippers.FlipInXAnimator;
import com.darly.darlyview.wedget.mover.flippers.FlipInYAnimator;
import com.darly.darlyview.wedget.mover.flippers.FlipOutXAnimator;
import com.darly.darlyview.wedget.mover.flippers.FlipOutYAnimator;
import com.darly.darlyview.wedget.mover.rotating_entrances.RotateInAnimator;
import com.darly.darlyview.wedget.mover.rotating_entrances.RotateInDownLeftAnimator;
import com.darly.darlyview.wedget.mover.rotating_entrances.RotateInDownRightAnimator;
import com.darly.darlyview.wedget.mover.rotating_entrances.RotateInUpLeftAnimator;
import com.darly.darlyview.wedget.mover.rotating_entrances.RotateInUpRightAnimator;
import com.darly.darlyview.wedget.mover.rotating_exits.RotateOutAnimator;
import com.darly.darlyview.wedget.mover.rotating_exits.RotateOutDownLeftAnimator;
import com.darly.darlyview.wedget.mover.rotating_exits.RotateOutDownRightAnimator;
import com.darly.darlyview.wedget.mover.rotating_exits.RotateOutUpLeftAnimator;
import com.darly.darlyview.wedget.mover.rotating_exits.RotateOutUpRightAnimator;
import com.darly.darlyview.wedget.mover.sliders.SlideInDownAnimator;
import com.darly.darlyview.wedget.mover.sliders.SlideInLeftAnimator;
import com.darly.darlyview.wedget.mover.sliders.SlideInRightAnimator;
import com.darly.darlyview.wedget.mover.sliders.SlideInUpAnimator;
import com.darly.darlyview.wedget.mover.sliders.SlideOutDownAnimator;
import com.darly.darlyview.wedget.mover.sliders.SlideOutLeftAnimator;
import com.darly.darlyview.wedget.mover.sliders.SlideOutRightAnimator;
import com.darly.darlyview.wedget.mover.sliders.SlideOutUpAnimator;
import com.darly.darlyview.wedget.mover.specials.HingeAnimator;
import com.darly.darlyview.wedget.mover.specials.RollInAnimator;
import com.darly.darlyview.wedget.mover.specials.RollOutAnimator;
import com.darly.darlyview.wedget.mover.specials.in.DropOutAnimator;
import com.darly.darlyview.wedget.mover.specials.in.LandingAnimator;
import com.darly.darlyview.wedget.mover.specials.out.TakingOffAnimator;
import com.darly.darlyview.wedget.mover.zooming_entrances.ZoomInAnimator;
import com.darly.darlyview.wedget.mover.zooming_entrances.ZoomInDownAnimator;
import com.darly.darlyview.wedget.mover.zooming_entrances.ZoomInLeftAnimator;
import com.darly.darlyview.wedget.mover.zooming_entrances.ZoomInRightAnimator;
import com.darly.darlyview.wedget.mover.zooming_entrances.ZoomInUpAnimator;
import com.darly.darlyview.wedget.mover.zooming_exits.ZoomOutAnimator;
import com.darly.darlyview.wedget.mover.zooming_exits.ZoomOutDownAnimator;
import com.darly.darlyview.wedget.mover.zooming_exits.ZoomOutLeftAnimator;
import com.darly.darlyview.wedget.mover.zooming_exits.ZoomOutRightAnimator;
import com.darly.darlyview.wedget.mover.zooming_exits.ZoomOutUpAnimator;

public enum Techniques {

    DropOut(DropOutAnimator.class),
    Landing(LandingAnimator.class),
    TakingOff(TakingOffAnimator.class),

    Flash(FlashAnimator.class),
    Pulse(PulseAnimator.class),
    RubberBand(RubberBandAnimator.class),
    Shake(ShakeAnimator.class),
    Swing(SwingAnimator.class),
    Wobble(WobbleAnimator.class),
    Bounce(BounceAnimator.class),
    Tada(TadaAnimator.class),
    StandUp(StandUpAnimator.class),
    Wave(WaveAnimator.class),

    Hinge(HingeAnimator.class),
    RollIn(RollInAnimator.class),
    RollOut(RollOutAnimator.class),

    BounceIn(BounceInAnimator.class),
    BounceInDown(BounceInDownAnimator.class),
    BounceInLeft(BounceInLeftAnimator.class),
    BounceInRight(BounceInRightAnimator.class),
    BounceInUp(BounceInUpAnimator.class),

    FadeIn(FadeInAnimator.class),
    FadeInUp(FadeInUpAnimator.class),
    FadeInDown(FadeInDownAnimator.class),
    FadeInLeft(FadeInLeftAnimator.class),
    FadeInRight(FadeInRightAnimator.class),

    FadeOut(FadeOutAnimator.class),
    FadeOutDown(FadeOutDownAnimator.class),
    FadeOutLeft(FadeOutLeftAnimator.class),
    FadeOutRight(FadeOutRightAnimator.class),
    FadeOutUp(FadeOutUpAnimator.class),

    FlipInX(FlipInXAnimator.class),
    FlipOutX(FlipOutXAnimator.class),
    FlipInY(FlipInYAnimator.class),
    FlipOutY(FlipOutYAnimator.class),
    RotateIn(RotateInAnimator.class),
    RotateInDownLeft(RotateInDownLeftAnimator.class),
    RotateInDownRight(RotateInDownRightAnimator.class),
    RotateInUpLeft(RotateInUpLeftAnimator.class),
    RotateInUpRight(RotateInUpRightAnimator.class),

    RotateOut(RotateOutAnimator.class),
    RotateOutDownLeft(RotateOutDownLeftAnimator.class),
    RotateOutDownRight(RotateOutDownRightAnimator.class),
    RotateOutUpLeft(RotateOutUpLeftAnimator.class),
    RotateOutUpRight(RotateOutUpRightAnimator.class),

    SlideInLeft(SlideInLeftAnimator.class),
    SlideInRight(SlideInRightAnimator.class),
    SlideInUp(SlideInUpAnimator.class),
    SlideInDown(SlideInDownAnimator.class),

    SlideOutLeft(SlideOutLeftAnimator.class),
    SlideOutRight(SlideOutRightAnimator.class),
    SlideOutUp(SlideOutUpAnimator.class),
    SlideOutDown(SlideOutDownAnimator.class),

    ZoomIn(ZoomInAnimator.class),
    ZoomInDown(ZoomInDownAnimator.class),
    ZoomInLeft(ZoomInLeftAnimator.class),
    ZoomInRight(ZoomInRightAnimator.class),
    ZoomInUp(ZoomInUpAnimator.class),

    ZoomOut(ZoomOutAnimator.class),
    ZoomOutDown(ZoomOutDownAnimator.class),
    ZoomOutLeft(ZoomOutLeftAnimator.class),
    ZoomOutRight(ZoomOutRightAnimator.class),
    ZoomOutUp(ZoomOutUpAnimator.class);



    private Class animatorClazz;

    private Techniques(Class clazz) {
        animatorClazz = clazz;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
