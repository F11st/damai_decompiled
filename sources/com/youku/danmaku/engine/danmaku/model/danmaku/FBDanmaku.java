package com.youku.danmaku.engine.danmaku.model.danmaku;

import com.youku.danmaku.engine.danmaku.model.Duration;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FBDanmaku extends FTDanmaku {
    public FBDanmaku(Duration duration) {
        super(duration);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.FTDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public int getType() {
        return 4;
    }
}
