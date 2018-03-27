package com.darly.darlyview.wedget.magnet;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/** 仿磁铁效果的ImageView
 * @author Darly/张宇辉/2018/3/27 10:10
 * @version 1.0/com.darly.darlyview.wedget.magnet
 */

public class MagnetImageView extends ImageView {
    private boolean onAnimation = true;// 是否处于动画状态
    private int rotateDegree = 10;// 执行动画的时间
    private boolean isFirst = true;// 标识是否为第一次绘制视图
    private float minScale = 0.95f;// 最小缩放限度
    private int vWidth;// 视图宽度
    private int vHeight;// 视图高度
    private boolean isFinish = true;// 标识是否为结束
    private boolean isActionMove = false;// 标识是否在移动状态
    private boolean isScale = false;// 标识是否为缩放状态
    private Camera camera;

    boolean XbigY = false;// 是否放大
    float RolateX = 0;// 旋转的X轴点
    float RolateY = 0;// 旋转的Y轴点

    OnViewClick onclick=null;

    public interface OnViewClick {
        public void onClick();
    }

    public MagnetImageView(Context context) {
        super(context);
        camera = new Camera();
    }

    public MagnetImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        camera = new Camera();
    }

    public void SetAnimationOnOff(boolean oo) {
        onAnimation = oo;
    }
    public void setOnClickIntent(OnViewClick onclick){
        this.onclick=onclick;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isFirst) {
            isFirst = false;
            init();
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG
                | Paint.FILTER_BITMAP_FLAG));
    }
    public void init() {
        vWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        vHeight = getHeight() - getPaddingTop() - getPaddingBottom();
        Drawable drawable = getDrawable();
        BitmapDrawable bd = (BitmapDrawable) drawable;
        bd.setAntiAlias(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if (!onAnimation)
            return true;
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                float X = event.getX();
                float Y = event.getY();
                RolateX = vWidth / 2 - X;
                RolateY = vHeight / 2 - Y;
                XbigY = Math.abs(RolateX) > Math.abs(RolateY) ? true : false;

                isScale = X > vWidth / 3 && X < vWidth * 2 / 3 && Y > vHeight / 3&& Y < vHeight * 2 / 3;
                isActionMove=false;

                if (isScale) {
                    handler.sendEmptyMessage(1);
                } else {
                    rolateHandler.sendEmptyMessage(1);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                float x=event.getX();float y=event.getY();
                if(x>vWidth || y>vHeight || x<0 || y<0){
                    isActionMove=true;
                }else{
                    isActionMove=false;
                }

                break;
            case MotionEvent.ACTION_UP:
                if (isScale) {
                    handler.sendEmptyMessage(6);
                } else {
                    rolateHandler.sendEmptyMessage(6);
                }
                break;
        }
        return true;
    }

    private Handler rolateHandler = new Handler() {
        private Matrix matrix = new Matrix();
        private float count = 0;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            matrix.set(getImageMatrix());
            switch (msg.what) {
                case 1:
                    count = 0;
                    BeginRolate(matrix, (XbigY ? count : 0), (XbigY ? 0 : count));
                    rolateHandler.sendEmptyMessage(2);
                    break;
                case 2:
                    BeginRolate(matrix, (XbigY ? count : 0), (XbigY ? 0 : count));
                    if (count < getDegree()) {
                        rolateHandler.sendEmptyMessage(2);
                    } else {
                        isFinish = true;
                    }
                    count++;
                    count++;
                    break;
                case 3:
                    BeginRolate(matrix, (XbigY ? count : 0), (XbigY ? 0 : count));
                    if (count > 0) {
                        rolateHandler.sendEmptyMessage(3);
                    } else {
                        isFinish = true;
                        if(!isActionMove&&onclick!=null){
                            onclick.onClick();
                        }
                    }
                    count--;
                    count--;
                    break;
                case 6:
                    count = getDegree();
                    BeginRolate(matrix, (XbigY ? count : 0), (XbigY ? 0 : count));
                    rolateHandler.sendEmptyMessage(3);
                    break;
            }
        }
    };
    private Handler handler = new Handler() {
        private Matrix matrix = new Matrix();
        private float s;
        int count = 0;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            matrix.set(getImageMatrix());
            switch (msg.what) {
                case 1:
                    if (!isFinish) {
                        return;
                    } else {
                        isFinish = false;
                        count = 0;
                        s = (float) Math.sqrt(Math.sqrt(minScale));
                        BeginScale(matrix, s);
                        handler.sendEmptyMessage(2);
                    }
                    break;
                case 2:
                    BeginScale(matrix, s);
                    if (count < 4) {
                        handler.sendEmptyMessage(2);
                    } else {
                        isFinish = true;
                        if(!isActionMove&&onclick!=null){
                            onclick.onClick();
                        }
                    }
                    count++;
                    break;
                case 6:
                    if (!isFinish) {
                        handler.sendEmptyMessage(6);
                    } else {
                        isFinish = false;
                        count = 0;
                        s = (float) Math.sqrt(Math.sqrt(1.0f / minScale));
                        BeginScale(matrix, s);
                        handler.sendEmptyMessage(2);
                    }
                    break;
            }
        }
    };


    private synchronized void BeginRolate(Matrix matrix, float rolateX,
                                          float rolateY) {
        // Bitmap bm = getImageBitmap();
        int scaleX = (int) (vWidth * 0.5f);
        int scaleY = (int) (vHeight * 0.5f);
        camera.save();
        camera.rotateX(RolateY > 0 ? rolateY : -rolateY);
        camera.rotateY(RolateX < 0 ? rolateX : -rolateX);
        camera.getMatrix(matrix);
        camera.restore();
        // 控制中心点
        if (RolateX > 0 && rolateX != 0) {
            matrix.preTranslate(-vWidth, -scaleY);
            matrix.postTranslate(vWidth, scaleY);
        } else if (RolateY > 0 && rolateY != 0) {
            matrix.preTranslate(-scaleX, -vHeight);
            matrix.postTranslate(scaleX, vHeight);
        } else if (RolateX < 0 && rolateX != 0) {
            matrix.preTranslate(-0, -scaleY);
            matrix.postTranslate(0, scaleY);
        } else if (RolateY < 0 && rolateY != 0) {
            matrix.preTranslate(-scaleX, -0);
            matrix.postTranslate(scaleX, 0);
        }
        setImageMatrix(matrix);
    }

    private synchronized void BeginScale(Matrix matrix, float scale) {
        int scaleX = (int) (vWidth * 0.5f);
        int scaleY = (int) (vHeight * 0.5f);
        matrix.postScale(scale, scale, scaleX, scaleY);
        setImageMatrix(matrix);
    }

    public int getDegree() {
        return rotateDegree;
    }

    public void setDegree(int degree) {
        rotateDegree = degree;
    }

    public float getScale() {
        return minScale;
    }

    public void setScale(float scale) {
        minScale = scale;
    }
}
