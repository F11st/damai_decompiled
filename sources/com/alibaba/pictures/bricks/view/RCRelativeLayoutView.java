package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs;
import com.alibaba.pictures.bricks.view.rclayouthelper.RCHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RCRelativeLayoutView extends RelativeLayout implements Checkable, RCAttrs {
    private static transient /* synthetic */ IpChange $ipChange;
    RCHelper mRCHelper;

    public RCRelativeLayoutView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394586764")) {
            ipChange.ipc$dispatch("-394586764", new Object[]{this, canvas});
            return;
        }
        canvas.saveLayer(this.mRCHelper.k, null, 31);
        super.dispatchDraw(canvas);
        this.mRCHelper.c(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1808426483")) {
            return ((Boolean) ipChange.ipc$dispatch("1808426483", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0 || this.mRCHelper.j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (action == 0 || action == 1) {
                refreshDrawableState();
            } else if (action == 3) {
                setPressed(false);
                refreshDrawableState();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787454682")) {
            ipChange.ipc$dispatch("787454682", new Object[]{this, canvas});
        } else if (this.mRCHelper.i) {
            canvas.save();
            canvas.clipPath(this.mRCHelper.b);
            super.draw(canvas);
            canvas.restore();
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-767241106")) {
            ipChange.ipc$dispatch("-767241106", new Object[]{this});
            return;
        }
        super.drawableStateChanged();
        this.mRCHelper.a(this);
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public float getBottomLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-464902863") ? ((Float) ipChange.ipc$dispatch("-464902863", new Object[]{this})).floatValue() : this.mRCHelper.a[4];
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public float getBottomRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "613582738") ? ((Float) ipChange.ipc$dispatch("613582738", new Object[]{this})).floatValue() : this.mRCHelper.a[6];
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public int getStrokeColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1284443859") ? ((Integer) ipChange.ipc$dispatch("-1284443859", new Object[]{this})).intValue() : this.mRCHelper.f;
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public int getStrokeWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2042743830") ? ((Integer) ipChange.ipc$dispatch("-2042743830", new Object[]{this})).intValue() : this.mRCHelper.h;
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public float getTopLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-250168409") ? ((Float) ipChange.ipc$dispatch("-250168409", new Object[]{this})).floatValue() : this.mRCHelper.a[0];
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public float getTopRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1319583780") ? ((Float) ipChange.ipc$dispatch("-1319583780", new Object[]{this})).floatValue() : this.mRCHelper.a[2];
    }

    @Override // android.view.View
    public void invalidate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779433964")) {
            ipChange.ipc$dispatch("-1779433964", new Object[]{this});
            return;
        }
        RCHelper rCHelper = this.mRCHelper;
        if (rCHelper != null) {
            rCHelper.e(this);
        }
        super.invalidate();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1487131202") ? ((Boolean) ipChange.ipc$dispatch("1487131202", new Object[]{this})).booleanValue() : this.mRCHelper.l;
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public boolean isClipBackground() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1966532533") ? ((Boolean) ipChange.ipc$dispatch("-1966532533", new Object[]{this})).booleanValue() : this.mRCHelper.i;
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public boolean isRoundAsCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "114625017") ? ((Boolean) ipChange.ipc$dispatch("114625017", new Object[]{this})).booleanValue() : this.mRCHelper.d;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1678062553")) {
            ipChange.ipc$dispatch("-1678062553", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mRCHelper.d(this, i, i2);
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setBottomLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "525214958")) {
            ipChange.ipc$dispatch("525214958", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.a;
        float f = i;
        fArr[6] = f;
        fArr[7] = f;
        invalidate();
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setBottomRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037144597")) {
            ipChange.ipc$dispatch("1037144597", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.a;
        float f = i;
        fArr[4] = f;
        fArr[5] = f;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2094155286")) {
            ipChange.ipc$dispatch("-2094155286", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RCHelper rCHelper = this.mRCHelper;
        if (rCHelper.l != z) {
            rCHelper.l = z;
            refreshDrawableState();
            RCHelper rCHelper2 = this.mRCHelper;
            RCHelper.OnCheckedChangeListener onCheckedChangeListener = rCHelper2.m;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, rCHelper2.l);
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setClipBackground(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757275815")) {
            ipChange.ipc$dispatch("-757275815", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRCHelper.i = z;
        invalidate();
    }

    public void setOnCheckedChangeListener(RCHelper.OnCheckedChangeListener onCheckedChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1266861933")) {
            ipChange.ipc$dispatch("1266861933", new Object[]{this, onCheckedChangeListener});
        } else {
            this.mRCHelper.m = onCheckedChangeListener;
        }
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setRadius(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-338132612")) {
            ipChange.ipc$dispatch("-338132612", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        while (true) {
            float[] fArr = this.mRCHelper.a;
            if (i2 < fArr.length) {
                fArr[i2] = i;
                i2++;
            } else {
                invalidate();
                return;
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setRoundAsCircle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1062009363")) {
            ipChange.ipc$dispatch("1062009363", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRCHelper.d = z;
        invalidate();
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setStrokeColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242990467")) {
            ipChange.ipc$dispatch("-242990467", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRCHelper.f = i;
        invalidate();
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setStrokeWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019514208")) {
            ipChange.ipc$dispatch("2019514208", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRCHelper.h = i;
        invalidate();
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setTopLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223820448")) {
            ipChange.ipc$dispatch("223820448", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.a;
        float f = i;
        fArr[0] = f;
        fArr[1] = f;
        invalidate();
    }

    @Override // com.alibaba.pictures.bricks.view.rclayouthelper.RCAttrs
    public void setTopRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283849379")) {
            ipChange.ipc$dispatch("283849379", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.a;
        float f = i;
        fArr[2] = f;
        fArr[3] = f;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484278693")) {
            ipChange.ipc$dispatch("-484278693", new Object[]{this});
        } else {
            setChecked(!this.mRCHelper.l);
        }
    }

    public RCRelativeLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCRelativeLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RCHelper rCHelper = new RCHelper();
        this.mRCHelper = rCHelper;
        rCHelper.b(context, attributeSet);
    }
}
