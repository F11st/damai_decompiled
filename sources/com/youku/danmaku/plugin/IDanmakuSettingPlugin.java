package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IDanmakuSettingPlugin {
    int assignRowForDanmakuInfo(BaseDanmaku baseDanmaku);

    boolean enableColorFilter();

    int getLineCount();

    float getLineHeight();

    float getLineSpace();

    float getTextSize();

    float getUniformSpeed();

    boolean isEnableVideoSpeed();

    boolean isNewCompose();

    boolean isNewHandler();

    boolean isNewTypesetting();
}
