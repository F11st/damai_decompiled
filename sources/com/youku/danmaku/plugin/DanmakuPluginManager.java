package com.youku.danmaku.plugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuPluginManager {
    private IDanmakuDataPlugin mDanmakuDataPlugin;
    private IDanmakuLayoutPlugin mDanmakuLayoutPlugin;
    private IDanmakuMonitorPlugin mDanmakuMonitorPlugin;
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private IDanmakuTypePlugin mDanmakuTypePlugin;
    private IDanmakuDrawPlugin mDrawPlugin;

    public IDanmakuDataPlugin getDanmakuDataPlugin() {
        return this.mDanmakuDataPlugin;
    }

    public IDanmakuDrawPlugin getDanmakuDrawPlugin() {
        return this.mDrawPlugin;
    }

    public IDanmakuLayoutPlugin getDanmakuLayoutPlugin() {
        return this.mDanmakuLayoutPlugin;
    }

    public IDanmakuMonitorPlugin getDanmakuMonitorPlugin() {
        return this.mDanmakuMonitorPlugin;
    }

    public IDanmakuSettingPlugin getDanmakuSettingPlugin() {
        return this.mDanmakuSettingPlugin;
    }

    public IDanmakuTypePlugin getDanmakuTypePlugin() {
        return this.mDanmakuTypePlugin;
    }

    public void registerPlugin(IDanmakuDrawPlugin iDanmakuDrawPlugin) {
        this.mDrawPlugin = iDanmakuDrawPlugin;
    }

    public void registerPlugin(IDanmakuDataPlugin iDanmakuDataPlugin) {
        this.mDanmakuDataPlugin = iDanmakuDataPlugin;
    }

    public void registerPlugin(IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
    }

    public void registerPlugin(IDanmakuMonitorPlugin iDanmakuMonitorPlugin) {
        this.mDanmakuMonitorPlugin = iDanmakuMonitorPlugin;
    }

    public void registerPlugin(IDanmakuTypePlugin iDanmakuTypePlugin) {
        this.mDanmakuTypePlugin = iDanmakuTypePlugin;
    }

    public void registerPlugin(IDanmakuLayoutPlugin iDanmakuLayoutPlugin) {
        this.mDanmakuLayoutPlugin = iDanmakuLayoutPlugin;
    }
}
