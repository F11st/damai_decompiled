package com.youku.danmaku.engine.danmaku.model.danmaku;

import com.youku.danmaku.engine.danmaku.model.Duration;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GuideR2LDanmaku extends R2LDanmaku {
    private boolean mIsFirst;

    public GuideR2LDanmaku(Duration duration) {
        this(duration, null);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku, com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void reset() {
        super.reset();
        this.mIsFirst = true;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku
    public void setStepAndCalculateDuration(float f) {
        this.mStepX = f;
        this.duration.value = this.mDistance / f;
        if (this.mIsFirst) {
            this.mIsFirst = false;
            this.time -= (this.paintWidth - 50.0f) / f;
        }
    }

    public GuideR2LDanmaku(Duration duration, IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        super(duration, iDanmakuSettingPlugin);
        this.mIsFirst = true;
    }
}
