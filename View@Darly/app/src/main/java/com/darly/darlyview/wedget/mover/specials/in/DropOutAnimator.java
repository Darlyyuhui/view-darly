package com.darly.darlyview.wedget.mover.specials.in;

import android.animation.ObjectAnimator;
import android.view.View;

import com.darly.darlyview.common.easing.Glider;
import com.darly.darlyview.common.easing.Skill;
import com.darly.darlyview.wedget.mover.BaseViewAnimator;

public class DropOutAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        int distance = target.getTop() + target.getHeight();
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 0, 1),
                Glider.glide(Skill.BounceEaseOut, getDuration(), ObjectAnimator.ofFloat(target, "translationY", -distance, 0))
        );
    }
}
