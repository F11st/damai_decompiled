package cn.damai.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.FrameLayout;
import cn.damai.baseview.rclayouthelper.RCAttrs;
import cn.damai.baseview.rclayouthelper.RCHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RCFrameLayoutLayoutView extends FrameLayout implements Checkable, RCAttrs {
    private static transient /* synthetic */ IpChange $ipChange;
    RCHelper mRCHelper;

    public RCFrameLayoutLayoutView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-61138065")) {
            ipChange.ipc$dispatch("-61138065", new Object[]{this, canvas});
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
        if (AndroidInstantRuntime.support(ipChange, "2073149336")) {
            return ((Boolean) ipChange.ipc$dispatch("2073149336", new Object[]{this, motionEvent})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-169423915")) {
            ipChange.ipc$dispatch("-169423915", new Object[]{this, canvas});
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
        if (AndroidInstantRuntime.support(ipChange, "-829256429")) {
            ipChange.ipc$dispatch("-829256429", new Object[]{this});
            return;
        }
        super.drawableStateChanged();
        this.mRCHelper.a(this);
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public float getBottomLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "918569964") ? ((Float) ipChange.ipc$dispatch("918569964", new Object[]{this})).floatValue() : this.mRCHelper.a[4];
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public float getBottomRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "551567415") ? ((Float) ipChange.ipc$dispatch("551567415", new Object[]{this})).floatValue() : this.mRCHelper.a[6];
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public int getStrokeColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "134957458") ? ((Integer) ipChange.ipc$dispatch("134957458", new Object[]{this})).intValue() : this.mRCHelper.f;
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public int getStrokeWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-623342513") ? ((Integer) ipChange.ipc$dispatch("-623342513", new Object[]{this})).intValue() : this.mRCHelper.h;
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public float getTopLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2005102900") ? ((Float) ipChange.ipc$dispatch("-2005102900", new Object[]{this})).floatValue() : this.mRCHelper.a[0];
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public float getTopRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "112021847") ? ((Float) ipChange.ipc$dispatch("112021847", new Object[]{this})).floatValue() : this.mRCHelper.a[2];
    }

    @Override // android.view.View
    public void invalidate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449677049")) {
            ipChange.ipc$dispatch("1449677049", new Object[]{this});
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
        return AndroidInstantRuntime.support(ipChange, "1175654077") ? ((Boolean) ipChange.ipc$dispatch("1175654077", new Object[]{this})).booleanValue() : this.mRCHelper.l;
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public boolean isClipBackground() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "573500272") ? ((Boolean) ipChange.ipc$dispatch("573500272", new Object[]{this})).booleanValue() : this.mRCHelper.i;
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public boolean isRoundAsCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1166392884") ? ((Boolean) ipChange.ipc$dispatch("1166392884", new Object[]{this})).booleanValue() : this.mRCHelper.d;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246456926")) {
            ipChange.ipc$dispatch("-246456926", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mRCHelper.d(this, i, i2);
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setBottomLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "463199635")) {
            ipChange.ipc$dispatch("463199635", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-885330416")) {
            ipChange.ipc$dispatch("-885330416", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-775961691")) {
            ipChange.ipc$dispatch("-775961691", new Object[]{this, Boolean.valueOf(z)});
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
        if (AndroidInstantRuntime.support(ipChange, "672825662")) {
            ipChange.ipc$dispatch("672825662", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRCHelper.i = z;
        invalidate();
    }

    public void setOnCheckedChangeListener(RCHelper.OnCheckedChangeListener onCheckedChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311911944")) {
            ipChange.ipc$dispatch("1311911944", new Object[]{this, onCheckedChangeListener});
        } else {
            this.mRCHelper.m = onCheckedChangeListener;
        }
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setRadius(int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1403988895")) {
            ipChange.ipc$dispatch("-1403988895", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1801352306")) {
            ipChange.ipc$dispatch("-1801352306", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mRCHelper.d = z;
        invalidate();
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setStrokeColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808777400")) {
            ipChange.ipc$dispatch("808777400", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRCHelper.f = i;
        invalidate();
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setStrokeWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223685221")) {
            ipChange.ipc$dispatch("-1223685221", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRCHelper.h = i;
        invalidate();
    }

    @Override // cn.damai.baseview.rclayouthelper.RCAttrs
    public void setTopLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1655426075")) {
            ipChange.ipc$dispatch("1655426075", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "1713950856")) {
            ipChange.ipc$dispatch("1713950856", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "1855589312")) {
            ipChange.ipc$dispatch("1855589312", new Object[]{this});
        } else {
            setChecked(!this.mRCHelper.l);
        }
    }

    public RCFrameLayoutLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCFrameLayoutLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RCHelper rCHelper = new RCHelper();
        this.mRCHelper = rCHelper;
        rCHelper.b(context, attributeSet);
    }
}
