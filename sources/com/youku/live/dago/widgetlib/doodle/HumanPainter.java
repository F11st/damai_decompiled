package com.youku.live.dago.widgetlib.doodle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HumanPainter extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_DRAW_DISTANCE = 200;
    private float mCurrentDrawDistance;
    private Drawable mDrawable;
    private int mDrawableBoundsXOffset;
    private int mDrawableBoundsYOffset;
    private int mDrawingDistance;
    private int mIconIdentity;
    private float mLastX;
    private float mLastY;
    private SketchBoard mSketchBoard;

    public HumanPainter(Context context) {
        this(context, null);
    }

    private void draw(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067261596")) {
            ipChange.ipc$dispatch("-2067261596", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
        } else if (this.mSketchBoard == null || this.mDrawable == null) {
        } else {
            updateOffset();
            this.mSketchBoard.draw(this.mDrawable, this.mIconIdentity, ((int) f) - this.mDrawableBoundsXOffset, ((int) f2) - this.mDrawableBoundsYOffset);
        }
    }

    private void updateOffset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449414892")) {
            ipChange.ipc$dispatch("1449414892", new Object[]{this});
            return;
        }
        this.mDrawableBoundsXOffset = Rect.width(this.mDrawable.getBounds()) / 2;
        this.mDrawableBoundsYOffset = Rect.height(this.mDrawable.getBounds()) / 2;
        setDrawDistance(Rect.width(this.mDrawable.getBounds()));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1409381667") ? ((Boolean) ipChange.ipc$dispatch("-1409381667", new Object[]{this, motionEvent})).booleanValue() : isEnabled();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555575897")) {
            return ((Boolean) ipChange.ipc$dispatch("-555575897", new Object[]{this, motionEvent})).booleanValue();
        }
        if (isEnabled()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mCurrentDrawDistance = 0.0f;
                draw(x, y);
            } else if (action == 1) {
                if (this.mLastX != x && this.mLastY != y) {
                    draw(x, y);
                }
                this.mCurrentDrawDistance = 0.0f;
            } else if (action == 2) {
                float f = x - this.mLastX;
                float f2 = y - this.mLastY;
                float sqrt = (float) (this.mCurrentDrawDistance + Math.sqrt((f * f) + (f2 * f2)));
                this.mCurrentDrawDistance = sqrt;
                if (sqrt >= this.mDrawingDistance) {
                    draw(x, y);
                    this.mCurrentDrawDistance = 0.0f;
                }
            }
            this.mLastX = x;
            this.mLastY = y;
            return true;
        }
        return false;
    }

    public void setDrawDistance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4619332")) {
            ipChange.ipc$dispatch("-4619332", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDrawingDistance = i;
        }
    }

    public void setDrawable(int i, @NonNull Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "700930469")) {
            ipChange.ipc$dispatch("700930469", new Object[]{this, Integer.valueOf(i), drawable});
            return;
        }
        this.mIconIdentity = i;
        this.mDrawable = drawable;
        updateOffset();
    }

    public void setSketchBoard(@NonNull SketchBoard sketchBoard) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-964278606")) {
            ipChange.ipc$dispatch("-964278606", new Object[]{this, sketchBoard});
        } else {
            this.mSketchBoard = sketchBoard;
        }
    }

    public HumanPainter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HumanPainter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawingDistance = 200;
        this.mCurrentDrawDistance = 0.0f;
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
    }
}
