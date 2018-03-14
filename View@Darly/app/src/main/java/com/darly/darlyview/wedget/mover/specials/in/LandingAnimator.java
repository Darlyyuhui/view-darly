package com.darly.darlyview.wedget.mover.specials.in;

import android.animation.ObjectAnimator;
import android.view.View;

import com.darly.darlyview.common.easing.Glider;
import com.darly.darlyview.common.easing.Skill;
import com.darly.darlyview.wedget.mover.BaseViewAnimator;

public class LandingAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleX", 1.5f, 1f)),
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleY", 1.5f, 1f)),
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "alpha", 0, 1f))
        );
    }
}
