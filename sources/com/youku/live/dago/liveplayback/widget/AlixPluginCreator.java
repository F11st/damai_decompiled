package com.youku.live.dago.liveplayback.widget;

import android.view.ViewGroup;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.base.IPlugin;
import com.youku.alixplugin.base.IPluginCreator;
import com.youku.alixplugin.base.PluginConfig;
import com.youku.live.dago.liveplayback.widget.plugins.TrailPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.danmu.DanmuPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.dlna.DlnaPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.dmmulti.DMMultiViewPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.error.FullErrorPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.error.PlayerErrorPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRAudioPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.loading.LoadingPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.player.PlayerCorePlugin;
import com.youku.live.dago.liveplayback.widget.plugins.quality.ChangeQualityPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.verticalfull.VerticalFullscreenPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin;
import com.youku.live.plugin.freeflow.FreeFlowPlugin;
import com.youku.xadsdk.plugin.AdPlugin;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AlixPluginCreator implements IPluginCreator {
    @Override // com.youku.alixplugin.base.IPluginCreator
    public IPlugin create(AlixPlayerContext alixPlayerContext, PluginConfig pluginConfig, ViewGroup viewGroup) {
        IPlugin dMMultiViewPlugin;
        String name = pluginConfig.getName();
        name.hashCode();
        char c = 65535;
        switch (name.hashCode()) {
            case -1645158280:
                if (name.equals(PluginName.MULTI_GRID_VIEW)) {
                    c = 0;
                    break;
                }
                break;
            case -1635726480:
                if (name.equals(PluginName.CHANGE_QUALITY)) {
                    c = 1;
                    break;
                }
                break;
            case -1459234150:
                if (name.equals(PluginName.HBR_PLUGIN)) {
                    c = 2;
                    break;
                }
                break;
            case -1132874623:
                if (name.equals(PluginName.TOP_TIP_PLUGIN)) {
                    c = 3;
                    break;
                }
                break;
            case -985752863:
                if (name.equals(PluginName.PLAYER)) {
                    c = 4;
                    break;
                }
                break;
            case -980093469:
                if (name.equals(PluginName.HBR_AUDIO_PLUGIN)) {
                    c = 5;
                    break;
                }
                break;
            case -460656552:
                if (name.equals(PluginName.FULL_ERROR)) {
                    c = 6;
                    break;
                }
                break;
            case -433862879:
                if (name.equals(PluginName.FREE_FLOW)) {
                    c = 7;
                    break;
                }
                break;
            case -423962721:
                if (name.equals(PluginName.PLAYER_HORIZONTAL_FULLSCREEN_CONTROL)) {
                    c = '\b';
                    break;
                }
                break;
            case -23038095:
                if (name.equals(PluginName.PLAYER_VERTICAL_FULLSCREEN_CONTROL)) {
                    c = '\t';
                    break;
                }
                break;
            case 3107:
                if (name.equals(PluginName.AD)) {
                    c = '\n';
                    break;
                }
                break;
            case 77488938:
                if (name.equals("player_error")) {
                    c = 11;
                    break;
                }
                break;
            case 91325224:
                if (name.equals(PluginName.PLUGIN_TRAIL)) {
                    c = '\f';
                    break;
                }
                break;
            case 95351033:
                if (name.equals(PluginName.DANMU)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 336650556:
                if (name.equals("loading")) {
                    c = 14;
                    break;
                }
                break;
            case 896985543:
                if (name.equals(PluginName.PLUGIN_DLNA)) {
                    c = 15;
                    break;
                }
                break;
            case 1377378799:
                if (name.equals(PluginName.PLAYER_VERTICAL_SMALLSCREEN_CONTROL)) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                dMMultiViewPlugin = new DMMultiViewPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 1:
                dMMultiViewPlugin = new ChangeQualityPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 2:
                dMMultiViewPlugin = new HBRPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 3:
                dMMultiViewPlugin = new TopTipPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 4:
                dMMultiViewPlugin = new PlayerCorePlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 5:
                dMMultiViewPlugin = new HBRAudioPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 6:
                dMMultiViewPlugin = new FullErrorPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 7:
                dMMultiViewPlugin = new FreeFlowPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case '\b':
                dMMultiViewPlugin = new HorizontalFullscreenPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case '\t':
                dMMultiViewPlugin = new VerticalFullscreenPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case '\n':
                dMMultiViewPlugin = new AdPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 11:
                dMMultiViewPlugin = new PlayerErrorPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case '\f':
                dMMultiViewPlugin = new TrailPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case '\r':
                dMMultiViewPlugin = new DanmuPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 14:
                dMMultiViewPlugin = new LoadingPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 15:
                dMMultiViewPlugin = new DlnaPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            case 16:
                dMMultiViewPlugin = new VerticalSmallscreenPlugin(alixPlayerContext, pluginConfig, viewGroup);
                break;
            default:
                return null;
        }
        return dMMultiViewPlugin;
    }
}
