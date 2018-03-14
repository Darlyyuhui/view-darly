package com.darly.darlyview.wedget.mover.specials.out;

import android.animation.ObjectAnimator;
import android.view.View;

import com.darly.darlyview.common.easing.Glider;
import com.darly.darlyview.common.easing.Skill;
import com.darly.darlyview.wedget.mover.BaseViewAnimator;

public class TakingOffAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleX", 1f, 1.5f)),
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "scaleY", 1f, 1.5f)),
                Glider.glide(Skill.QuintEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "alpha", 1, 0))
        );
    }
}
