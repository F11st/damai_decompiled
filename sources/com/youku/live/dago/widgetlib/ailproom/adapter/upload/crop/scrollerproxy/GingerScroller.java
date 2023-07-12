package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy;

import android.content.Context;
import android.widget.OverScroller;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GingerScroller extends ScrollerProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean mFirstScroll = false;
    final OverScroller mScroller;

    public GingerScroller(Context context) {
        this.mScroller = new OverScroller(context);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046755443")) {
            return ((Boolean) ipChange.ipc$dispatch("-2046755443", new Object[]{this})).booleanValue();
        }
        if (this.mFirstScroll) {
            this.mScroller.computeScrollOffset();
            this.mFirstScroll = false;
        }
        return this.mScroller.computeScrollOffset();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073014844")) {
            ipChange.ipc$dispatch("-2073014844", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)});
        } else {
            this.mScroller.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public void forceFinished(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "221433873")) {
            ipChange.ipc$dispatch("221433873", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mScroller.forceFinished(z);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public int getCurrX() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "292185741") ? ((Integer) ipChange.ipc$dispatch("292185741", new Object[]{this})).intValue() : this.mScroller.getCurrX();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public int getCurrY() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "292215532") ? ((Integer) ipChange.ipc$dispatch("292215532", new Object[]{this})).intValue() : this.mScroller.getCurrY();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.scrollerproxy.ScrollerProxy
    public boolean isFinished() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-908666670") ? ((Boolean) ipChange.ipc$dispatch("-908666670", new Object[]{this})).booleanValue() : this.mScroller.isFinished();
    }
}
