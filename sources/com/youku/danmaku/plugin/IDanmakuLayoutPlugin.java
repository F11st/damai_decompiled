package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.renderer.android.DanmakusRetainer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDanmakuLayoutPlugin {
    void clear();

    DanmakusRetainer.IDanmakusRetainer getDanmakuLayout(BaseDanmaku baseDanmaku);
}
