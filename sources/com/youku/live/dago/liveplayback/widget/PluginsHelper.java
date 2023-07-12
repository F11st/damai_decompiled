package com.youku.live.dago.liveplayback.widget;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.PluginConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PluginsHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Map<String, PluginConfig> initNonPlayerPluginConfigs(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "346661200")) {
            return (Map) ipChange.ipc$dispatch("346661200", new Object[]{context});
        }
        HashMap hashMap = new HashMap();
        if (Utils.isYoukuOrHuaweiBaipai(context)) {
            PluginConfig pluginConfig = new PluginConfig();
            pluginConfig.setName(PluginName.PLUGIN_DLNA);
            pluginConfig.setLayerId(AlixPlayerContext.LAYER_BEYOND);
            pluginConfig.setMajorLevel(50);
            pluginConfig.setEnable(true);
            pluginConfig.setLazyLoad(false);
            hashMap.put(pluginConfig.getName(), pluginConfig);
        }
        PluginConfig pluginConfig2 = new PluginConfig();
        pluginConfig2.setName(PluginName.DANMU);
        pluginConfig2.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig2.setMajorLevel(50);
        pluginConfig2.setEnable(true);
        hashMap.put(pluginConfig2.getName(), pluginConfig2);
        PluginConfig pluginConfig3 = new PluginConfig();
        pluginConfig3.setName(PluginName.PLAYER_VERTICAL_SMALLSCREEN_CONTROL);
        pluginConfig3.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig3.setMajorLevel(100);
        pluginConfig3.setEnable(true);
        pluginConfig3.setLazyLoad(false);
        hashMap.put(pluginConfig3.getName(), pluginConfig3);
        PluginConfig pluginConfig4 = new PluginConfig();
        pluginConfig4.setName(PluginName.PLAYER_HORIZONTAL_FULLSCREEN_CONTROL);
        pluginConfig4.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig4.setMajorLevel(150);
        pluginConfig4.setEnable(false);
        pluginConfig4.setLazyLoad(false);
        hashMap.put(pluginConfig4.getName(), pluginConfig4);
        PluginConfig pluginConfig5 = new PluginConfig();
        pluginConfig5.setName(PluginName.PLAYER_VERTICAL_FULLSCREEN_CONTROL);
        pluginConfig5.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig5.setMajorLevel(200);
        pluginConfig5.setEnable(true);
        pluginConfig5.setLazyLoad(false);
        hashMap.put(pluginConfig5.getName(), pluginConfig5);
        PluginConfig pluginConfig6 = new PluginConfig();
        pluginConfig6.setName(PluginName.PLUGIN_TRAIL);
        pluginConfig6.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig6.setMajorLevel(300);
        pluginConfig6.setEnable(true);
        hashMap.put(pluginConfig6.getName(), pluginConfig6);
        PluginConfig pluginConfig7 = new PluginConfig();
        pluginConfig7.setName(PluginName.TOP_TIP_PLUGIN);
        pluginConfig7.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig7.setMajorLevel(400);
        pluginConfig7.setEnable(true);
        pluginConfig7.setLazyLoad(false);
        hashMap.put(pluginConfig7.getName(), pluginConfig7);
        PluginConfig pluginConfig8 = new PluginConfig();
        pluginConfig8.setName(PluginName.MULTI_GRID_VIEW);
        pluginConfig8.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig8.setMajorLevel(500);
        pluginConfig8.setEnable(true);
        hashMap.put(pluginConfig8.getName(), pluginConfig8);
        PluginConfig pluginConfig9 = new PluginConfig();
        pluginConfig9.setName(PluginName.FULL_ERROR);
        pluginConfig9.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig9.setMajorLevel(600);
        pluginConfig9.setEnable(true);
        hashMap.put(pluginConfig9.getName(), pluginConfig9);
        if (context != null && Utils.isYoukuOrHuaweiBaipai(context)) {
            PluginConfig pluginConfig10 = new PluginConfig();
            pluginConfig10.setName(PluginName.FREE_FLOW);
            pluginConfig10.setLayerId(AlixPlayerContext.LAYER_BEYOND);
            pluginConfig10.setMajorLevel(700);
            pluginConfig10.setEnable(true);
            hashMap.put(pluginConfig10.getName(), pluginConfig10);
        }
        return hashMap;
    }

    public static Map<String, PluginConfig> initPlayerPluginConfigs(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-186306752")) {
            return (Map) ipChange.ipc$dispatch("-186306752", new Object[]{context, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        PluginConfig pluginConfig = new PluginConfig();
        pluginConfig.setName(PluginName.PLAYER);
        pluginConfig.setLayerId(AlixPlayerContext.LAYER_UNDER);
        pluginConfig.setMajorLevel(10);
        pluginConfig.setEnable(true);
        pluginConfig.setPlayerIndex(i);
        hashMap.put(pluginConfig.getName(), pluginConfig);
        if (i == 0 && Utils.isYoukuOrHuaweiBaipai(context)) {
            PluginConfig pluginConfig2 = new PluginConfig();
            pluginConfig2.setName(PluginName.AD);
            pluginConfig2.setLayerId(AlixPlayerContext.LAYER_BEYOND);
            pluginConfig2.setMajorLevel(20);
            pluginConfig2.setEnable(true);
            pluginConfig2.setPlayerIndex(i);
            hashMap.put(pluginConfig2.getName(), pluginConfig2);
        }
        PluginConfig pluginConfig3 = new PluginConfig();
        pluginConfig3.setName("loading");
        pluginConfig3.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig3.setMajorLevel(25);
        pluginConfig3.setEnable(true);
        pluginConfig3.setPlayerIndex(i);
        hashMap.put(pluginConfig3.getName(), pluginConfig3);
        PluginConfig pluginConfig4 = new PluginConfig();
        pluginConfig4.setName(PluginName.HBR_AUDIO_PLUGIN);
        pluginConfig4.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig4.setMajorLevel(26);
        pluginConfig4.setEnable(true);
        pluginConfig4.setPlayerIndex(i);
        hashMap.put(pluginConfig4.getName(), pluginConfig4);
        PluginConfig pluginConfig5 = new PluginConfig();
        pluginConfig5.setName("player_error");
        pluginConfig5.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig5.setMajorLevel(30);
        pluginConfig5.setEnable(true);
        pluginConfig5.setPlayerIndex(i);
        hashMap.put(pluginConfig5.getName(), pluginConfig5);
        return hashMap;
    }

    public static Map<String, PluginConfig> initTopLayerPluginConfigs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1650125536")) {
            return (Map) ipChange.ipc$dispatch("-1650125536", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        PluginConfig pluginConfig = new PluginConfig();
        pluginConfig.setName(PluginName.CHANGE_QUALITY);
        pluginConfig.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig.setMajorLevel(100);
        pluginConfig.setEnable(true);
        pluginConfig.setLazyLoad(false);
        hashMap.put(PluginName.CHANGE_QUALITY, pluginConfig);
        PluginConfig pluginConfig2 = new PluginConfig();
        pluginConfig2.setName(PluginName.HBR_PLUGIN);
        pluginConfig2.setLayerId(AlixPlayerContext.LAYER_BEYOND);
        pluginConfig2.setMajorLevel(560);
        pluginConfig2.setEnable(true);
        pluginConfig2.setLazyLoad(false);
        hashMap.put(pluginConfig2.getName(), pluginConfig2);
        return hashMap;
    }
}
