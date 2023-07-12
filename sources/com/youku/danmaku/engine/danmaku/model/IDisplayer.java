package com.youku.danmaku.engine.danmaku.model;

import com.youku.danmaku.plugin.DanmakuPluginManager;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDisplayer {
    public static final int DANMAKU_STYLE_DEFAULT = -1;
    public static final int DANMAKU_STYLE_NONE = 0;
    public static final int DANMAKU_STYLE_PROJECTION = 3;
    public static final int DANMAKU_STYLE_SHADOW = 1;
    public static final int DANMAKU_STYLE_STROKEN = 2;

    int draw(BaseDanmaku baseDanmaku);

    IDanmakuSettingPlugin getDanmakuSettingPlugin();

    float getDensity();

    int getDensityDpi();

    int getHeight();

    int getMaximumCacheHeight();

    int getMaximumCacheWidth();

    float getScaledDensity();

    int getSlopPixel();

    float getSpacing();

    float getStrokeWidth();

    int getWidth();

    boolean isHardwareAccelerated();

    void measure(BaseDanmaku baseDanmaku, boolean z);

    void recycle(BaseDanmaku baseDanmaku);

    void resetSlopPixel(float f);

    void setDanmakuPlugin(DanmakuPluginManager danmakuPluginManager);

    void setDanmakuStyle(int i, float[] fArr);

    void setDensities(float f, int i, float f2);

    void setHardwareAccelerated(boolean z);

    void setSize(int i, int i2);
}
