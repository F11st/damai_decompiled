package cn.damai.ticklet.view;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ViewPagerScroller extends Scroller {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Interpolator sInterpolator = new animationInterpolatorC2131a();
    private int mScrollDuration;
    public boolean noDuration;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.ViewPagerScroller$a  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class animationInterpolatorC2131a implements Interpolator {
        private static transient /* synthetic */ IpChange $ipChange;

        animationInterpolatorC2131a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "357664186")) {
                return ((Float) ipChange.ipc$dispatch("357664186", new Object[]{this, Float.valueOf(f)})).floatValue();
            }
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public ViewPagerScroller(Context context) {
        super(context);
        this.mScrollDuration = 800;
    }

    public void setNoDuration(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173907432")) {
            ipChange.ipc$dispatch("-1173907432", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.noDuration = z;
        }
    }

    public void setScrollDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1982614867")) {
            ipChange.ipc$dispatch("1982614867", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mScrollDuration = i;
        }
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792748193")) {
            ipChange.ipc$dispatch("-792748193", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        } else if (this.noDuration) {
            super.startScroll(i, i2, i3, i4, 0);
        } else {
            super.startScroll(i, i2, i3, i4, this.mScrollDuration);
        }
    }

    public ViewPagerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.mScrollDuration = 800;
    }
}
