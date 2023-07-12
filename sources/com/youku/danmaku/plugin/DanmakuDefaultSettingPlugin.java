package com.youku.danmaku.plugin;

import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuDefaultSettingPlugin implements IDanmakuSettingPlugin {
    protected float mDensity;

    public DanmakuDefaultSettingPlugin(float f) {
        this.mDensity = f;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public int assignRowForDanmakuInfo(BaseDanmaku baseDanmaku) {
        return 0;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public boolean enableColorFilter() {
        return false;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public int getLineCount() {
        return 2;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public float getLineHeight() {
        return this.mDensity * 24.0f;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public float getLineSpace() {
        return this.mDensity * 6.0f;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public float getTextSize() {
        return this.mDensity * 18.0f;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public float getUniformSpeed() {
        return 0.275f;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public boolean isEnableVideoSpeed() {
        return false;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public boolean isNewCompose() {
        return false;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public boolean isNewHandler() {
        return false;
    }

    @Override // com.youku.danmaku.plugin.IDanmakuSettingPlugin
    public boolean isNewTypesetting() {
        return false;
    }
}
