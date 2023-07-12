package com.youku.danmaku.engine.danmaku.model;

import com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer;
import com.youku.danmaku.plugin.DanmakuPluginManager;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class AbsDisplayer<T, F> implements IDisplayer {
    public abstract void clearTextHeightCache();

    public abstract void drawDanmaku(BaseDanmaku baseDanmaku, T t, float f, float f2, boolean z);

    public abstract BaseCacheStuffer getCacheStuffer();

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public IDanmakuSettingPlugin getDanmakuSettingPlugin() {
        return null;
    }

    public abstract T getExtraData();

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public boolean isHardwareAccelerated() {
        return false;
    }

    public void setAllmargin(float f) {
    }

    public abstract void setCacheStuffer(BaseCacheStuffer baseCacheStuffer);

    @Override // com.youku.danmaku.engine.danmaku.model.IDisplayer
    public void setDanmakuPlugin(DanmakuPluginManager danmakuPluginManager) {
    }

    public abstract void setExtraData(T t);

    public abstract void setFakeBoldText(boolean z);

    public abstract void setIconPaintTypeFace(F f);

    public abstract void setPaintStrokeWidth(float f);

    public abstract void setScaleTextSizeFactor(float f);

    public abstract void setTransparency(int i);

    public abstract void setTypeFace(F f);
}
