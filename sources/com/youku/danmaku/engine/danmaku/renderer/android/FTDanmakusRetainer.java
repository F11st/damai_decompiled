package com.youku.danmaku.engine.danmaku.renderer.android;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FTDanmakusRetainer extends RLDanmakusRetainer {
    @Override // com.youku.danmaku.engine.danmaku.renderer.android.RLDanmakusRetainer
    protected boolean isOutVerticalEdge(boolean z, BaseDanmaku baseDanmaku, IDisplayer iDisplayer, float f, BaseDanmaku baseDanmaku2, BaseDanmaku baseDanmaku3) {
        return f + baseDanmaku.paintHeight > ((float) iDisplayer.getHeight());
    }
}
