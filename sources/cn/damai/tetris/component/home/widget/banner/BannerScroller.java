package cn.damai.tetris.component.home.widget.banner;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BannerScroller extends Scroller {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mDuration;

    public BannerScroller(Context context) {
        super(context);
        this.mDuration = 800;
    }

    public void setDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1091958931")) {
            ipChange.ipc$dispatch("-1091958931", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDuration = i;
        }
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057192038")) {
            ipChange.ipc$dispatch("2057192038", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        } else {
            super.startScroll(i, i2, i3, i4, this.mDuration);
        }
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451833405")) {
            ipChange.ipc$dispatch("1451833405", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.startScroll(i, i2, i3, i4, this.mDuration);
        }
    }

    public BannerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.mDuration = 800;
    }

    public BannerScroller(Context context, Interpolator interpolator, boolean z) {
        super(context, interpolator, z);
        this.mDuration = 800;
    }
}
