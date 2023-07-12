package com.youku.live.dsl.danmaku.youku;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.controller.DrawHandler;
import com.youku.danmaku.engine.controller.IDanmakuView;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DrawHandlerCallback implements DrawHandler.Callback {
    private static transient /* synthetic */ IpChange $ipChange;
    volatile WeakReference<IDanmakuView> danmakuViewWeakReference;
    volatile long timeShown = 0;
    volatile int indexShown = 0;

    public DrawHandlerCallback(IDanmakuView iDanmakuView) {
        this.danmakuViewWeakReference = new WeakReference<>(iDanmakuView);
    }

    @Override // com.youku.danmaku.engine.controller.DrawHandler.Callback
    public void danmakuShown(BaseDanmaku baseDanmaku) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-795762649")) {
            ipChange.ipc$dispatch("-795762649", new Object[]{this, baseDanmaku});
            return;
        }
        this.timeShown = baseDanmaku.time;
        this.indexShown = baseDanmaku.index;
    }

    @Override // com.youku.danmaku.engine.controller.DrawHandler.Callback
    public void drawingFinished() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1354757409")) {
            ipChange.ipc$dispatch("1354757409", new Object[]{this});
        }
    }

    public int getIndexShown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2140544689") ? ((Integer) ipChange.ipc$dispatch("-2140544689", new Object[]{this})).intValue() : this.indexShown;
    }

    public long getTimeShown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1603835841") ? ((Long) ipChange.ipc$dispatch("-1603835841", new Object[]{this})).longValue() : this.timeShown;
    }

    @Override // com.youku.danmaku.engine.controller.DrawHandler.Callback
    public void prepared() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390149828")) {
            ipChange.ipc$dispatch("-1390149828", new Object[]{this});
            return;
        }
        try {
            IDanmakuView iDanmakuView = this.danmakuViewWeakReference.get();
            if (iDanmakuView != null) {
                iDanmakuView.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.youku.danmaku.engine.controller.DrawHandler.Callback
    public void updateTimer(DanmakuTimer danmakuTimer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864845673")) {
            ipChange.ipc$dispatch("-1864845673", new Object[]{this, danmakuTimer});
        } else {
            this.timeShown = danmakuTimer.currMillisecond;
        }
    }
}
