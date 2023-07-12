package com.youku.tinywindow.floatwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.youku.tinywindow.R;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FloatingLayout extends FrameLayout {
    private long endTime;
    private boolean isclick;
    private FloatingWindowClickCallBack mCallback;
    private Context mContext;
    private float mTouchStartX;
    private float mTouchStartY;
    private final WindowManager mWindowManager;
    private WindowManager.LayoutParams mWmParams;
    private long startTime;

    public FloatingLayout(Context context, FloatingWindowClickCallBack floatingWindowClickCallBack) {
        this(context, null, floatingWindowClickCallBack);
        this.mContext = context;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FloatingWindowClickCallBack floatingWindowClickCallBack;
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTime = System.currentTimeMillis();
            this.mTouchStartX = motionEvent.getX();
            this.mTouchStartY = motionEvent.getY();
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            this.endTime = currentTimeMillis;
            if (currentTimeMillis - this.startTime > 100.0d) {
                this.isclick = false;
            } else {
                this.isclick = true;
            }
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (Math.abs(this.mTouchStartX - x) > 1.0f && Math.abs(this.mTouchStartY - y) > 1.0f) {
                WindowManager.LayoutParams layoutParams = this.mWmParams;
                layoutParams.x = (int) (rawX - this.mTouchStartX);
                layoutParams.y = (int) (rawY - this.mTouchStartY);
                this.mWindowManager.updateViewLayout(this, layoutParams);
                return false;
            }
        }
        if (this.isclick && (floatingWindowClickCallBack = this.mCallback) != null) {
            floatingWindowClickCallBack.onFloatingWindowClick();
        }
        return true;
    }

    public void setParams(WindowManager.LayoutParams layoutParams) {
        this.mWmParams = layoutParams;
    }

    public FloatingLayout(Context context, AttributeSet attributeSet, FloatingWindowClickCallBack floatingWindowClickCallBack) {
        super(context, attributeSet);
        this.mCallback = floatingWindowClickCallBack;
        this.mWindowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
        LayoutInflater.from(context).inflate(R.layout.tinywindow_floatingwindow_root_layout, this);
    }
}
