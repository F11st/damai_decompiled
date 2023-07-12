package com.youku.danmaku.engine.danmaku.model.danmaku;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.util.DanmakuUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Danmaku extends BaseDanmaku {
    public Danmaku(CharSequence charSequence) {
        DanmakuUtils.fillText(this, charSequence);
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getBottom() {
        return 0.0f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getLeft() {
        return 0.0f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float[] getRectAtTime(IDisplayer iDisplayer, long j) {
        return null;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getRight() {
        return 0.0f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public float getTop() {
        return 0.0f;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public int getType() {
        return 0;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public boolean isShown() {
        return false;
    }

    @Override // com.youku.danmaku.engine.danmaku.model.BaseDanmaku
    public void layout(IDisplayer iDisplayer, float f, float f2) {
    }
}
