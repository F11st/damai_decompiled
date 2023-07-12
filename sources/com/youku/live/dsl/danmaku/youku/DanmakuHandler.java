package com.youku.live.dsl.danmaku.youku;

import android.os.Handler;
import android.os.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.controller.IDanmakuView;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DanmakuHandler extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;
    volatile WeakReference<IDanmakuView> danmakuViewWeakReference;

    public DanmakuHandler(IDanmakuView iDanmakuView) {
        this.danmakuViewWeakReference = new WeakReference<>(iDanmakuView);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IDanmakuView iDanmakuView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248782591")) {
            ipChange.ipc$dispatch("1248782591", new Object[]{this, message});
            return;
        }
        BaseDanmaku baseDanmaku = (BaseDanmaku) message.obj;
        if (this.danmakuViewWeakReference == null || (iDanmakuView = this.danmakuViewWeakReference.get()) == null) {
            return;
        }
        iDanmakuView.addDanmaku(baseDanmaku);
    }
}
