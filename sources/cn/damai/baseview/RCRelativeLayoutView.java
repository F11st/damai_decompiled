package cn.damai.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import cn.damai.baseview.rclayouthelper.RCAttrs;
import cn.damai.baseview.rclayouthelper.RCHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RCRelativeLayoutView extends RelativeLayout implements Checkable, RCAttrs {
    private static transient /* synthetic */ IpChange $ipChange;
    RCHelper mRCHelper;

    public RCRelativeLayoutView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792289564")) {
            ipChange.ipc$dispatch("-1792289564", new Object[]{this, canvas});
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
        if (AndroidInstantRuntime.support(ipChange, "-1944557437")) {
            return ((Boolean) ipChange.ipc$dispatch("-1944557437", new Object[]{this, motionEvent})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "1011796554")) {
            ipChange.ipc$dispatch("1011796554", new Object[]{this, canvas});
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
        if (AndroidInstantRuntime.support(ipChange, "1239254782")) {
            ipChange.ipc$dispatch("1239254782", new Object[]{this});
            return;
        }
        super.drawableStateChanged();
        this.mRCHelper.a(this);
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public float getBottomLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1955127457") ? ((Float) ipChange.ipc$dispatch("1955127457", new Object[]{this})).floatValue() : this.mRCHelper.a[4];
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public float getBottomRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1674888670") ? ((Float) ipChange.ipc$dispatch("-1674888670", new Object[]{this})).floatValue() : this.mRCHelper.a[6];
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public int getStrokeColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "770101181") ? ((Integer) ipChange.ipc$dispatch("770101181", new Object[]{this})).intValue() : this.mRCHelper.f;
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public int getStrokeWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "11801210") ? ((Integer) ipChange.ipc$dispatch("11801210", new Object[]{this})).intValue() : this.mRCHelper.h;
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public float getTopLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1517341129") ? ((Float) ipChange.ipc$dispatch("-1517341129", new Object[]{this})).floatValue() : this.mRCHelper.a[0];
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public float getTopRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1947232436") ? ((Float) ipChange.ipc$dispatch("-1947232436", new Object[]{this})).floatValue() : this.mRCHelper.a[2];
    }

    @Override // android.view.View
    public void invalidate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119593636")) {
            ipChange.ipc$dispatch("1119593636", new Object[]{this});
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
        return AndroidInstantRuntime.support(ipChange, "-2021582414") ? ((Boolean) ipChange.ipc$dispatch("-2021582414", new Object[]{this})).booleanValue() : this.mRCHelper.l;
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public boolean isClipBackground() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1061262043") ? ((Boolean) ipChange.ipc$dispatch("1061262043", new Object[]{this})).booleanValue() : this.mRCHelper.i;
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public boolean isRoundAsCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-618988183") ? ((Boolean) ipChange.ipc$dispatch("-618988183", new Object[]{this})).booleanValue() : this.mRCHelper.d;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989256087")) {
            ipChange.ipc$dispatch("1989256087", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mRCHelper.d(this, i, i2);
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setBottomLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1763256450")) {
            ipChange.ipc$dispatch("-1763256450", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.a;
        float f = i;
        fArr[6] = f;
        fArr[7] = f;
        invalidate();
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setBottomRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185992315")) {
            ipChange.ipc$dispatch("-1185992315", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "1876354394")) {
            ipChange.ipc$dispatch("1876354394", new Object[]{this, Boolean.valueOf(z)});
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

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setClipBackground(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1260452329")) {
            ipChange.ipc$dispatch("1260452329", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRCHelper.i = z;
        invalidate();
    }

    public void setOnCheckedChangeListener(RCHelper.OnCheckedChangeListener onCheckedChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579943549")) {
            ipChange.ipc$dispatch("1579943549", new Object[]{this, onCheckedChangeListener});
        } else {
            this.mRCHelper.m = onCheckedChangeListener;
        }
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setRadius(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1734072308")) {
            ipChange.ipc$dispatch("-1734072308", new Object[]{this, Integer.valueOf(i)});
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

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setRoundAsCircle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434360707")) {
            ipChange.ipc$dispatch("434360707", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRCHelper.d = z;
        invalidate();
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setStrokeColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976603667")) {
            ipChange.ipc$dispatch("-976603667", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRCHelper.f = i;
        invalidate();
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setStrokeWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285901008")) {
            ipChange.ipc$dispatch("1285901008", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRCHelper.h = i;
        invalidate();
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setTopLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403828208")) {
            ipChange.ipc$dispatch("-403828208", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        float[] fArr = this.mRCHelper.a;
        float f = i;
        fArr[0] = f;
        fArr[1] = f;
        invalidate();
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setTopRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993389773")) {
            ipChange.ipc$dispatch("-1993389773", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1536693013")) {
            ipChange.ipc$dispatch("-1536693013", new Object[]{this});
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
