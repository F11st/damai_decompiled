package com.youku.live.dsl.danmaku.youku;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DanmakuParser extends BaseDanmakuParser {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser
    public Danmakus parse() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1209244759") ? (Danmakus) ipChange.ipc$dispatch("-1209244759", new Object[]{this}) : new Danmakus();
    }
}
