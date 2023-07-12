package com.youku.live.dago.liveplayback.widget.preload;

import android.app.Activity;
import android.content.Context;
import android.media.ImageReader;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.live.dago.liveplayback.widget.AlixPluginCreator;
import com.youku.live.dago.liveplayback.widget.PluginsHelper;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.dsl.config.OptConfigUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerContextContainer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ANY = "*";
    private static final String OFFSCREEN_MODE_BLACK_LIST = "black";
    private static final String OFFSCREEN_MODE_WHITE_LIST = "white";
    private ImageReader mImageReader;
    private boolean mNeedPreAttached;
    private AlixPlayerContext mPlayerContext;
    private FrameLayout mPlayerView;
    private Surface mSurface;

    public PlayerContextContainer(Activity activity, IPlayerContainer iPlayerContainer) {
        this.mNeedPreAttached = true;
        AlixPlayerContext alixPlayerContext = new AlixPlayerContext(activity, false, Utils.getDefaultPlayerConfig(activity));
        this.mPlayerContext = alixPlayerContext;
        alixPlayerContext.setDefaultCreator(new AlixPluginCreator());
        this.mPlayerContext.setPlayerContainer(iPlayerContainer);
        this.mPlayerView = new FrameLayout(activity);
        this.mPlayerContext.loadPlugins(PluginsHelper.initPlayerPluginConfigs(activity, 0), this.mPlayerView);
        int i = Build.VERSION.SDK_INT;
        if (i < getSupportOffscreenSurfaceVersionCode() || i < 19 || !couldUseOffscreenByList()) {
            return;
        }
        iPlayerContainer.getPlayer().setDisplay(SurfaceProvider.getInstance().getSurface());
        this.mNeedPreAttached = false;
    }

    private static boolean couldUseOffscreenByList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31492952")) {
            return ((Boolean) ipChange.ipc$dispatch("31492952", new Object[0])).booleanValue();
        }
        try {
            String string = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString(OptConfigUtils.NAMESAPCE, "supportOffscreenMode", null);
            if (OFFSCREEN_MODE_WHITE_LIST.equals(string)) {
                try {
                    String string2 = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString(OptConfigUtils.NAMESAPCE, "supportOffscreenWhiteList", null);
                    if (!"*".equals(string2)) {
                        if (TextUtils.isEmpty(string2)) {
                            return false;
                        }
                        String deviceModel = DeviceUtils.getDeviceModel();
                        if (!string2.contains("," + deviceModel + ",")) {
                            return false;
                        }
                    }
                } catch (Throwable unused) {
                    return false;
                }
            } else if (OFFSCREEN_MODE_BLACK_LIST.equals(string)) {
                String string3 = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString(OptConfigUtils.NAMESAPCE, "supportOffscreenBlackList", null);
                if ("*".equals(string3)) {
                    return false;
                }
                if (!TextUtils.isEmpty(string3)) {
                    String deviceModel2 = DeviceUtils.getDeviceModel();
                    if (string3.contains("," + deviceModel2 + ",")) {
                        return false;
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return true;
    }

    private static int getSupportOffscreenSurfaceVersionCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1418453737") ? ((Integer) ipChange.ipc$dispatch("-1418453737", new Object[0])).intValue() : OptConfigUtils.getConfigInt("supportOffscreenSurfaceVersionCode", 23);
    }

    public void clear(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143729577")) {
            ipChange.ipc$dispatch("-2143729577", new Object[]{this, context});
        } else {
            SurfaceProvider.getInstance().destroySurface(context);
        }
    }

    public AlixPlayerContext getPlayerContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "244415947") ? (AlixPlayerContext) ipChange.ipc$dispatch("244415947", new Object[]{this}) : this.mPlayerContext;
    }

    public FrameLayout getPlayerView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1201567031") ? (FrameLayout) ipChange.ipc$dispatch("1201567031", new Object[]{this}) : this.mPlayerView;
    }

    public boolean isNeedPreAttached() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2058838715") ? ((Boolean) ipChange.ipc$dispatch("2058838715", new Object[]{this})).booleanValue() : this.mNeedPreAttached;
    }

    public void releasePlayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1476545994")) {
            ipChange.ipc$dispatch("-1476545994", new Object[]{this});
            return;
        }
        try {
            this.mPlayerContext.getPlayerContainer().getPlayer().stop();
            this.mPlayerContext.getPlayerContainer().getPlayer().release();
            this.mPlayerContext.getPlayerContainer().getMultiPlayer().stop();
            this.mPlayerContext.getPlayerContainer().getMultiPlayer().release();
            AlixPlayerContext alixPlayerContext = this.mPlayerContext;
            if (alixPlayerContext != null) {
                alixPlayerContext.destory();
            }
        }
    }
}
