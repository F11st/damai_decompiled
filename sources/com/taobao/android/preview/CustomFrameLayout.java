package com.taobao.android.preview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CustomFrameLayout extends FrameLayout {
    private final String TAG;
    boolean isConsumed;
    Runnable runnable;
    float x;
    float y;

    public CustomFrameLayout(@NonNull Context context) {
        super(context);
        this.TAG = getClass().getName();
        this.isConsumed = false;
        this.runnable = new Runnable() { // from class: com.taobao.android.preview.CustomFrameLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CustomFrameLayout.this.isConsumed = true;
                try {
                    new JSONObject(CustomFrameLayout.this.getContentDescription().toString()).toString(4);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.x = motionEvent.getX();
            this.y = motionEvent.getY();
            this.isConsumed = false;
            getHandler().postDelayed(this.runnable, 1500L);
            return super.onInterceptTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 1) {
            if (this.isConsumed) {
                return true;
            }
            getHandler().removeCallbacks(this.runnable);
            return super.onInterceptTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 2 && Math.abs(motionEvent.getX() - this.x) > 32.0f && Math.abs(motionEvent.getY() - this.y) > 32.0f && !this.isConsumed) {
            getHandler().removeCallbacks(this.runnable);
            return super.onInterceptTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 3) {
            if (this.isConsumed) {
                return true;
            }
            getHandler().removeCallbacks(this.runnable);
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
