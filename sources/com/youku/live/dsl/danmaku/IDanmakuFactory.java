package com.youku.live.dsl.danmaku;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDanmakuFactory {
    IDanmakuController createController(Context context);

    IDanmakuController createController(Context context, DanmakuControllerConfig danmakuControllerConfig);
}
