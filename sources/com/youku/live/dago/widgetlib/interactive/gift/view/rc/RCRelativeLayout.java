package com.youku.live.dago.widgetlib.interactive.gift.view.rc;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCHelper;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RCRelativeLayout extends RelativeLayout implements Checkable, RCAttrs {
    private static transient /* synthetic */ IpChange $ipChange;
    RCHelper mRCHelper;

    public RCRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661355070")) {
            ipChange.ipc$dispatch("-661355070", new Object[]{this, canvas});
            return;
        }
        canvas.saveLayer(this.mRCHelper.mLayer, null, 31);
        super.dispatchDraw(canvas);
        this.mRCHelper.onClipDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "130982373")) {
            return ((Boolean) ipChange.ipc$dispatch("130982373", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0 || this.mRCHelper.mAreaRegion.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
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
        if (AndroidInstantRuntime.support(ipChange, "-1028835032")) {
            ipChange.ipc$dispatch("-1028835032", new Object[]{this, canvas});
        } else if (this.mRCHelper.mClipBackground) {
            canvas.save();
            canvas.clipPath(this.mRCHelper.mClipPath);
            super.draw(canvas);
            canvas.restore();
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-526170528")) {
            ipChange.ipc$dispatch("-526170528", new Object[]{this});
            return;
        }
        super.drawableStateChanged();
        this.mRCHelper.drawableStateChanged(this);
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public float getBottomLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-734221057") ? ((Float) ipChange.ipc$dispatch("-734221057", new Object[]{this})).floatValue() : this.mRCHelper.radii[4];
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public float getBottomRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "854653316") ? ((Float) ipChange.ipc$dispatch("854653316", new Object[]{this})).floatValue() : this.mRCHelper.radii[6];
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public int getStrokeColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1103085409") ? ((Integer) ipChange.ipc$dispatch("-1103085409", new Object[]{this})).intValue() : this.mRCHelper.mStrokeColor;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public int getStrokeWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1861385380") ? ((Integer) ipChange.ipc$dispatch("-1861385380", new Object[]{this})).intValue() : this.mRCHelper.mStrokeWidth;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public float getTopLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2058357095") ? ((Float) ipChange.ipc$dispatch("-2058357095", new Object[]{this})).floatValue() : this.mRCHelper.radii[0];
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public float getTopRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1538858198") ? ((Float) ipChange.ipc$dispatch("-1538858198", new Object[]{this})).floatValue() : this.mRCHelper.radii[2];
    }

    @Override // android.view.View
    public void invalidate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "816109190")) {
            ipChange.ipc$dispatch("816109190", new Object[]{this});
            return;
        }
        RCHelper rCHelper = this.mRCHelper;
        if (rCHelper != null) {
            rCHelper.refreshRegion(this);
        }
        super.invalidate();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1016669072") ? ((Boolean) ipChange.ipc$dispatch("1016669072", new Object[]{this})).booleanValue() : this.mRCHelper.mChecked;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public boolean isClipBackground() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "520246077") ? ((Boolean) ipChange.ipc$dispatch("520246077", new Object[]{this})).booleanValue() : this.mRCHelper.mClipBackground;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public boolean isRoundAsCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1441769671") ? ((Boolean) ipChange.ipc$dispatch("1441769671", new Object[]{this})).booleanValue() : this.mRCHelper.mRoundAsCircle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1897336971")) {
            ipChange.ipc$dispatch("-1897336971", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mRCHelper.onSizeChanged(this, i, i2);
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setBottomLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "766285536")) {
            ipChange.ipc$dispatch("766285536", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.radii;
        float f = i;
        fArr[6] = f;
        fArr[7] = f;
        invalidate();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setBottomRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-79602077")) {
            ipChange.ipc$dispatch("-79602077", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.radii;
        float f = i;
        fArr[4] = f;
        fArr[5] = f;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058271160")) {
            ipChange.ipc$dispatch("1058271160", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RCHelper rCHelper = this.mRCHelper;
        if (rCHelper.mChecked != z) {
            rCHelper.mChecked = z;
            refreshDrawableState();
            RCHelper rCHelper2 = this.mRCHelper;
            RCHelper.OnCheckedChangeListener onCheckedChangeListener = rCHelper2.mOnCheckedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, rCHelper2.mChecked);
            }
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setClipBackground(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1035151819")) {
            ipChange.ipc$dispatch("1035151819", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRCHelper.mClipBackground = z;
        invalidate();
    }

    public void setOnCheckedChangeListener(RCHelper.OnCheckedChangeListener onCheckedChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67606150")) {
            ipChange.ipc$dispatch("67606150", new Object[]{this, onCheckedChangeListener});
        } else {
            this.mRCHelper.mOnCheckedChangeListener = onCheckedChangeListener;
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setRadius(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2037556754")) {
            ipChange.ipc$dispatch("-2037556754", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        while (true) {
            float[] fArr = this.mRCHelper.radii;
            if (i2 < fArr.length) {
                fArr[i2] = i;
                i2++;
            } else {
                invalidate();
                return;
            }
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setRoundAsCircle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842734945")) {
            ipChange.ipc$dispatch("842734945", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRCHelper.mRoundAsCircle = z;
        invalidate();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setStrokeColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084154187")) {
            ipChange.ipc$dispatch("1084154187", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRCHelper.mStrokeColor = i;
        invalidate();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setStrokeWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-948308434")) {
            ipChange.ipc$dispatch("-948308434", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRCHelper.mStrokeWidth = i;
        invalidate();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setTopLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4546030")) {
            ipChange.ipc$dispatch("4546030", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.radii;
        float f = i;
        fArr[0] = f;
        fArr[1] = f;
        invalidate();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.rc.RCAttrs
    public void setTopRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076277013")) {
            ipChange.ipc$dispatch("2076277013", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.radii;
        float f = i;
        fArr[2] = f;
        fArr[3] = f;
        invalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404135987")) {
            ipChange.ipc$dispatch("-404135987", new Object[]{this});
        } else {
            setChecked(!this.mRCHelper.mChecked);
        }
    }

    public RCRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RCHelper rCHelper = new RCHelper();
        this.mRCHelper = rCHelper;
        rCHelper.initAttrs(context, attributeSet);
    }
}
