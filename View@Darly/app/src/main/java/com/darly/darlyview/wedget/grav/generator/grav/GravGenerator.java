package com.darly.darlyview.wedget.grav.generator.grav;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;

import com.darly.darlyview.wedget.grav.figures.Grav;

public interface GravGenerator {
  Grav generate(PointF startPoint, Paint paint);
  void configure(AttributeSet attributeSet, Context context);
}
