package com.youku.live.dsl.danmaku.youku;

import android.text.Spanned;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class BaseCacheStufferProxy extends BaseCacheStuffer.Proxy {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer.Proxy
    public void prepareDrawing(BaseDanmaku baseDanmaku, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083522897")) {
            ipChange.ipc$dispatch("-1083522897", new Object[]{this, baseDanmaku, Boolean.valueOf(z)});
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer.Proxy
    public void releaseResource(BaseDanmaku baseDanmaku) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349410471")) {
            ipChange.ipc$dispatch("-1349410471", new Object[]{this, baseDanmaku});
            return;
        }
        if (baseDanmaku.text instanceof Spanned) {
            baseDanmaku.text = "";
        }
        baseDanmaku.tag = null;
    }
}
