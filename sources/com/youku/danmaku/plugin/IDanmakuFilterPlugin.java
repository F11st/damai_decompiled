package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.controller.DanmakuFilters;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDanmakuFilterPlugin {
    DanmakuFilters.IDanmakuFilter<?> getFilter(String str);
}
