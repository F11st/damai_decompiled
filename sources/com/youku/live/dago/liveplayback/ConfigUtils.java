package com.youku.live.dago.liveplayback;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.media.arch.instruments.ConfigFetcher;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ConfigUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean enableAsyncPlayer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-543110051") ? ((Boolean) ipChange.ipc$dispatch("-543110051", new Object[0])).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig("laifeng_config", "enable_async_player", "1"));
    }

    public static boolean enableAsyncStopAndRelease() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1247207220") ? ((Boolean) ipChange.ipc$dispatch("-1247207220", new Object[0])).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig("laifeng_config", "enable_async_stopandrelease", "1"));
    }

    public static boolean enableBackgroundPlay(int i) {
        String config;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962554549")) {
            return ((Boolean) ipChange.ipc$dispatch("1962554549", new Object[]{Integer.valueOf(i)})).booleanValue();
        }
        if (i == 3) {
            config = ConfigFetcher.getInstance().getConfig("laifeng_config", "enable_laifeng_background_play", "1");
        } else {
            config = ConfigFetcher.getInstance().getConfig("laifeng_config", "enable_other_background_play", "1");
        }
        return "1".equals(config);
    }

    public static boolean enableChangePeriod() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293186023")) {
            return ((Boolean) ipChange.ipc$dispatch("293186023", new Object[0])).booleanValue();
        }
        return false;
    }

    public static boolean enableDelaySEI(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625317874")) {
            return ((Boolean) ipChange.ipc$dispatch("-1625317874", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "1".equals(ConfigFetcher.getInstance().getConfig("live_delaysei_config", str, "0"));
    }

    public static boolean enableFastPlay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "10359016") ? ((Boolean) ipChange.ipc$dispatch("10359016", new Object[0])).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig("laifeng_config", "enable_fast_play", "1"));
    }

    public static boolean enableInteractSEI(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771179869")) {
            return ((Boolean) ipChange.ipc$dispatch("-771179869", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "1".equals(ConfigFetcher.getInstance().getConfig("live_sei_config", str, "0"));
    }

    public static boolean enableNoSurfacePlay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-213678918") ? ((Boolean) ipChange.ipc$dispatch("-213678918", new Object[0])).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig("laifeng_config", "enable_no_surface", "0"));
    }

    public static boolean enablePickMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-281798476") ? ((Boolean) ipChange.ipc$dispatch("-281798476", new Object[0])).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig("laifeng_config", "enable_pick_mode", "0"));
    }

    public static boolean enablePickModeRotate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1172930841") ? ((Boolean) ipChange.ipc$dispatch("1172930841", new Object[0])).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig("live_config_pick", "enable_pick_mode_rotate", "0"));
    }

    public static boolean enablePlayByLiveidOnwall(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783628583")) {
            return ((Boolean) ipChange.ipc$dispatch("783628583", new Object[]{str})).booleanValue();
        }
        String config = ConfigFetcher.getInstance().getConfig("laifeng_config", "liveids_playonwall", "");
        if (!TextUtils.isEmpty(config)) {
            if (config.contains("," + str + ",")) {
                return true;
            }
        }
        return false;
    }

    public static int getPickSEICountLimit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-543482690")) {
            return ((Integer) ipChange.ipc$dispatch("-543482690", new Object[0])).intValue();
        }
        try {
            return Integer.parseInt(ConfigFetcher.getInstance().getConfig("laifeng_config", "pick_sei_count_limit", "2000"));
        } catch (Exception unused) {
            Logger.d("getPickSEICountLimit error");
            return 2000;
        }
    }

    public static long getSEIInterval() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1311699131")) {
            return ((Long) ipChange.ipc$dispatch("-1311699131", new Object[0])).longValue();
        }
        try {
            return Long.parseLong(ConfigFetcher.getInstance().getConfig("live_sei_config", "sei_interval", "1000"));
        } catch (Exception unused) {
            Logger.d("getSEIInterval error");
            return 1000L;
        }
    }

    public static boolean supportLiveHbr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "941042078") ? ((Boolean) ipChange.ipc$dispatch("941042078", new Object[0])).booleanValue() : "1".equals(ConfigFetcher.getInstance().getConfig("z_real_config", "live_z_real_enable", "0"));
    }
}
